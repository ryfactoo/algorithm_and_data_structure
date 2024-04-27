package Igor.Banaszak;


public class OneWayLinkedListWithSentinel<E> {

    private Element sentinel = new Element(null);

    public OneWayLinkedListWithSentinel(){
        sentinel.setNext(null);
    }

    public Element get(int index) {

        if (index < 0 ) {
            throw new IndexOutOfBoundsException();
        }

        Element element = sentinel;

        while (index >= 0 && element != null) {
            element = element.getNext();
            index--;
        }

        if (element == null) {
            throw new IndexOutOfBoundsException();
        }

        return element;

    }


    public E set(int index, E data){
        Element element = get(index);
        E value = (E) element.getValue();
        element.setValue(data);
        return value;
    }





    public boolean add (E data) {

        Element newElement = new Element(data);
        Element elem = sentinel;

        while (elem.getNext() != null) {
            elem = elem.getNext();
        }

        elem.setNext(newElement);
        return true;
    }

    public void add (int index ,E data){

        if (index < 0 ) {
            throw new IndexOutOfBoundsException();
        }

        Element newElement = new Element(data);
        Element elem1 = get(index-1);

        newElement.setNext(get(index));
        elem1.setNext(newElement);
    }


    public void clear(){
        sentinel.setNext(null);
    }

    public boolean contains(E elementSearched) {
        if (indexOf(elementSearched) >-1){
            return true;
        }

        return false;
    }


    public int indexOf(E elementSearched){
        Element element = sentinel.getNext();
        int index = 0;

        if (element != null) {

            while (element.getNext() != null) {
                if (element.getValue().equals(elementSearched)) {
                    return index;
                }
                index++;
                element = element.getNext();
            }

            if (element.getValue().equals(elementSearched)) {
                return index;
            }
        }

        return -1;
    }

    public boolean isEmpty(){
        if (sentinel.getNext() == null) {
            return true;
        }

        return false;
    }

    public Element remove(int index) {
        Element element = get(index);

        if (index == 0){
            sentinel.setNext((element = get(0)).getNext());
            return element;
        }
        get(index-1).setNext(element.getNext());
        return element;
    }

    public boolean remove(E data) {
        int index;

        if ((index = indexOf(data)) >= 0) {
            remove(index);
            return true;
        }
        return false;
    }


    public int size(){
        Element element = sentinel;
        int size = 0;

        while (element.getNext() != null) {
            element = element.getNext();
            size++;
        }

        return size;
    }


    public void reverse() {


        if (sentinel.getNext() != null) {

            Element elementCurrent = sentinel.getNext();
            Element elementMemories1 = null;
            Element elementMemories2 = null;


            while (elementCurrent.getNext() != null) {

                elementMemories2 = elementMemories1;
                elementMemories1 = elementCurrent;
                elementCurrent = elementCurrent.getNext();

                elementMemories1.setNext(elementMemories2);

            }

            elementCurrent.setNext(elementMemories1);
            sentinel.setNext(elementCurrent);
        }
    }
}
