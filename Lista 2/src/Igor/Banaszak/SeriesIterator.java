package Igor.Banaszak;

import Igor.Banaszak.Generator.*;

import java.util.Iterator;

public class SeriesIterator<E> implements Iterator<E> {


    private int lenght = -1;
    private int position = 1;
    private SeriesGenerator generator;


    public SeriesIterator(SeriesGenerator generator) {
        this.generator = generator;
    }

    public SeriesIterator(SeriesGenerator generator,int lenght) {

        if (lenght < 1) {
            this.lenght = 0;

        } else {
            this.lenght = lenght;
        }

        this.generator = generator;
    }



    public boolean hasNext() {

        if (position != lenght+1) {

            return true;

        } else {

            return false;
        }
    }


    public E next() {

        if (hasNext()) {
            return (E) generator.generate(position++);

        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
