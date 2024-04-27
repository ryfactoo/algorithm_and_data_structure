package Igor.Banaszak;

import Igor.Banaszak.Digraph.AdjacencyListWeightedDigraph;
import Igor.Banaszak.Digraph.AdjacencyMatrixWeightedDigraph;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static AdjacencyMatrixWeightedDigraph convert(AdjacencyListWeightedDigraph list){

        AdjacencyMatrixWeightedDigraph matrix = new AdjacencyMatrixWeightedDigraph(list.vertexCount());
        List arraylist = new ArrayList();

        for (int i = 0 ; i < list.vertexCount() ; i++){
            arraylist = list.verticesConnectedTo(i);

            for (Object integer : arraylist){
                matrix.addEdge(i,(Integer) integer,list.weight(i,(Integer) integer));
            }
        }

        return matrix;
    }

    public static AdjacencyListWeightedDigraph convert(AdjacencyMatrixWeightedDigraph matrix){

        AdjacencyListWeightedDigraph list = new AdjacencyListWeightedDigraph(matrix.vertexCount());
        double weight = 0;

        for (int i = 0 ; i < matrix.vertexCount() ; i++){
            for (int j = 0 ; j < matrix.vertexCount() ; j++){

                if ((weight = matrix.weight(i,j)) != Double.POSITIVE_INFINITY){
                    list.addEdge(i,j,weight);
                }
            }
        }

        return list;
    }
}
