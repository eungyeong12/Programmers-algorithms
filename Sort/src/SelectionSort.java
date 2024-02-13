import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SelectionSort implements Sortable {
    @Override
    public <T> List<T> sort(List<T> list, Comparator<T> comparator) {
        List<T> copy = new LinkedList<>(list);
        int size = copy.size();

        for(int i=0; i<size; i++) {
            int minIndex = i;
            T min = copy.get(i);

            for(int j=i+1; j<size; j++) {
                T d = copy.get(j);
                if(min == null || comparator.compare(min, d) > 0) {
                    minIndex = j;
                    min = d;
                }
            }

            copy.remove(minIndex);
            copy.add(i, min);
        }

        return copy;
    }
}
