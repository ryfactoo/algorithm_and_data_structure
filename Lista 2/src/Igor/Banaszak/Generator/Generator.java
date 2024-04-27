package Igor.Banaszak.Generator;

public class Generator<E> implements SeriesGenerator<Integer> {


    public Integer generate(int n) {

        return  (int)Math.pow(2,n);
    }
}
