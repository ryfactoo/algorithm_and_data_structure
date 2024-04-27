package Igor.Banaszak.Digraph;

import Igor.Banaszak.Loader.MartixGraphLoader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdjacencyMatrixWeightedDigraph implements IWeightedDigraph {

    private double[][] matrix;

    public AdjacencyMatrixWeightedDigraph(int numberOfVertices){

        if(numberOfVertices < 1){
            throw new IllegalArgumentException();

        }

        this.matrix = new double[numberOfVertices][numberOfVertices];
    }


    public int edgeCount() {
        int count = 0;

        for (int i = 0 ; i < matrix.length ; i++){
            for (int j = 0 ; j < matrix.length ; j++){
                if (matrix[i][j] != 0){
                    count++;
                }
            }
        }
        return count;
    }


    public int vertexCount() {
        return matrix.length;
    }


    public boolean addEdge(int u, int v, double w) {

        if (matrix[u][v] != 0) {
            return false;
        }
        matrix[u][v] = w;
        return true;

    }


    public boolean addEdgeU(int u, int v, double w) {

        if (matrix[u][v] != 0 || matrix[v][u] != 0) {
            return false;

        }

        matrix[v][u] = w;
        matrix[u][v] = w;

        return true;
    }


    public boolean removeEdge(int u, int v) {

        if (matrix[u][v] == 0) {
            return false;
        }

        matrix[u][v] = 0;
        return true;
    }


    public boolean removeEdgeU(int u, int v) {

        if (matrix[u][v] != matrix[v][u] || matrix[u][v] != 0) {
            return false;

        }

        matrix[u][v] = 0;
        matrix[v][u] = 0;

        return true;
    }


    public boolean hasEdge(int u, int v) {

        if (matrix[u][v] != 0) {
            return true;

        }else {
            return false;
        }
    }


    public boolean hasEdgeU(int u, int v) {
        if (matrix[u][v] != matrix[v][u] || matrix[u][v] != 0){
            return false;
        }

        return true;
    }


    public List<Integer> verticesConnectedTo(int v) {
        List list = new ArrayList();

        for (int i = 0 ; i < matrix.length ; i++){
            if (matrix[v][i] != 0){
                list.add(i);
            }
        }

        return list;
    }


    public double weight(int u, int v) {
        if (hasEdge(u,v)){
            return matrix[u][v];
        }

        return Double.POSITIVE_INFINITY;
    }


    public void weight(int u, int v, double w) {
        if (hasEdge(u,v)){
            matrix[u][v] = w;
        }
    }


    public Iterator<WeightedEdge> edges(int v) {
        return new IteratorDigrapghMatrix(v);
    }


    private class IteratorDigrapghMatrix implements Iterator {

        WeightedEdge weightedEdge;

        public IteratorDigrapghMatrix(int v){
            this.weightedEdge = new WeightedEdge(v,-1,0);
        }

        public boolean hasNext() {

            double weight;

            for (int i = weightedEdge.end + 1; i < matrix.length ; i++){

                if ((weight = matrix[weightedEdge.beginning][i]) != 0){
                    this.weightedEdge = new WeightedEdge(weightedEdge.beginning,i,weight);
                    return true;
                }
            }

            weightedEdge = null;
            return false;
        }



        public Object next() {
            return weightedEdge;
        }
    }


    public AdjacencyMatrixWeightedDigraph mstKruskal(){

        AdjacencyMatrixWeightedDigraph adjacencyMatrixWeightedDigraph = new AdjacencyMatrixWeightedDigraph(matrix.length);
        int[] arr = new int[matrix.length];
        WeightedEdge weightedEdge;

        for (int i = 0 ; i < arr.length ; i++){
            arr[i] = i;
        }

        weightedEdge = new WeightedEdge(0,0,0);

        while (weightedEdge != null) {
            weightedEdge = null;

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length - i; j++) {

                    if (matrix[i][j] != 0 && j != i && arr[i] != arr[j] && (weightedEdge == null || matrix[i][j] < weightedEdge.weight)) {
                        weightedEdge = new WeightedEdge(i, j, matrix[i][j]);
                    }
                }
            }

            if (weightedEdge != null) {
                adjacencyMatrixWeightedDigraph.addEdgeU(weightedEdge.beginning, weightedEdge.end, weightedEdge.weight);

                int oldGrup = arr[weightedEdge.end];

                for (int i = 0; i < arr.length; i++) {

                    if (arr[i] == oldGrup) {
                        arr[i] = arr[weightedEdge.beginning];
                    }
                }
            }
        }

        if (adjacencyMatrixWeightedDigraph.vertexCount() - 1 != (adjacencyMatrixWeightedDigraph.edgeCount()/2)){
            throw new IllegalArgumentException("nie można stworzyć drzew");
        }

        return adjacencyMatrixWeightedDigraph;
    }



    public AdjacencyMatrixWeightedDigraph mstPrima(){
        return mstPrima(0);
    }



    public AdjacencyMatrixWeightedDigraph mstPrima(int firstVertex){

        AdjacencyMatrixWeightedDigraph adjacencyMatrixWeightedDigraph = new AdjacencyMatrixWeightedDigraph(matrix.length);
        byte[] arr = new byte[matrix.length];

        // arr[] = 0  -> add no, connect no
        // arr[] = 1  -> add no, connect yes
        // arr[] = 2  -> add yes

        WeightedEdge weightedEdge;

        arr[firstVertex] = 2;
        int end = -1;

        for (int i = 0 ; i < matrix.length ; i++){

            if (matrix[firstVertex][i] != 0 && i != firstVertex){
                arr[i] = 1;
                end = i;
            }
        }

        if (end == -1){
            return adjacencyMatrixWeightedDigraph;
        }

        weightedEdge = new WeightedEdge(firstVertex,end,matrix[firstVertex][end]);

        while (weightedEdge != null) {
            weightedEdge = null;

            for (int i = 0; i < matrix.length; i++) {

                if (arr[i] != 2) {
                    continue;

                }

                for (int j = 0; j < matrix.length; j++) {

                    if (arr[j] != 2 && j != i && matrix[i][j] != 0 && (weightedEdge == null || matrix[i][j] < weightedEdge.weight)) {
                        weightedEdge = new WeightedEdge(i, j, matrix[i][j]);
                    }
                }
            }

            if (weightedEdge != null) {
                adjacencyMatrixWeightedDigraph.addEdgeU(weightedEdge.beginning, weightedEdge.end, weightedEdge.weight);
                arr[weightedEdge.end] = 2;

                for (int i = 0; i < matrix.length; i++) {

                    if (matrix[weightedEdge.end][i] != 0 && arr[i] == 0) {
                        arr[i] = 1;
                    }
                }
            }
        }

        if (adjacencyMatrixWeightedDigraph.vertexCount() - 1 != (adjacencyMatrixWeightedDigraph.edgeCount()/2)){
            throw new IllegalArgumentException("nie można stworzyć drzew");
        }

        return adjacencyMatrixWeightedDigraph;
    }
}
