package Igor.Banaszak;

public class ElementTreeHeap<T> {

    private ElementTreeHeap leftChild = null;
    private ElementTreeHeap rightChild = null;
    private final T value;

    public ElementTreeHeap (T value) {
        this.value = value;
    }

    public ElementTreeHeap getLeftChild() {
        return leftChild;
    }

    public ElementTreeHeap getRightChild() {
        return rightChild;
    }

    public T getValue() {
        return value;
    }

    public void setLeftChild(ElementTreeHeap leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(ElementTreeHeap rightChild) {
        this.rightChild = rightChild;
    }

    public String toString() {
        return value + " ";
    }
}
