package core;

public class PivotRandom implements PivotChoose{


    public int pivotChoose(int listSize) {
        return (int)(Math.random()*listSize);
    }
}
