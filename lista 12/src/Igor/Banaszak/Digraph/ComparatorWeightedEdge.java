package Igor.Banaszak.Digraph;

import java.util.Comparator;

public class ComparatorWeightedEdge implements Comparator<WeightedEdge> {


    public int compare(WeightedEdge o1, WeightedEdge o2) {
        return (int) (o1.weight - o2.weight);
    }
}
