package Igor.Banaszak;

import java.util.Comparator;

public class ArrayHeap<T> implements Heap<T> {

    private final int startSize;
    private int elementInArr = 0;
    private T[] array;
    private Comparator<? super T> comparator;

    public T[] getArray() {
        return array;
    }

    public ArrayHeap(int size, Comparator<? super T> comparator) {
        this.array = (T[]) new Object[size];
        this.startSize = size;
        this.comparator = comparator;
    }

    public void clear() {
        this.elementInArr = 0;
        this.array = (T[]) new Object[startSize];
    }


    public void add(T element) {
        elementInArr++;

        if (elementInArr == array.length) {
            newSize();
        }

        array[elementInArr - 1] = element;

        swim(elementInArr - 1);
    }

    private void newSize() {

        T[] newArray = (T[]) new Object[array.length * 2];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    private void swim(int index) {


        if (index == 0) {

            if (comparator.compare(array[0], array[index]) < 0) {
                T element = array[0];
                array[0] = array[index];
                array[index] = element;
            }

        } else {

            T parentElement = array[(index - 1) / 2];

            if (comparator.compare(parentElement, array[index]) < 0) {
                array[(index - 1) / 2] = array[index];
                array[index] = parentElement;
                swim((index - 1) / 2);
            }
        }
    }


    public T minimum() {

        if (elementInArr == 0) {
            return null;
        }

        T element = array[0];


        array[0] = array[elementInArr - 1];
        array[elementInArr - 1] = null;
        elementInArr--;

        sink(0);

        return element;
    }

    private void sink(int index) {

        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        if (leftChild < elementInArr) {

            if (rightChild < elementInArr) {

                if (comparator.compare(array[leftChild], array[rightChild]) > 0) {

                    if (comparator.compare(array[index], array[leftChild]) < 0) {

                        T element = array[index];
                        array[index] = array[leftChild];
                        array[leftChild] = element;
                        sink(leftChild);
                    }

                } else {

                    if (comparator.compare(array[index], array[rightChild]) < 0) {

                        T element = array[index];
                        array[index] = array[rightChild];
                        array[rightChild] = element;
                        sink(rightChild);
                    }
                }

            } else {

                if (comparator.compare(array[index], array[leftChild]) < 0) {

                    T element = array[index];
                    array[index] = array[leftChild];
                    array[leftChild] = element;
                    sink(leftChild);
                }
            }
        }
    }


    public void printheap() {

        int floor = 2;

        if (elementInArr > 0) {

            System.out.println(array[0]);

            for (int index = 1; index < elementInArr; index++) {

                if (floor < index) {

                        floor = floor * floor + floor;

                    System.out.print("\n");
                }

                System.out.print(array[index] + " | ");
            }
        }
        }
    }
