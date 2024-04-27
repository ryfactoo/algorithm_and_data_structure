import core.Pivot0;
import core.PivotChoose;
import core.PivotRandom;
import core.SortingAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.List;

public class QuickSort<T> extends SortingAlgorithm<T> {

    public QuickSort(Comparator<? super T> comparator) {
        super(comparator);
    }



    public List<T> sort(List<T> list) {

        PivotChoose pivotChoose = new Pivot0();

        LinkedList linkedList = new LinkedList(list);
        linkedList = quckSort(pivotChoose.pivotChoose(list.size()),linkedList,pivotChoose);
        list.clear();
        list.addAll(linkedList);
        return list;
    }


    private LinkedList<T> quckSort (int indexPivot,LinkedList list,PivotChoose pivotChoose) {

        List listToSwap = new ArrayList();
        listToSwap.add(1);


        if (list.size() < 1) {
            return list;
        }

        LinkedList helpList = new LinkedList();
        T pivot = (T)list.get(indexPivot);
        int size = list.size();

        for (int i = 0 ; i < size ; i++) {

            T element = (T)list.get(0);
            swap(listToSwap,0,0);

            if (element.equals(pivot)) {
                list.removeFirst();

            } else if (compare(pivot,element) <= 0 ) {

                list.addLast(element);
                list.removeFirst();
            }else {
                helpList.addFirst(element);
                list.removeFirst();
            }
        }

        if (helpList.size() < 2 & list.size() < 2) {
            helpList.addLast(pivot);
            helpList.addAll(list);
            return helpList;
        }

        list = quckSort(pivotChoose.pivotChoose(list.size()),list,pivotChoose);
        helpList = quckSort(pivotChoose.pivotChoose(helpList.size()),helpList,pivotChoose);
        helpList.addLast(pivot);
        helpList.addAll(list);
        return helpList;
    }
}
