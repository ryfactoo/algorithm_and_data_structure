package Igor.Banaszak;

import java.util.Objects;

public class Element<E> {

    private E value;
    private Element next;

    public Element (E value) {
        this.value = value;
        this.next = null;
    }

    public E getValue() {
        return value;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public String toString() {
        return value+ "   ";
    }

    public void setValue(E value) {
        this.value = value;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element<?> element = (Element<?>) o;
        return Objects.equals(value, element.value);
    }
}
