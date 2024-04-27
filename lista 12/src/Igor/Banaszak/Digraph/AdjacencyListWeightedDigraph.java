package Igor.Banaszak.Digraph;

import Igor.Banaszak.Loader.MalformedGraphDescriptionException;

import java.util.Iterator;
import java.util.List;

public class AdjacencyListWeightedDigraph implements IWeightedDigraph {


    private ILinkedList[] list ;

    public AdjacencyListWeightedDigraph(int numberOfVertices){

        if(numberOfVertices < 1){
            throw new IllegalArgumentException();

        }

        this.list = new ILinkedList[numberOfVertices];

        for (int i = 0 ; i < numberOfVertices ; i++){
            list[i] = new ILinkedList();
        }
    }

    public int edgeCount() {
        int count = 0;

        for (int i = 0 ; i < list.length; i++){
            count += list[i].size();
        }
        return count;
    }


    public int vertexCount() {
        return list.length;
    }


    public boolean addEdge(int u, int v, double w) {

        if (list[u].contain(v)){
            return false;
        }

        list[u].add(v,w);
        return true;
    }


    public boolean addEdgeU(int u, int v, double w) {

        if (list[u].contain(u) || list[u].contain(v)){
            return false;

        }else if (u != v){
            list[u].add(v,w);
            list[v].add(u,w);
            return true;
        }else {
            list[v].add(u,w);
            return true;
        }
    }


    public boolean removeEdge(int u, int v) {
        return list[u].remove(v);
    }


    public boolean removeEdgeU(int u, int v) {

        if (list[u].contain(v) && list[v].contain(u) && list[u].weight(v) == list[v].weight(u)){
            return false;
        }

        list[u].remove(v);
        list[v].remove(u);
        return true;
    }


    public boolean hasEdge(int u, int v) {
        return list[u].contain(v);
    }


    public boolean hasEdgeU(int u, int v) {
        double j = list[u].weight(v);
        return (j != 0 && j == list[v].weight(u));
    }


    public List<Integer> verticesConnectedTo(int v) {
        return list[v].verticesConnectedTo();
    }


    public double weight(int u, int v) {

       double weight = list[u].weight(v);

       if (weight == 0){
           return Double.POSITIVE_INFINITY;
       }

       return weight;
    }


    public void weight(int u, int v, double w) {
        list[u].setWeight(v,w);
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

            int u;

            if ((u = list[weightedEdge.beginning].next(weightedEdge.end)) != -1){
                weightedEdge = new WeightedEdge(weightedEdge.beginning,u,list[weightedEdge.beginning].weight(u));
                return true;
            }

            weightedEdge = null;
            return false;
        }



        public Object next() {
            return weightedEdge;
        }
    }


    public AdjacencyListWeightedDigraph mstKruskal(){
        AdjacencyListWeightedDigraph adjacencyListWeightedDigraph = new AdjacencyListWeightedDigraph(list.length);

        int[] arr = new int[list.length];

        WeightedEdge weightedEdge;
        int u = -1;
        double weight =0;

        for (int i = 0 ; i < arr.length ; i++){
            arr[i] = i;
        }

        weightedEdge = new WeightedEdge(0,0,0);

        while (weightedEdge != null){
            weightedEdge = null;

            for (int i = 0 ; i < list.length ; i++) {

                while ((u = list[i].next(u)) != -1) {

                    if (u != i &&  arr[i] != arr[u] && (weightedEdge == null || (weight = list[i].weight(u)) < weightedEdge.weight)) {

                        if (weightedEdge == null) {
                            weight = list[i].weight(u);
                        }

                        weightedEdge = new WeightedEdge(i, u, weight);
                    }
                }
            }

            if (weightedEdge != null) {
                adjacencyListWeightedDigraph.addEdgeU(weightedEdge.beginning, weightedEdge.end, weightedEdge.weight);

                int oldGrup = arr[weightedEdge.end];

                for (int i = 0; i < arr.length; i++) {

                    if (arr[i] == oldGrup) {
                        arr[i] = arr[weightedEdge.beginning];
                    }
                }
            }
        }


        if (adjacencyListWeightedDigraph.vertexCount() - 1 != (adjacencyListWeightedDigraph.edgeCount()/2)){
            throw new IllegalArgumentException("nie można stworzyć drzew");
        }

        return adjacencyListWeightedDigraph;
    }


    public AdjacencyListWeightedDigraph mstPrima(){
        return mstPrima(0);
    }

    public AdjacencyListWeightedDigraph mstPrima(int firstVertex){

        AdjacencyListWeightedDigraph adjacencyListWeightedDigraph = new AdjacencyListWeightedDigraph(list.length);

        byte[] arr = new byte[list.length];

        // arr[] = 0  -> add no, connect no
        // arr[] = 1  -> add no, connect yes
        // arr[] = 2  -> add yes

        WeightedEdge weightedEdge;
        int u = -1;
        double weight =0;


        while ((u = list[firstVertex].next(u)) != -1){
            arr[u] = 1;
        }

        arr[firstVertex] = 2;

        weightedEdge = new WeightedEdge(0,0,0);

        while (weightedEdge != null){
            weightedEdge = null;

            for (int i = 0 ; i < list.length ; i++){

                if (arr[i] == 2){

                    while ((u = list[i].next(u)) != -1){

                        if (arr[u] != 2 && u != i && (weightedEdge == null || (weight = list[i].weight(u)) < weightedEdge.weight)) {

                            if (weightedEdge == null){
                                weight = list[i].weight(u);
                            }

                            weightedEdge = new WeightedEdge(i, u, weight);
                        }
                    }
                }
            }

            if (weightedEdge != null) {
                adjacencyListWeightedDigraph.addEdgeU(weightedEdge.beginning, weightedEdge.end, weightedEdge.weight);
                arr[weightedEdge.end] = 2;

                while ((u = list[weightedEdge.end].next(u)) != -1){

                    if (arr[u] == 0) {
                        arr[u] = 1;
                    }
                }
            }
        }


        if (adjacencyListWeightedDigraph.vertexCount() - 1 != (adjacencyListWeightedDigraph.edgeCount()/2)){
            throw new IllegalArgumentException("nie można stworzyć drzew");
        }

        return adjacencyListWeightedDigraph;
    }
}
