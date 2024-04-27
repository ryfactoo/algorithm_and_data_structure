package Igor.Banaszak;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class HeapyBinarySearchTree<T>{

    private Element root = null;
    private Comparator comparator;


    public HeapyBinarySearchTree(Comparator comparator){
        this.comparator = comparator;
    }



    public void add(T value) {

        Element newElement = new Element(value);
        Element element = root;

        if (root == null) {
            root = newElement;

        } else if (getParent(value) == null){
            boolean end = false;
            int comparatorValue = 0;
            while (!end){

                if ((comparatorValue = comparator.compare(newElement.getValue(), element.getValue())) > 0){
                    if (element.getLeftChild() == null) {
                        end = true;
                    } else {
                        element = element.getLeftChild();
                    }
                } else {
                    if (element.getRightChild() == null) {
                        end = true;
                    } else {
                        element = element.getRightChild();
                    }
                }
            }
            if (comparatorValue > 0) {
                element.setLeftChild(newElement);
            } else {
                element.setRightChild(newElement);
            }
            repare(newElement);
        } else {
            throw new IllegalArgumentException("added this value to HeapyBinarySearchTree");
        }
    }



    private void repare(Element elementChild){

        Element elementParent = getParent((T) elementChild.getValue());
        boolean end = false;


        while (!end) {

            if (elementChild.getPriority() > elementParent.getPriority()) {

                if (elementParent.getLeftChild() == elementChild) {
                    rightRotate(elementParent,elementChild);

                }else {
                    leftRotate(elementParent,elementChild);
                }

                elementParent = getParent((T) elementChild.getValue());

            } else {
                end = true;
            }
        }
    }


    private Element getParent(T childvalue){

        Element element = root;

        if (root.getValue() == childvalue) {
            return root;
        }

        while (element != null){

            if (element.getLeftChild() != null && element.getLeftChild().getValue() == childvalue){
                return element;

            } else if (element.getRightChild() != null && element.getRightChild().getValue() == childvalue){
                return element;

            } else if (element.getLeftChild() != null && comparator.compare(childvalue,element.getValue())> 0){
                element = element.getLeftChild();

            } else {
                element = element.getRightChild();
            }
        }

        return null;
    }

    public Element getElement(T value) {

        Element element = root;

        while (element != null && element.getValue() != value) {

            if (comparator.compare(value,element.getValue()) > 0) {

                element = element.getLeftChild();

            } else {

                element = element.getRightChild();
            }
        }

        if (element == null) {
            throw new NoSuchElementException();
        }

        return element;
    }


    private void leftRotate(Element elementParent,Element elementChild) {

        elementParent.setRightChild(elementChild.getLeftChild());
        elementChild.setLeftChild(elementParent);

        if (elementParent == root) {
            root = elementChild;

        } else {

            Element elementgrandpa = getParent((T) elementParent.getValue());

            if (elementgrandpa.getLeftChild() == elementParent){
                elementgrandpa.setLeftChild(elementChild);

            }else {
                elementgrandpa.setRightChild(elementChild);
            }
        }

    }

    private void rightRotate(Element elementParent,Element elementChild) {

        elementParent.setLeftChild(elementChild.getRightChild());
        elementChild.setRightChild(elementParent);

        if (elementParent == root) {
            root = elementChild;

        } else {

            Element elementgrandpa = getParent((T) elementParent.getValue());

            if (elementgrandpa.getLeftChild() == elementParent){
                elementgrandpa.setLeftChild(elementChild);

            }else {
                elementgrandpa.setRightChild(elementChild);
            }
        }

    }


    public void remove(T value) {

        Element elementToRemove = getElement(value);
        Element parentElement = getParent((T) elementToRemove.getValue());


        while (elementToRemove.getLeftChild() != null && elementToRemove.getRightChild() != null){

            if ((elementToRemove.getLeftChild().getPriority() - elementToRemove.getRightChild().getPriority()) > 0) {

                rightRotate(elementToRemove,(parentElement = elementToRemove.getLeftChild()));
            }else {
                leftRotate(elementToRemove,(parentElement = elementToRemove.getRightChild()));
            }
        }

        if (parentElement == elementToRemove) {

            if (elementToRemove.getLeftChild() == null){
                root = elementToRemove.getRightChild();
            }else {
                root = elementToRemove.getLeftChild();
            }

        } else if (elementToRemove.getLeftChild() == null) {

            if (parentElement.getLeftChild() == elementToRemove) {
                parentElement.setLeftChild(elementToRemove.getRightChild());
            }else {
                parentElement.setRightChild(elementToRemove.getRightChild());
            }
        } else {
            if (parentElement.getLeftChild() == elementToRemove) {
                parentElement.setLeftChild(elementToRemove.getLeftChild());
            }else {
                parentElement.setRightChild(elementToRemove.getLeftChild());
            }
        }
    }

    public void clear(){
        root = null;
    }
}
