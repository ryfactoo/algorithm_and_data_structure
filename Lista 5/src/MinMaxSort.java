import java.util.Comparator;
import java.util.List;

import core.SortingAlgorithm;

public class MinMaxSort<T> extends SortingAlgorithm<T> {

    public MinMaxSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    public List<T> sort(List<T> list) {
        int size = list.size();


        for(int pass = 0; pass < size/2; pass++) {

            T min = list.get(pass);
            T max = list.get(pass);
//            int maxIndex = pass;
//            int minIndex = pass;

            for (int j = pass + 1; j < size - pass; j++) {

                if (compare(min, list.get(j)) > 0) {
                    min = list.get(j);
//                    minIndex = j;

                }
                if (compare(max, list.get(j)) <= 0) {
                    max = list.get(j);
//                    maxIndex = j;
                }
            }

            swap(list, pass, list.indexOf(min));
            swap(list, size - 1 - pass, list.indexOf(max));


//            if (maxIndex == pass && minIndex == size - 1 - pass) {
//                swap(list, pass, minIndex);
//
//            } else if (maxIndex == pass) {
//                swap(list, size - 1 - pass, maxIndex);
//                swap(list, pass, minIndex);
//            }else {
//                swap(list, pass, minIndex);
//                swap(list, size - 1 - pass, maxIndex);
//            }

        }

        return list;
    }
}
