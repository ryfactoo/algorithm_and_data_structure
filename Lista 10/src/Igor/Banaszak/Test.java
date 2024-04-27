package Igor.Banaszak;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Test {


    private int size;
    private double timeTree = 0.0;
    private double timeList = 0.0;



    public Test(int size) {
        this.size = size;
    }

    public void test() {
        testUnionOneElementToOtherList();
        testUnionOneElementToOtherTree();
        System.out.println();
        testUnionSameSizeList();
        testUnionSameSizeTree();
    }

    public void testUnionOneElementToOtherList() {

        ListDisjointSet listDisjointSet = new ListDisjointSet();

        Instant start = Instant.now();

        ELementList eLementList = listDisjointSet.makeSet();

        for (int i = 0; i < size; i++) {
            listDisjointSet.union(eLementList, new ELementList());
        }

        Instant end = Instant.now();

        this.timeList = Duration.between(start, end).toMillis();
        System.out.print("one to other List = " + timeList + "ms" + "\n");

    }

    public void testUnionOneElementToOtherTree() {

        ForestDisjointSet forestDisjointSet = new ForestDisjointSet();

        Instant start = Instant.now();

        ElelmentTree elelmentTree = forestDisjointSet.makeSet();

        for (int i = 0; i < size; i++) {
            forestDisjointSet.union(elelmentTree, new ElelmentTree());
        }

        Instant end = Instant.now();

        this.timeTree = Duration.between(start, end).toMillis();
        System.out.println("one to other Tree = " + timeTree + "ms");

    }


    public void testUnionSameSizeList() {

        ListDisjointSet listDisjointSet = new ListDisjointSet();
        ArrayList<ELementList> listList = new ArrayList();

        Instant start = Instant.now();

        for (long i = 0; i < size; i++) {
            listList.add(listDisjointSet.makeSet());
        }

        int i = 0;

        for (int j = 2; j < size; j += j) {
            for (i = 0; i + j <= size; i += j) {
                listDisjointSet.union(listList.get(i), listList.get(i + j - 1));
            }

            if (size % j != 0) {
                listDisjointSet.union(listList.get(i), listList.get(listList.size() - 1));
            }
        }


        Instant end = Instant.now();

        this.timeList = Duration.between(start, end).toMillis();
        System.out.print("same size List = " + timeList + "ms" + "\n");
    }

    public void testUnionSameSizeTree() {

        ForestDisjointSet forestDisjointSet = new ForestDisjointSet();
        ArrayList<ElelmentTree> listList = new ArrayList();

        Instant start = Instant.now();

        for (long i = 0; i < size; i++) {
            listList.add(forestDisjointSet.makeSet());
        }


        int i = 0;

        for (int j = 2; j < size; j += j) {
            for (i = 0; i + j <= size; i += j) {
                forestDisjointSet.union(listList.get(i), listList.get(i + j - 1));
            }

            if (size % j != 0) {
                forestDisjointSet.union(listList.get(i), listList.get(listList.size() - 1));
            }
        }

        Instant end = Instant.now();

        this.timeTree = Duration.between(start, end).toMillis();
        System.out.print("same size Tree = " + timeTree + "ms" + "\n");
    }
}
