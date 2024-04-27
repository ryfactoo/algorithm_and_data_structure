package Igor.Banaszak;

import Igor.Banaszak.Digraph.AdjacencyListWeightedDigraph;
import Igor.Banaszak.Digraph.AdjacencyMatrixWeightedDigraph;
import Igor.Banaszak.Digraph.MST;

import java.time.Duration;
import java.time.Instant;

public class Test {
    int size;
    int firstVertexPrime = 0;
    AdjacencyMatrixWeightedDigraph matrix;
    AdjacencyListWeightedDigraph list;

    public Test(int n,int firstVertexPrima){
        this.size = n;
        this.firstVertexPrime = firstVertexPrima;
    }

    public Test(int n){
        this.size = n;
    }

    public void test(){
        completeGraph();
        twoEdgesGraph();
        tenPercentEdges();
        halfEdges();
    }

    private void completeGraph(){

        matrix = new AdjacencyMatrixWeightedDigraph(size);
        list = new AdjacencyListWeightedDigraph(size);

        int weight;

        for (int i = 0 ; i < size ; i++){
            for (int j = 0 ; j < size ; j++){
                weight = (int)(Math.random()*10000);
                list.addEdgeU(i,j,weight);
                matrix.addEdgeU(i,j,weight);
            }
        }

        System.out.println("CompleteGraph");
        System.out.println();
        print();
        System.out.println("----------------------------------");
    }

    private void twoEdgesGraph(){

        matrix = new AdjacencyMatrixWeightedDigraph(size);
        list = new AdjacencyListWeightedDigraph(size);

        int weight;

        for (int i = 0 ; i < size ; i++){
            weight = (int)(Math.random()*10000);
            list.addEdgeU(i,size-i-1,weight);
            matrix.addEdgeU(i,size-i-1,weight);

            weight = (int)(Math.random()*10000);
            list.addEdgeU(i,(int)Math.random()*size,weight);
            matrix.addEdgeU(i,(int)Math.random()*size,weight);
        }

        System.out.println("TwoEdgeGraph");
        System.out.println();
        print();
        System.out.println("----------------------------------");
    }

    private void print(){
        MST mst = new MST();

        Instant start;
        Instant end;


        start = Instant.now();
        mst.mstPrima(matrix,firstVertexPrime);
        end = Instant.now();
        System.out.println("matrix prime : " +Duration.between(start, end).toMillis() + "ms");

        start = Instant.now();
        mst.mstKruskal(matrix);
        end = Instant.now();
        System.out.println("matrix kruskal : " +Duration.between(start, end).toMillis() + "ms");

        start = Instant.now();
        mst.mstPrima(list,firstVertexPrime);
        end = Instant.now();
        System.out.println("list prime : " +Duration.between(start, end).toMillis() + "ms");

        start = Instant.now();
        mst.mstKruskal(list);
        end = Instant.now();
        System.out.println("list kruskal : " +Duration.between(start, end).toMillis() + "ms");
    }

    private void halfEdges(){

    }

    private void tenPercentEdges(){

        matrix = new AdjacencyMatrixWeightedDigraph(size);
        list = new AdjacencyListWeightedDigraph(size);

        int weight;

        for (int i = 0 ; i < size ; i++){
            weight = (int)(Math.random()*10000);
            list.addEdgeU(i,size-i-1,weight);
            matrix.addEdgeU(i,size-i-1,weight);

            for (int j = 0 ; j < size*0.1 ; j++) {
                weight = (int) (Math.random() * 10000);
                list.addEdgeU(i, (int) Math.random() * size, weight);
                matrix.addEdgeU(i, (int) Math.random() * size, weight);
            }
        }

        System.out.println("TenPercentEdges");
        System.out.println();
        print();
        System.out.println("----------------------------------");
    }
}
