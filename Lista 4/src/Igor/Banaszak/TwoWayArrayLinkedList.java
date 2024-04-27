package Igor.Banaszak;

import java.util.Iterator;
import java.util.ListIterator;

public class TwoWayArrayLinkedList <E> {
    private final int arrSize;
    private Element tail = null;
    private Element head = null;

    public TwoWayArrayLinkedList(int tabSize) {
        if (tabSize < 1) {

            throw new IllegalArgumentException();
        }

        this.arrSize = tabSize;
    }

    public boolean add(E data) {

        if (tail == null) {
            head = new Element(arrSize);
            tail = head;

            tail.getArr()[0] = data;
            tail.setHowManyElementsInArr(1);
            return true;

        } else if (tail.getHowManyElementsInArr() < arrSize) {
            tail.getArr()[tail.getHowManyElementsInArr()] = data;
            tail.setHowManyElementsInArr(tail.getHowManyElementsInArr() + 1);
            return true;

        } else {

            Element newElement = new Element(arrSize);
            newElement.setPrevious(tail);
            tail.setNext(newElement);
            tail = newElement;
            tail.getArr()[0] = data;
            tail.setHowManyElementsInArr(1);
            return true;
        }

    }


    public void clear() {

        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }

        return false;
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    public Iterator<E> iterator() {
        return null;
    }


    public int indexOf(E data) {

        if (head == null) {
            return -1;

        } else {

            Element element = head;
            int position = 0;

            while (element != tail) {

                for (int i = 0; i < element.getHowManyElementsInArr(); i++) {

                    if (data == element.getArr()[i]) {

                        return position + i;
                    }
                }

                position += element.getHowManyElementsInArr();
                element = element.getNext();
            }

            for (int i = 0; i < tail.getHowManyElementsInArr(); i++) {

                if (data == element.getArr()[i]) {

                    return position + i;
                }
            }

            return -1;
        }
    }

    public E get(int index) {

        if (head == null) {
            throw new IndexOutOfBoundsException();

        }

        Element element = head;


        int position = 0;

        while (element != null && position <= index - element.getHowManyElementsInArr()) {
            position += element.getHowManyElementsInArr();
            element = element.getNext();
        }

        if (element == null) {

            throw new IndexOutOfBoundsException();

        } else {

            return (E) element.getArr()[index - position];
        }
    }


    public E set(int index, E data) {

        if (head == null) {
            throw new IndexOutOfBoundsException();

        }

        Element element = head;
        E oldElement = null;


        int position = 0;

        while (element != null && position <= index - element.getHowManyElementsInArr()) {
            position += element.getHowManyElementsInArr();
            element = element.getNext();
        }

        if (element == null) {

            throw new IndexOutOfBoundsException();

        } else {

            oldElement = (E) element.getArr()[index - position];
            element.getArr()[index - position] = data;
            return (E) oldElement;
        }
    }


    public boolean remove(E data) {

        if (head == null) {
            return false;

        }


        Element element = head;

        while (element != tail) {

            for (int i = 0; i < element.getHowManyElementsInArr(); i++) {

                if (data == element.getArr()[i]) {

                    element.getArr()[i] = null;
                    element.setHowManyElementsInArr(element.getHowManyElementsInArr() - 1);

                    if (element.getHowManyElementsInArr() == 0) {
                        removeEmptyElemtnt(element);

                    } else {

                        tabToLeft((E[]) element.getArr(), i);
                    }

                    return true;
                }
            }

            element = element.getNext();
        }

        for (int i = 0; i < tail.getHowManyElementsInArr(); i++) {


            if (data == element.getArr()[i]) {

                tail.getArr()[i] = null;
                element.setHowManyElementsInArr(element.getHowManyElementsInArr() - 1);

                if (tail.getHowManyElementsInArr() == 0) {
                    removeEmptyElemtnt(tail);

                } else {

                    tabToLeft((E[]) element.getArr(), i);
                }

                return true;
            }
        }

        return false;
    }


    private boolean removeEmptyElemtnt(Element element) {

        if (tail == head) {
            head = null;
            tail = null;
            return true;

        } else if (element == tail) {

            tail = element.getPrevious();
            tail.setNext(null);
            return true;

        } else if (element == head) {

            head = head.getNext();
            head.setPrevious(null);
            return true;
        }

        Element elementPrevious = element.getPrevious();
        element = element.getNext();

        elementPrevious.setNext(element);
        element.setPrevious(elementPrevious);

        return false;
    }


    private boolean tabToLeft(E[] tab, int index) {

        if (index + 1 == arrSize) {

            return true;
        }


        for (int i = index; i < arrSize - 1; i++) {

            tab[i] = tab[i + 1];
        }

        tab[arrSize - 1] = null;
        return true;
    }


    public int size() {

        int count = 0;

        if (head == null) {
            return count;

        } else {

            Element element = head;

            while (element != tail) {
                count += element.getHowManyElementsInArr();
                element = element.getNext();
            }

            count += tail.getHowManyElementsInArr();
        }

        return count;

    }


    public boolean contains(E data) {

        if (indexOf(data) > -1) {
            return true;
        }

        return false;
    }


    public void add(int index, E data) {


        if (size() < index) {

            throw new IndexOutOfBoundsException();

        } else if (head == null) {

            head = new Element(arrSize);
            tail = head;

            tail.getArr()[0] = data;
            tail.setHowManyElementsInArr(1);

        } else if (index == size()) {
            add(data);

        } else {

            Element element = head;
            int count = 0;

            while (count - 1 + arrSize < index) {
                count += element.getHowManyElementsInArr();
                element = element.getNext();
            }


            if (element.getHowManyElementsInArr() == arrSize) {

                Element newElement = new Element(arrSize);

                if (element.getNext() == tail) {
                    newElement.setNext(null);
                    newElement = tail;

                } else {
                    newElement.setNext(element.getNext());
                    newElement.getNext().setPrevious(newElement);
                }
                element.setNext(newElement);
                newElement.setPrevious(element);
                newElement.setPrevious(element);

                newElement.getArr()[0] = element.getArr()[arrSize - 1];
                newElement.setHowManyElementsInArr(1);

            } else {

                element.setHowManyElementsInArr(element.getHowManyElementsInArr() + 1);
            }

            for (int i = arrSize - 1; i != index % arrSize; i--) {

                element.getArr()[i] = element.getArr()[i - 1];
            }

            element.getArr()[index % arrSize] = data;
        }
    }


    public E remove(int index) {

        if (index >= size()) {

            throw new IndexOutOfBoundsException();

        } else {

            E removeElement;
            Element element = head;
            int count = 0;

            while (count + element.getHowManyElementsInArr() <= index) {
                count += element.getHowManyElementsInArr();
                element = element.getNext();
            }

            removeElement = (E) element.getArr()[index % arrSize];
            element.getArr()[index % arrSize] = null;
            element.setHowManyElementsInArr(element.getHowManyElementsInArr() - 1);

            if (element.getHowManyElementsInArr() == 0) {
                removeEmptyElemtnt(element);

            } else {
                tabToLeft((E[]) element.getArr(), index % arrSize);
            }

            return removeElement;
        }
    }


    public int endCapacity() {

        if (tail != null) {
            return arrSize - tail.getHowManyElementsInArr();
        }

        return 0;

    }

    public int capacity() {

        if (head == null) {
            return 0;

        } else {

            Element element = head;
            int capacity = 0;

            while (element != tail) {
                capacity += (arrSize - element.getHowManyElementsInArr());
                element = element.getNext();
            }

            return capacity += (arrSize - element.getHowManyElementsInArr());
        }
    }


    public void defragment() {


        if (head != null && head != tail) {

            Element elementSave = head;
            Element elementRead = head;
            int elementSaveIndexArr = 0;


            while (elementRead != tail) {

                for (int i = 0; i < elementRead.getHowManyElementsInArr(); i++) {

                    if (elementSaveIndexArr >= arrSize) {
                        elementSave.setHowManyElementsInArr(arrSize);
                        elementSave = elementSave.getNext();
                        elementSaveIndexArr = 0;
                    }

                    elementSave.getArr()[elementSaveIndexArr] = elementRead.getArr()[i];
                    elementSaveIndexArr++;

                }

                elementRead = elementRead.getNext();
            }

            for (int i = 0; i < elementRead.getHowManyElementsInArr(); i++) {

                if (elementSaveIndexArr >= arrSize) {
                    Element elementToSave = elementSave;
                    elementSave.setHowManyElementsInArr(arrSize);
                    elementSave = elementSave.getNext();
                    elementToSave.setNext(elementSave);
                    elementSaveIndexArr = 0;
                }

                elementSave.getArr()[elementSaveIndexArr] = elementRead.getArr()[i];
                elementSaveIndexArr++;
                elementSave.setHowManyElementsInArr(elementSaveIndexArr);

            }

//            for (int i = elementSave.getHowManyElementsInArr() ; i < arrSize;i++) {
//                elementSave.getArr()[i] = null;
//            }

            tail = elementSave;
            elementSave.setNext(null);
        }
    }
}
