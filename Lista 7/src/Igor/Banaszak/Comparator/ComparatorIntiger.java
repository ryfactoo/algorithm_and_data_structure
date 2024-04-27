package Igor.Banaszak.Comparator;

import java.util.Comparator;

public class ComparatorIntiger<Object> implements Comparator<Object> {

    public int compare(Object o1, Object o2) {

        return (int) o1- (int) o2;
    }
}
