package Igor.Banaszak;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class TreeHeap<T> implements Heap<T> {

    private ElementTreeHeap root = null;
    private int elementInTree;
    private Comparator<Object> comparator;

    public TreeHeap(Comparator<Object> comparator) {
        this.comparator = comparator;
    }

    public void clear() {

        elementInTree = 0;
        root = null;
    }

    public void add(T element) {

        ElementTreeHeap newElement = new ElementTreeHeap(element);

        if (root == null) {

            root = newElement;
            elementInTree++;

        } else {

            ElementTreeHeap parentElement = getElement((elementInTree - 1) / 2);
            elementInTree++;

            if (parentElement.getLeftChild() == null) {
                parentElement.setLeftChild(newElement);

            } else {
                parentElement.setRightChild(newElement);
            }

            swim((elementInTree - 2) / 2, newElement);

        }

    }


    private void swim(int index, ElementTreeHeap childElement) {

        ElementTreeHeap parentElement = getElement(index);

        if (comparator.compare(parentElement.getValue(), childElement.getValue()) < 0) {


            if (parentElement.getLeftChild() == childElement) {

                ElementTreeHeap siblingElement = parentElement.getRightChild();

                parentElement.setLeftChild(childElement.getLeftChild());
                parentElement.setRightChild(childElement.getRightChild());

                childElement.setRightChild(siblingElement);
                childElement.setLeftChild(parentElement);

            } else {

                ElementTreeHeap siblingElement = parentElement.getLeftChild();

                parentElement.setLeftChild(childElement.getLeftChild());
                parentElement.setRightChild(childElement.getRightChild());

                childElement.setLeftChild(siblingElement);
                childElement.setRightChild(parentElement);
            }

            if (parentElement == root) {

                root = childElement;

            } else {

                ElementTreeHeap grandDadElement = getElement((index - 1) / 2);

                if (grandDadElement.getLeftChild() == parentElement) {
                    grandDadElement.setLeftChild(childElement);

                } else {
                    grandDadElement.setRightChild(childElement);
                }

                swim((index - 1) / 2, childElement);
            }
        }
    }


    public T minimum() {

        if (elementInTree > 1) {

            ElementTreeHeap parentElement = getElement((elementInTree - 2) / 2);
            ElementTreeHeap newRoot;

            if (parentElement.getRightChild() == null) {

                newRoot = parentElement.getLeftChild();
                parentElement.setLeftChild(null);

            } else {

                newRoot = parentElement.getRightChild();
                parentElement.setRightChild(null);
            }

            parentElement = root;

            root = newRoot;

            newRoot.setLeftChild(parentElement.getLeftChild());
            newRoot.setRightChild(parentElement.getRightChild());

            elementInTree--;
            
            if (elementInTree > 1) {

                sink(root,root);
            }

            return (T) parentElement.getValue();

        }else if (root != null) {

            ElementTreeHeap root = this.root;
            clear();
            return (T) root;

        } else {

            throw new IndexOutOfBoundsException();
        }
    }

    private void sink(ElementTreeHeap element,ElementTreeHeap grandDad) {

        ElementTreeHeap childElement;

        if (element.getRightChild() == null) {

            childElement = element.getLeftChild();

        }else if (comparator.compare(element.getLeftChild().getValue(),element.getRightChild().getValue()) > 0) {

            childElement = element.getLeftChild();

        } else {

            childElement = element.getRightChild();
        }

        if (comparator.compare(childElement.getValue(),element.getValue()) > 0) {

            ElementTreeHeap siblingElement;

            if (childElement == element.getLeftChild()) {

                siblingElement = element.getRightChild();

                element.setRightChild(childElement.getRightChild());
                element.setLeftChild(childElement.getLeftChild());

                childElement.setLeftChild(element);
                childElement.setRightChild(siblingElement);

            } else {

                siblingElement = element.getLeftChild();

                element.setRightChild(childElement.getRightChild());
                element.setLeftChild(childElement.getLeftChild());

                childElement.setRightChild(element);
                childElement.setLeftChild(siblingElement);

            }

            if (element == root) {
                root = childElement;

            } else {

                if (grandDad.getLeftChild() == element) {

                    grandDad.setLeftChild(childElement);

                }else {

                    grandDad.setRightChild(childElement);
                }

            }

            if (element.getLeftChild() != null) {
                sink(element,childElement);
            }
        }
    }

    private ElementTreeHeap getElement(int index) {

        ElementTreeHeap element = root;
        index++;

        int i;

        for (i = 1; i < index; i = i * 2) {

        }

        if (i == index) {

            index = index - i;
            i = i / 2;

        } else {

            i = i / 2;
            index = index - i;
            i = i / 2;
        }

        for (i = i; i > 0; i = i / 2) {

            if (index >= i) {

                element = element.getRightChild();
                index = index - i;

            } else {

                element = element.getLeftChild();
            }
        }

        return element;
    }


    public void printheap() {

        if (elementInTree > 0) {

            LinkedList<ElementTreeHeap> queue = new LinkedList<>();


            int floor = 2;
            int added = 0;

            System.out.println(root.getValue());

            if (elementInTree >= 3) {
                queue.addLast(root.getLeftChild());
                queue.addLast(root.getRightChild());

            } else if (elementInTree > 1) {
                System.out.println(root.getLeftChild().getValue());
            }



            while (!queue.isEmpty()) {

                if (queue.getFirst().getRightChild() != null) {

                    queue.addLast(queue.getFirst().getLeftChild());
                    queue.addLast(queue.getFirst().getRightChild());

                }else if (queue.getFirst().getLeftChild() != null) {
                    queue.addLast(queue.getFirst().getLeftChild());
                }

                if (added >= floor) {

                    floor = floor * floor;
                    added = 0;
                    System.out.print("\n");
                }

                System.out.print(queue.getFirst().getValue() + " | ");
                added++;

                queue.removeFirst();
            }
        }
    }
}
