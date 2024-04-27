package Igor.Banaszak.Digraph;

import java.util.ArrayList;
import java.util.List;

public class ILinkedList {

    private Element head;
    private Element tail;

    private class Element{

        public int v;
        public double w;
        public Element next = null;

        public Element(int v,double w){
            this.v = v;
            this.w = w;
        }
    }

    public void add(int v, double w){

        Element element = new Element( v, w);

        if (head == null){
            head = element;

        }else {
            tail.next = element;
        }
        tail = element;
    }

    public double weight(int v){

        Element element = head;

        while (element != null){

            if (element.v == v){
                return element.w;
            }

            element = element.next;
        }

        return 0;
    }

    public boolean contain(int v){

        Element element = head;

        while (element != null){

            if (element.v == v){
                return true;
            }
            element = element.next;
        }

        return false;
    }

    public boolean remove(int v){


        Element element = head;

        if (head == null){
            return false;
        }

        if (element.v == v){
            head = element.next;
            return true;
        }

        while (element.next != null){

            if (element.next.v == v){
                element.next = element.next.next;
                return true;
            }

            element = element.next;

        }

        return false;
    }

    public int size(){

        int count = 0;
        Element element = head;

        while (element != null){
            count++;
            element = element.next;
        }

        return count;
    }

    public List<Integer> verticesConnectedTo(){

        Element element = head;
        List list = new ArrayList();

        while (element != null){
            list.add(element.v);
            element = element.next;
        }


        return list;
    }

    public boolean setWeight(int v,double w){
        Element element = head;

        while (element != null){

            if (element.v == v){
                element.w = w;
                return true;
            }
            element = element.next;
        }

        return false;
    }


    public int next(int v){

        Element element = head;

        if (head == null){
            return -1;
        }

        if (v == -1){
            return head.v;
        }

        while (element.next != null){

            if (element.v == v){
                return element.next.v;
            }

            element = element.next;
        }

        return -1;
    }
}
