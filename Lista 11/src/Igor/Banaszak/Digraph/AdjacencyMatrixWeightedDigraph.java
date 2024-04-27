package Igor.Banaszak.Digraph;

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
        return new IteratorDigrapghList(v);
    }


    private class IteratorDigrapghList implements Iterator {

        WeightedEdge weightedEdge;

        public IteratorDigrapghList(int v){
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
}
