package Igor.Banaszak;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Test {
    private int elements;
    private int repetitions;
    Comparator comparator;
    double averageTime = 0.0;
    double averageTimeSquared = 0.0;
    private ArrayList<ArrayList> listOfLists;

    public Test(int elements, int repetitions, Comparator comparator){
        this.elements = elements;
        this.repetitions = repetitions;
        this.comparator = comparator;

        ArrayList listOfLists = new ArrayList();

        for (int n = 1; n <= repetitions; ++n) {

            ArrayList list = new ArrayList();
            Random random = new Random();

            for (int i = 0; i < elements; i++) {
                list.add(Math.abs(random.nextInt() % 50000000));
            }

            listOfLists.add(list);
        }

        this.listOfLists = listOfLists;
    }

    public void testTree() {


        averageTime = 0.0;
        averageTimeSquared = 0.0;

        ArrayList list = new ArrayList();

        for (int n = 0; n < listOfLists.size(); ++n) {

            list = (ArrayList) listOfLists.get(n).clone();

            PriorityQueueSorter priorityQueueSorter = new PriorityQueueSorter(new TreeHeap(comparator));

            priorityQueueSorter.sort(list);

            averageTime = updatedAverage(averageTime, priorityQueueSorter.getTime(), n+1);
            averageTimeSquared = updatedAverage(averageTimeSquared,
                    (double) priorityQueueSorter.getTime() * (double) priorityQueueSorter.getTime(), n+1);
        }


        System.out.println("treeHeap" + "\n" + "time [ms] " + averageTime + " +- " + calculateStdDev(averageTime, averageTimeSquared));

    }

        public void testArr() {

            averageTime = 0.0;
            averageTimeSquared = 0.0;

            ArrayList list = new ArrayList();

            for (int n = 0; n < listOfLists.size(); ++n) {

                PriorityQueueSorter priorityQueueSorter = new PriorityQueueSorter(new ArrayHeap(10,comparator));


                list = (ArrayList) listOfLists.get(n).clone();

                priorityQueueSorter.sort(list);

                averageTime = updatedAverage(averageTime, priorityQueueSorter.getTime(), n+1);
                averageTimeSquared = updatedAverage(averageTimeSquared,
                        (double) priorityQueueSorter.getTime() * (double) priorityQueueSorter.getTime(), n+1);

            }


            System.out.println();
            System.out.println("ArrHeap" + "\n" + "time [ms] " + averageTime + " +- " + calculateStdDev(averageTime, averageTimeSquared));
            System.out.println();

        }

    private static double updatedAverage(double average, double value, int n) {
        return average + (value - average) / n;
    }

    private static double calculateStdDev(double average, double averagedSquares) {
        return Math.sqrt(averagedSquares - (average * average));
    }


}
