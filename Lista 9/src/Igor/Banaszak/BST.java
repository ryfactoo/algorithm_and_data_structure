package Igor.Banaszak;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class BST <T>{

    private Element root = null;
    private Comparator comparator;

    public BST(Comparator comparator){
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

        } else {

            throw new IllegalArgumentException("added this value to BST");
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


    public Element remove(int key){
        if ((int)root.getValue() == key && root.getRightChild() == null && root.getLeftChild() == null){
            Element element = root;
            root = null;
            return element;
        }

       return remove(root,key);
    }

    private Element remove(Element root, int value) {


        if (root == null) {
            return root;
        }
        else if (value < (int)root.getValue()) {
            root.setLeftChild(remove(root.getLeftChild(), value));
        }
        else if (value > (int)root.getValue()) {
            root.setRightChild(remove(root.getRightChild(), value));
        }
        else {
            if (root.getLeftChild() == null && root.getRightChild() == null) {
                root = null;
            }
            else if (root.getLeftChild() == null) {
                Element temp = root;
                root = root.getRightChild();
                temp = null;
            }
            else if (root.getRightChild() == null) {
                Element temp = root;
                root = root.getLeftChild();
                temp = null;
            }
            else {
                Element temp = minValue(root.getRightChild());
                root.setValue(temp.getValue());
                root.setRightChild(remove(root.getRightChild(), (int)temp.getValue()));
            }
        }

        return root;
    }

    private Element minValue(Element root) {
        while (root.getLeftChild() != null) {
            root = root.getLeftChild();
        }
        return root;
    }

    public void clear(){
        root =null;
    }
}
