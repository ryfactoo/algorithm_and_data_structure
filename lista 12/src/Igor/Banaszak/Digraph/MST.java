package Igor.Banaszak.Digraph;


import java.util.PriorityQueue;

public class MST {

//    public IWeightedDigraph mstKruskal(IWeightedDigraph graf){
//
//        IWeightedDigraph newGraf;
//
//        if (graf instanceof AdjacencyMatrixWeightedDigraph){
//            newGraf = new AdjacencyMatrixWeightedDigraph(graf.vertexCount());
//        } else {
//            newGraf = new AdjacencyListWeightedDigraph(graf.vertexCount());
//        }
//
//
//
//        int[] arr = new int[graf.vertexCount()];
//        WeightedEdge weightedEdge;
//        double weight;
//
//        for (int i = 0 ; i < arr.length ; i++){
//            arr[i] = i;
//        }
//
//        weightedEdge = new WeightedEdge(0,0,0);
//
//        while (weightedEdge != null) {
//            weightedEdge = null;
//
//            for (int i = 0; i < graf.vertexCount(); i++) {
//                for (int j = 0; j < graf.vertexCount() - i; j++) {
//                    if ((weight = graf.weight(i,j)) != 0 && j != i && arr[i] != arr[j] && (weightedEdge == null || weight < weightedEdge.weight)) {
//                        weightedEdge = new WeightedEdge(i, j, weight);
//                    }
//                }
//            }
//
//            if (weightedEdge != null) {
//                newGraf.addEdgeU(weightedEdge.beginning, weightedEdge.end, weightedEdge.weight);
//                int oldGrup = arr[weightedEdge.end];
//
//                for (int i = 0; i < arr.length; i++) {
//                    if (arr[i] == oldGrup) {
//                        arr[i] = arr[weightedEdge.beginning];
//                    }
//                }
//            }
//        }
//
//        if (newGraf.vertexCount() - 1 != (newGraf.edgeCount()/2)){
//            throw new IllegalArgumentException("nie można stworzyć drzew");
//        }
//
//        return newGraf;
//    }
//
//    public IWeightedDigraph mstPrima(IWeightedDigraph graf){
//        return mstPrima(graf,0);
//    }
//
//
//
//    public IWeightedDigraph mstPrima(IWeightedDigraph graf,int firstVertex){
//        IWeightedDigraph newGraf;
//
//        if (graf instanceof AdjacencyMatrixWeightedDigraph){
//
//            newGraf = new AdjacencyMatrixWeightedDigraph(graf.vertexCount());
//        } else {
//
//            newGraf = new AdjacencyListWeightedDigraph(graf.vertexCount());
//        }
//
//        byte[] arr = new byte[graf.vertexCount()];
//
//        // arr[] = 0  -> add no, connect no
//        // arr[] = 1  -> add no, connect yes
//        // arr[] = 2  -> add yes
//
//        WeightedEdge weightedEdge;
//
//        arr[firstVertex] = 2;
//        int end = -1;
//        double weight =0;
//
//        for (int i = 0 ; i < graf.vertexCount() ; i++){
//
//            if (graf.weight(firstVertex,i) != 0 && i != firstVertex){
//                arr[i] = 1;
//                end = i;
//            }
//        }
//
//        if (end == -1){
//            return newGraf;
//        }
//
//        weightedEdge = new WeightedEdge(firstVertex,end,graf.weight(firstVertex,end));
//
//        while (weightedEdge != null) {
//            weightedEdge = null;
//
//            for (int i = 0; i < graf.vertexCount(); i++) {
//
//                if (arr[i] != 2) {
//                    continue;
//
//                }
//
//                for (int j = 0; j < graf.vertexCount(); j++) {
//
//                    if (arr[j] != 2 && j != i && (weight = graf.weight(i,j)) != 0 && (weightedEdge == null || weight < weightedEdge.weight)) {
//                        weightedEdge = new WeightedEdge(i, j, weight);
//                    }
//                }
//            }
//
//            if (weightedEdge != null) {
//                newGraf.addEdgeU(weightedEdge.beginning, weightedEdge.end, weightedEdge.weight);
//                arr[weightedEdge.end] = 2;
//
//                for (int i = 0; i < graf.vertexCount(); i++) {
//
//                    if (graf.weight(weightedEdge.end, i) != 0 && arr[i] == 0) {
//                        arr[i] = 1;
//                    }
//                }
//            }
//        }
//
//        if (newGraf.vertexCount() - 1 != (newGraf.edgeCount()/2)){
//            throw new IllegalArgumentException("nie można stworzyć drzew");
//        }
//
//        return newGraf;
//    }


    public IWeightedDigraph mstKruskal(IWeightedDigraph graf) {

        PriorityQueue<WeightedEdge> priorityQueue = new PriorityQueue(new ComparatorWeightedEdge());

        IWeightedDigraph newGraf;

        if (graf instanceof AdjacencyMatrixWeightedDigraph) {
            newGraf = new AdjacencyMatrixWeightedDigraph(graf.vertexCount());
        } else {
            newGraf = new AdjacencyListWeightedDigraph(graf.vertexCount());
        }


        int[] arr = new int[graf.vertexCount()];
        WeightedEdge weightedEdge;
        double weight;


        for (int i = 0 ; i < arr.length ; i++){

            arr[i] = i;

            for (int j = 0 ; j < arr.length ; j++){
                if ((weight = graf.weight(i,j)) != 0){
                    priorityQueue.add(new WeightedEdge(i,j,weight));
                }
            }
        }

        weightedEdge = new WeightedEdge(0, 0, 0);

        while (weightedEdge != null) {
            weightedEdge = null;

            while (!priorityQueue.isEmpty() && weightedEdge == null){
                weightedEdge = priorityQueue.poll();

                if (arr[weightedEdge.beginning] == arr[weightedEdge.end]){
                    weightedEdge = null;
                }
            }

            if (weightedEdge != null) {
                newGraf.addEdgeU(weightedEdge.beginning, weightedEdge.end, weightedEdge.weight);
                int oldGrup = arr[weightedEdge.end];
                int count = 0;

                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == oldGrup) {
                        arr[i] = arr[weightedEdge.beginning];
                        count++;
                    }
                }
            }
        }

        if (newGraf.vertexCount() - 1 != (newGraf.edgeCount() / 2)) {
            throw new IllegalArgumentException("nie można stworzyć drzew");
        }

        return newGraf;
    }



    public IWeightedDigraph mstPrima(IWeightedDigraph graf) {
        return mstPrima(graf, 0);
    }



    public IWeightedDigraph mstPrima(IWeightedDigraph graf, int firstVertex) {

        PriorityQueue<WeightedEdge> priorityQueue = new PriorityQueue(new ComparatorWeightedEdge());

        IWeightedDigraph newGraf;

        if (graf instanceof AdjacencyMatrixWeightedDigraph) {

            newGraf = new AdjacencyMatrixWeightedDigraph(graf.vertexCount());
        } else {

            newGraf = new AdjacencyListWeightedDigraph(graf.vertexCount());
        }

        byte[] arr = new byte[graf.vertexCount()];

        // arr[] = 0  -> add no, connect no
        // arr[] = 1  -> add no, connect yes
        // arr[] = 2  -> add yes

        WeightedEdge weightedEdge;

        arr[firstVertex] = 2;
        int end = -1;
        double weight = 0;

        for (int i = 0; i < graf.vertexCount(); i++) {

            if ((weight = graf.weight(firstVertex, i)) != 0 && i != firstVertex) {
                arr[i] = 1;
                end = i;
                priorityQueue.add(new WeightedEdge(firstVertex,i,weight));
            }
        }

        if (end == -1) {
            return newGraf;
        }

        weightedEdge = new WeightedEdge(firstVertex, end, graf.weight(firstVertex, end));

        while (weightedEdge != null) {

            weightedEdge = null;

            while (!priorityQueue.isEmpty() && weightedEdge == null){
                weightedEdge = priorityQueue.poll();

                if (arr[weightedEdge.beginning] != 2 || arr[weightedEdge.end] != 1){
                    weightedEdge = null;
                }
            }

            if (weightedEdge != null) {
                newGraf.addEdgeU(weightedEdge.beginning, weightedEdge.end, weightedEdge.weight);
                arr[weightedEdge.end] = 2;

                for (int i = 0; i < graf.vertexCount(); i++) {

                    if (arr[i] == 0 && graf.weight(weightedEdge.end, i) != 0) {
                        arr[i] = 1;
                    }
                }
            }
        }

        if (newGraf.vertexCount() - 1 != (newGraf.edgeCount() / 2)) {
            throw new IllegalArgumentException("nie można stworzyć drzew");
        }

        return newGraf;
    }
}
