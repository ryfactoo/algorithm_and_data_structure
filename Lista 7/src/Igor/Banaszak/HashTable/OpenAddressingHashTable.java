package Igor.Banaszak.HashTable;


import Igor.Banaszak.HashFunction.HashFunction;
import Igor.Banaszak.HashTable.HashTable;
import Igor.Banaszak.IncrementalFunctionLine.IncrementalFunction;

import java.util.Arrays;
import java.util.Comparator;

public class OpenAddressingHashTable<T> extends HashTable<T> {

    private T[] array;
    protected IncrementalFunction increment;

    public OpenAddressingHashTable(double maxLoadFactor, Comparator<? super T> comparator, HashFunction<T> hashFunction, IncrementalFunction<T> increment) {
        super(maxLoadFactor, comparator, hashFunction);
        this.array = (T[]) new Object[startSize];
        this.increment = increment;
    }


    public int size() {
        return size;
    }


    public int capacity() {
        return array.length;
    }




    public void insert(Object object) {

        int startHashPosition = hashFunction.hashCode((T) object) % array.length;
        int position = Math.abs(startHashPosition);
        int trial = 1;

        if (size != 0) {
            colisions++;
        }

        if((double)size/array.length >= maxLoadFactor) {

            increaseArrays();
        }

        while (array[position] != null && comparator.compare(array[position],(T)object) != 0) {

            position = Math.abs((startHashPosition + increment.shift(object,trial++)) % array.length);
            hash++;
            insertComparisons++;

        }

        insertComparisons++;


        if (array[position] == null) {
            array[position] = (T) object;
            size++;
        }
    }



    private void increaseArrays() {

        T[] oldArr = array;
        size = 0;
        this.array = (T[]) new Object[oldArr.length*2];

        for(int i = 0 ; i < oldArr.length ; i++) {

            if (oldArr[i] != null) {

                insert(oldArr[i]);
            }
        }
    }


    public boolean lookUp(Object object) {

        int startHashPosition = hashFunction.hashCode((T) object);
        int position = startHashPosition;
        int trial = 1;
        boolean exists = false;

        while (array[position] != null && comparator.compare(array[position],(T)object) != 0) {
            lookUpComparisons++;
            position = (startHashPosition + increment.shift(object,trial++)) % array.length;
        }

        lookUpComparisons++;

        if (array[position] != null) {
            exists = true;
        }

        return exists;
    }


    public int collisions() {
        return colisions;
    }


    public int insertComparisons() {
        return insertComparisons;
    }


    public int lookUpComparisons() {
        return lookUpComparisons;
    }


    public int hashFunctionEvaluations() {
        return hash;
    }



    public String toString(){
        StringBuilder text = new StringBuilder("[");
        for(int i = 0; i < array.length; i++){
            text.append(array[i] + ", ");
        }
        text.replace(text.length() - 2, text.length(), "]");
        return text.toString();
    }


    public String statics(){
        double actualLoad = (double) size/capacity();
        return "\nAktualny stopień wypełnienia tablicy: " + actualLoad + "\nLiczba kolizji: " + this.colisions +
                "\nLiczba porównań w insert(): " + this.insertComparisons + "\nLiczba wyliczeń funkcji mieszającej: " + this.hash;
    }

}
