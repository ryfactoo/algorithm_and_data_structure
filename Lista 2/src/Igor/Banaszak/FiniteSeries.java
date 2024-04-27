package Igor.Banaszak;

import Igor.Banaszak.Generator.Generator;
import Igor.Banaszak.Generator.SeriesGenerator;

import java.util.Iterator;

public class FiniteSeries <E> implements Iterable<E>{

    private int nThTerm;
    private SeriesGenerator generator;

    public FiniteSeries(SeriesGenerator generator,int nThTerm) {

        this.nThTerm = nThTerm;
        this.generator = generator;
    }



    public Iterator<E> iterator() {
        return new SeriesIterator<E>(generator,nThTerm);
    }
}
