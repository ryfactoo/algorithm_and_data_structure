package Igor.Banaszak;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class PriorityQueueSorter<T> {

    private Heap heap;
    private Long time;

    public Long getTime() {
        return time;
    }

    public PriorityQueueSorter (Heap heap){
        this.heap = heap;
    }

    public List<T> sort(List<T> list) {

        heap.clear();
        int size = list.size();

        Instant start = Instant.now();

        for (int i = 0 ; i < size ; i++) {
            heap.add(list.get(i));
        }

        list.clear();

        for (int i = 0 ; i < size ; i++) {
            list.add((T) heap.minimum());
        }

        Instant end = Instant.now();

        this.time= Duration.between(start, end).toMillis();

        return list;
    }
}
