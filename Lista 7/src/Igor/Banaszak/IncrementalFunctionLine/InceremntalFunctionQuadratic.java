package Igor.Banaszak.IncrementalFunctionLine;

public class InceremntalFunctionQuadratic<T> implements IncrementalFunction<T> {


    public int shift(T object, int trial) {
        return  Math.abs(3*trial*trial);
    }
}

