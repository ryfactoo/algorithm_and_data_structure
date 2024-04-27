import java.util.Comparator;
import java.util.List;

import core.SortingAlgorithm;

public class ShakerSort<T> extends SortingAlgorithm<T> {

    public ShakerSort(Comparator<? super T> comparator) {
        super(comparator);
    }


    public List<T> sort(List<T> list) {

        boolean swap = true;
        int lastSwap = list.size() -1;
        int firstSwap = 0;

        while(swap) {

            swap = false;
            int end = lastSwap;
            int start = firstSwap;

            firstSwap = 0;
            lastSwap = 0;
            T element = list.get(start);


            for (int i = start; i < end; i++) {

                T nextElement = list.get(i + 1);

                if (compare(element, nextElement) > 0) {

                    swap(list, i, i + 1);
                    swap = true;
                    lastSwap = i;

                } else {
                    element = nextElement;
                }
            }

            if (!swap) {
                break;
            }

            element = list.get(lastSwap);

            for (int i = lastSwap ; i > start ; i--) {

                T previousElement = list.get(i - 1);

                if (compare(element, previousElement) < 0) {

                    swap(list, i, i - 1);
                    swap = true;
                    firstSwap = i;

                } else {
                    element = previousElement;
                }
            }
        }
        return list;
    }
}

