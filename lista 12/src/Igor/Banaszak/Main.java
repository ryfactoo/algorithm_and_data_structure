package Igor.Banaszak;

import Igor.Banaszak.Digraph.AdjacencyListWeightedDigraph;
import Igor.Banaszak.Digraph.AdjacencyMatrixWeightedDigraph;
import Igor.Banaszak.Loader.ListGraphLoader;
import Igor.Banaszak.Loader.MalformedGraphDescriptionException;
import Igor.Banaszak.Loader.MartixGraphLoader;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws MalformedGraphDescriptionException {

        AdjacencyMatrixWeightedDigraph adjacencyMatrixWeightedDigraph = new AdjacencyMatrixWeightedDigraph(5);
//        System.out.println(adjacencyMatrixWeightedDigraph.edgeCount());
//
        AdjacencyListWeightedDigraph adjacencyListWeightedDigraph = new AdjacencyListWeightedDigraph(5);
//
//        Iterator iterator = adjacencyListWeightedDigraph.edges(1);
//
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//

//
//        System.out.println(adjacencyListWeightedDigraph.removeEdge(1,1));
//        System.out.println(adjacencyListWeightedDigraph.addEdge(1,1,2.5));
//        System.out.println(adjacencyListWeightedDigraph.removeEdge(1,1));
//
//        adjacencyListWeightedDigraph = ListGraphLoader.loadDirectedGraph("C:/Users/Igor/Desktop/graph2.txt");
//        System.out.println(adjacencyListWeightedDigraph.edgeCount());
//
//        adjacencyMatrixWeightedDigraph = Converter.convert(adjacencyListWeightedDigraph);
//
//        adjacencyMatrixWeightedDigraph = MartixGraphLoader.loadDirectedGraph("C:/Users/Igor/Desktop/AISD.txt");
//        System.out.println(adjacencyMatrixWeightedDigraph.edgeCount());
//
//        adjacencyListWeightedDigraph = Converter.convert(adjacencyMatrixWeightedDigraph);
//


//        SAME EDGE
//        boolean error = false;
//        for (int i = 0 ; i < adjacencyMatrixWeightedDigraph.vertexCount() ; i++){
//            for (int j = 0 ; j < adjacencyMatrixWeightedDigraph.vertexCount() ; j++) {
//                if (adjacencyListWeightedDigraph.hasEdge(i,j) != adjacencyMatrixWeightedDigraph.hasEdge(i,j)){
//                    error = true;
//                }
//            }
//        }
//
//        Iterator iterator = adjacencyListWeightedDigraph.edges(1);
//
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//
//        System.out.println("SAME EDGE : " + !error);

//        adjacencyMatrixWeightedDigraph.addEdgeU(1,2,1);
//        adjacencyMatrixWeightedDigraph.addEdgeU(1,3,10);
//        adjacencyMatrixWeightedDigraph.addEdgeU(1,4,11);
//        adjacencyMatrixWeightedDigraph.addEdgeU(2,3,12);
//        adjacencyMatrixWeightedDigraph.addEdgeU(0,3,13);
//        adjacencyMatrixWeightedDigraph.addEdgeU(4,3,14);
//
//
//
//        adjacencyMatrixWeightedDigraph.mstPrima(1);
//        adjacencyMatrixWeightedDigraph.mstKruskal();


//        adjacencyListWeightedDigraph.addEdgeU(1,2,1);
//        adjacencyListWeightedDigraph.addEdgeU(1,3,10);
//        adjacencyListWeightedDigraph.addEdgeU(1,4,11);
//        adjacencyListWeightedDigraph.addEdgeU(2,3,12);
//        adjacencyListWeightedDigraph.addEdgeU(0,3,13);
//        adjacencyListWeightedDigraph.addEdgeU(4,3,14);
//
//
//
//        adjacencyListWeightedDigraph.mstPrima(0);
//        adjacencyListWeightedDigraph.mstKruskal();


        Test test = new Test(250);
        test.test();
    }
}
