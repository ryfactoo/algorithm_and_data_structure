package Igor.Banaszak;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Timer {

    private static double insertTimeBST = 0.0;
    private static double insertTimeHBST = 0.0;
    private static double searchTimeBST = 0.0;
    private static double searchTimeHBST = 0.0;
    private static double removingTimeBST = 0.0;
    private static double removingTimeHBST = 0.0;

    public static void start(int size,int repetitions){
        Comparator<Integer> comparator = new ComparatorIntiger();
        BST<Integer> BST = new BST<Integer>(comparator);
        HeapyBinarySearchTree<Integer> HBST = new HeapyBinarySearchTree<Integer>(comparator);
        String bst = "\nBINARY SEARCH TREE";
        String hbst = "HEAPY BINARY SEARCH TREE";

        List<Integer> list1;
        for(int i = 0; i < repetitions; i++) {
            BST.clear();
            HBST.clear();
            list1 = (java.util.List<Integer>) generateList(size);
            insertBoth(list1, BST, HBST);
            Collections.shuffle(list1);
            searchBoth(list1, BST, HBST);
            Collections.shuffle(list1);
            removeBoth(list1, BST, HBST);
        }

        printStatistics(doubleToString(insertTimeBST/repetitions), bst,"INSERT");
        printStatistics(doubleToString(insertTimeHBST/repetitions), hbst,"INSERT");
        printStatistics(doubleToString(searchTimeBST/repetitions), bst,"SEARCHING");
        printStatistics(doubleToString(searchTimeHBST/repetitions), hbst,"SEARCHING");
        printStatistics(doubleToString(removingTimeBST/repetitions), bst,"REMOVING");
        printStatistics(doubleToString(removingTimeHBST/repetitions), hbst,"REMOVING");
    }

    private static List<Integer> generateList(int size){
        List<Integer> list = new ArrayList<Integer>(size);
        for(int i = 1; i <= size; i++){
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }

    private static void insertBoth(List<Integer> list, BST<Integer> BST, HeapyBinarySearchTree<Integer> HBST){
        long start = System.currentTimeMillis();

        for(int i = 0; i < list.size(); i++){
            BST.add(list.get(i));
        }

        long end = System.currentTimeMillis();

        insertTimeBST += end-start;

        start = System.currentTimeMillis();

        for(int i = 0; i < list.size(); i++){
            HBST.add(list.get(i));
        }

        end = System.currentTimeMillis();

        insertTimeHBST += end-start;
    }

    private static void searchBoth(List<Integer> list, BST<Integer> BST, HeapyBinarySearchTree<Integer> HBST){
        long start = System.currentTimeMillis();

        for(int i = 0; i < list.size(); i++){
            BST.getElement(list.get(i));
        }

        long end = System.currentTimeMillis();

        searchTimeBST += end-start;

        start = System.currentTimeMillis();

        for(int i = 0; i < list.size(); i++){
            HBST.getElement(list.get(i));
        }

        end = System.currentTimeMillis();

        searchTimeHBST += end-start;
    }

    private static void removeBoth(List<Integer> list, BST<Integer> BST, HeapyBinarySearchTree<Integer> HBST){
        long start = System.currentTimeMillis();

        for(int i = 0; i < list.size(); i++){
            BST.remove(list.get(i));
        }

        long end = System.currentTimeMillis();

        removingTimeBST += end - start;

        start = System.currentTimeMillis();

        for(int i = 0; i < list.size(); i++){
            HBST.remove(list.get(i));
        }

        end = System.currentTimeMillis();

        removingTimeHBST += end - start;
    }

    private static void printStatistics(String time, String label, String method){
        System.out.println(label + " " + method);
        System.out.println("time: " + time + " [ms]");
    }

    private static String doubleToString(double value){
        return String.format("%.12f", value);
    }
}


