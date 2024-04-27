package Igor.Banaszak.HashFunction;

import Igor.Banaszak.HashFunction.HashFunction;

public class HashFunction10000<T> implements HashFunction<T> {

    public int hashCode(T object) {
        return Math.abs((Integer)object % 10000);
    }
}
