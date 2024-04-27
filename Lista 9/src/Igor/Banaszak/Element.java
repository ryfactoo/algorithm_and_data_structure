package Igor.Banaszak;

import java.util.Random;

public class Element<T> {

    private T value;
    private int priority;
    private Element leftChild;
    private Element rightChild;

    public Element (T value) {
        Random random = new Random();
        this.priority = Math.abs(random.nextInt(1,1000000));
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }

    public Element getLeftChild() {
        return leftChild;
    }

    public Element getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Element leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Element rightChild) {
        this.rightChild = rightChild;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String toString() {
        return value + "  " + priority;
    }
}
