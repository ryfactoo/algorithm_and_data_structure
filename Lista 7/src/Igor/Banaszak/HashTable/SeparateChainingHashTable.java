package Igor.Banaszak.HashTable;

import Igor.Banaszak.HashFunction.HashFunction;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class SeparateChainingHashTable<T> extends HashTable<T> {

    protected LinkedList<T>[] array;

    public SeparateChainingHashTable(double maxLoadFactor, Comparator<? super T> comparator, HashFunction<T> hashFunction) {

        super(maxLoadFactor, comparator, hashFunction);
        this.array = new LinkedList[startSize];

        for (int i = 0; i < array.length; i++) {
            array[i] = new LinkedList<T>();
        }
    }


    public int capacity() {
        return array.length;
    }


    public int size() {
        return size;
    }


    public void insert(T object) {

        LinkedList linkedList;
        boolean exist = false;

        if((double)size/array.length >= maxLoadFactor){
            increaseArrays();
        }


        if ((linkedList = array[(hashFunction.hashCode(object)) % array.length]).isEmpty()) {

            colisions++;
            array[(hashFunction.hashCode(object)) % array.length].addLast(object);

        } else {

            for (int i = 0 ; i < linkedList.size() ; i++) {



               if (comparator.compare(object,(T)linkedList.get(i)) == 0) {
                   exist = true;
               }

               insertComparisons++;
            }

            if (!exist) {

                array[(hashFunction.hashCode(object)) % array.length].addLast(object);
            }
        }

        size++;
    }


    private void increaseArrays() {

        size = 0;
        LinkedList<T>[] temp = array;
        array = new LinkedList[temp.length*2];
        for(int i = 0; i < array.length; i++){
            array[i] = new LinkedList<T>();
        }
        Iterator<T> iterator;
        for(int i = 0; i < temp.length; i++){
            iterator = temp[i].iterator();
            while(iterator.hasNext()){
                insert(iterator.next());
            }
        }
    }

    public boolean lookUp(T object) {
        Iterator<T> iterator;
        int position = this.hashFunction.hashCode(object) % this.array.length;

        iterator = array[position].iterator();
        while (iterator.hasNext()) {
            lookUpComparisons++;
            if (comparator.compare(object,iterator.next()) == 0){
                return true;
            }
        }
        return false;
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
        StringBuilder text = new StringBuilder("[ ");
        Iterator iterator;
        boolean hasChanged = false;

        for(int i = 0; i < array.length; i++){
            iterator = array[i].iterator();
            while(iterator.hasNext()){
                text.append(iterator.next() + ", ");
                hasChanged = true;
            }

            if (i != array.length - 1) {
                if(hasChanged) {
                    text.delete(text.length() - 2, text.length());
                }
                text.append(" | ");
            } else {
                if(hasChanged) {
                    text.delete(text.length() - 2, text.length());
                }
                text.append(" ]");
            }

            hasChanged = false;
        }
        return text.toString();
    }


    public String statics() {
        double actualLoad = (double) size/this.array.length;
        return "\nAktualny stopień wypełnienia tablicy: " + actualLoad + "\nLiczba kolizji: " + this.colisions +
                "\nLiczba porównań w insert(): " + this.insertComparisons;
    }
}

