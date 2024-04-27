package Igor.Banaszak;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test {
  private ArrayList list = new ArrayList();
    private  Comparator comparator;
    private int repetitions;
    private double averageTimeBTS = 0.0;
    private double averageTimeSquaredBST = 0.0;
    private double averageTimeHeapy = 0.0;
    private double averageTimeSquaredHeapy = 0.0;
    private Long time;


    public Test(int size, Comparator comparator, int repetitions){

        this.repetitions = repetitions;
        this.comparator = comparator;

        for (int i = 0 ; i < size ; i++) {
            list.add(i);
        }

    }

    public void test(){

        HeapyBinarySearchTree heapyBinarySearchTree = new HeapyBinarySearchTree(comparator);
        BST bst = new BST(comparator);

        ArrayList listShuffle = new ArrayList(list);

        for (int n = 0; n < repetitions; n++) {

            Collections.shuffle(listShuffle);
            Collections.shuffle(list);

            Instant start = Instant.now();

            for (int i = 0; i < list.size(); i++) {
                heapyBinarySearchTree.add(list.get(i));
            }

            for (int i = 0; i < list.size(); i++) {
                heapyBinarySearchTree.remove(listShuffle.get(i));
            }


            Instant end = Instant.now();
            this.time = Duration.between(start, end).toMillis();

            averageTimeHeapy = updatedAverage(averageTimeHeapy, time, n + 1);
            averageTimeSquaredHeapy = updatedAverage(averageTimeSquaredHeapy,
                    (double) time * (double) time, n + 1);


            // BST

            Instant startBST = Instant.now();

            for (int i = 0; i < list.size(); i++) {
                bst.add(list.get(i));
            }

            for (int i = 0; i < list.size(); i++) {
                bst.remove((int)listShuffle.get(i));
            }


            Instant endBST = Instant.now();
            this.time = Duration.between(startBST, endBST).toMillis();

            averageTimeBTS = updatedAverage(averageTimeBTS, time, n + 1);
            averageTimeSquaredBST = updatedAverage(averageTimeSquaredBST,
                    (double) time * (double) time, n + 1);
            bst.clear();

        }


        System.out.println();
        System.out.println("heapyBinarySearchTree" + "\n" + "time [ms] " + averageTimeHeapy + " +- " + calculateStdDev(averageTimeHeapy, averageTimeSquaredHeapy));
        System.out.println();


        System.out.println();
        System.out.println("BST" + "\n" + "time [ms] " + averageTimeBTS + " +- " + calculateStdDev(averageTimeBTS, averageTimeSquaredBST));
        System.out.println();




    }

    public void testSorted(){

        HeapyBinarySearchTree heapyBinarySearchTree = new HeapyBinarySearchTree(comparator);
        BST bst = new BST(comparator);

        ArrayList listShuffle = new ArrayList(list);

        for (int n = 0; n < repetitions; n++) {

            Collections.shuffle(listShuffle);

            Instant start = Instant.now();

            for (int i = 0; i < list.size(); i++) {
                heapyBinarySearchTree.add(list.get(i));
            }

            for (int i = 0; i < list.size(); i++) {
                heapyBinarySearchTree.remove(listShuffle.get(i));
            }


            Instant end = Instant.now();
            this.time = Duration.between(start, end).toMillis();

            averageTimeHeapy = updatedAverage(averageTimeHeapy, time, n + 1);
            averageTimeSquaredHeapy = updatedAverage(averageTimeSquaredHeapy,
                    (double) time * (double) time, n + 1);


            // BST

            Instant startBST = Instant.now();

            for (int i = 0; i < list.size(); i++) {
                bst.add(list.get(i));
            }

            for (int i = 0; i < list.size(); i++) {
                bst.remove((int)listShuffle.get(i));
            }


            Instant endBST = Instant.now();
            this.time = Duration.between(startBST, endBST).toMillis();

            averageTimeBTS = updatedAverage(averageTimeBTS, time, n + 1);
            averageTimeSquaredBST = updatedAverage(averageTimeSquaredBST,
                    (double) time * (double) time, n + 1);
            bst.clear();

        }


        System.out.println();
        System.out.println("heapyBinarySearchTree" + "\n" + "time [ms] " + averageTimeHeapy + " +- " + calculateStdDev(averageTimeHeapy, averageTimeSquaredHeapy));
        System.out.println();


        System.out.println();
        System.out.println("BST" + "\n" + "time [ms] " + averageTimeBTS + " +- " + calculateStdDev(averageTimeBTS, averageTimeSquaredBST));
        System.out.println();




    }

    private static double updatedAverage(double average, double value, int n) {
        return average + (value - average) / n;
    }

    private static double calculateStdDev(double average, double averagedSquares) {
        return Math.sqrt(averagedSquares - (average * average));
    }
}
