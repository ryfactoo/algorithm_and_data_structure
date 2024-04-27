import java.util.Comparator;
import java.util.List;
import core.SortingAlgorithm;


public class MergeSort<T> extends SortingAlgorithm<T> {

    public MergeSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    public List<T> sort(List<T> list) {

        boolean czyKoniec = false;
        int size = list.size();
        int i = 0;
        int j = 0;
        int lastfirstArr = 0;

        for (j = 2 ; j < size ; j += j) {
            for (i = 0; i+j <= size; i += j) {
                MergeSortIndex(list, i, lastfirstArr, i+j-1);
                lastfirstArr += j;
            }

            if (size % j != 0) {
                MergeSortIndex(list, i, lastfirstArr, size - 1);
            }
            lastfirstArr = j - 1;
        }

        MergeSortIndex(list,0, lastfirstArr ,size-1);


        return list;
    }



    public void MergeSortIndex (List<T> list, int first, int lastFirstArr, int last){

        int indexLeftArr = first;
        int indexRichtArr = lastFirstArr+1;

        T leftArr = list.get(first);
        T richtArr = list.get(last);

        if (first != lastFirstArr) {

            while (indexRichtArr <= last && indexLeftArr <= lastFirstArr && lastFirstArr <= last) {
                richtArr = list.get(indexRichtArr);
                leftArr = list.get(indexLeftArr);

                if (compare(leftArr, richtArr) <= 0) {

                    indexLeftArr++;

                } else {

                    for (int i = indexRichtArr; i > indexLeftArr; i--) {

                        swap(list, i, i - 1);
                    }

                    indexLeftArr++;
                    indexRichtArr++;
                    lastFirstArr++;
                }
            }
        } else {
            if (compare(leftArr, richtArr) > 0) {
                swap(list, first, last);
            }
        }
    }
}
