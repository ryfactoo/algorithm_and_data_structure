import core.SortingAlgorithm;

import java.util.Comparator;
import java.util.List;

public class BinarySearch <T> extends SortingAlgorithm<T> {

    public BinarySearch(Comparator<T> comparator) {
        super(comparator);
    }

    public List<T> sort(List<T> list) {
        int size = list.size();

        for (int i = 0 ; i < size ; i++) {

            T value = list.get(i);
            int temp;
            int j;

            for (j = i; j > 0&& compare(value, list.get(temp= (j - 1)))< 0; --j)
                swap(list,j,temp);
        }
        return list;
    }

}
