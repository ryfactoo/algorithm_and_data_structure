package Igor.Banaszak;

import Igor.Banaszak.Generator.*;

import java.util.Iterator;

public class Series <E> implements Iterable<E>{

    private int nThTerm;
    private SeriesGenerator generator;






    public Series (SeriesGenerator generator) {
        this.nThTerm = nThTerm;
        this.generator = generator;
    }



    public Iterator<E> iterator() {
        return new SeriesIterator<E>(generator);
    }
}
