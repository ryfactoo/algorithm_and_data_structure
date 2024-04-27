package Igor.Banaszak.Digraph;

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

        }else {
            list[u].add(v,w);
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
}
