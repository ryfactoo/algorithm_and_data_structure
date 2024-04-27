package Igor.Banaszak;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

//        ArrayHeap arrayHeap = new ArrayHeap(2,new ComparatotIntiger());
//
//        for (int i = 0 ; i < 16; i++) {
//            arrayHeap.add(i);
//        }

//        arrayHeap.clear();
//        arrayHeap.printheap();
//        arrayHeap.minimum();


//        TreeHeap treeHeap = new TreeHeap(new ComparatotIntiger());
//
//        for (int i = 1 ; i < 25 ; i++) {
//            treeHeap.add(8-i);
//        }
//
//        treeHeap.printheap();
//        treeHeap.minimum();
//        treeHeap.minimum();
//        treeHeap.minimum();
//        treeHeap.minimum();


//        PriorityQueueSorter priorityQueueSorter = new PriorityQueueSorter(new ArrayHeap(5,new ComparatotIntiger()));
//
//        ArrayList list = new ArrayList();
//
//
//        for (int i = 1 ; i < 10000; i++) {
//
//            list.add((int)( Math.random()*10000000));
//
//        }
//
//        priorityQueueSorter.sort(list);

        System.out.println(1/2);

        Test test = new Test(10000,10,new ComparatotIntiger());
        test.testTree();
        test.testArr();

    }
}
