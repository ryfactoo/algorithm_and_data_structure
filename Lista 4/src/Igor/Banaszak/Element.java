package Igor.Banaszak;

public class Element<E> {
    private Element next;
    private Element previous;
    private E[] arr;
    private int howManyElementsInTab = 0;


    public Element (int arrSize) {

        this.arr = (E[]) new Object[arrSize];
    }

    public Element getNext() {
        return next;
    }

    public Element getPrevious() {
        return previous;
    }

    public E[] getArr() {
        return arr;
    }

    public void setHowManyElementsInArr(int howManyElementsInTab) {
        this.howManyElementsInTab = howManyElementsInTab;
    }

    public int getHowManyElementsInArr() {
        return howManyElementsInTab;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public void setPrevious(Element previous) {
        this.previous = previous;
    }

    public void setArr(E[] arr) {
        this.arr = arr;
    }

    public String toString() {
        return arr[0] + " " + arr[1] + " " + arr[2];
    }
}
