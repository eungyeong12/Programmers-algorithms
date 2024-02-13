import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BubbleSort implements Sortable {
    @Override
    public <T> List<T> sort(List<T> list, Comparator<T> comparator) {
        List<T> copy = new LinkedList<>(list);
        int size = copy.size();
        for(int i=0; i<size; i++) {
            for(int j=i+1; j<size; j++) {
                T d1 = copy.get(i);
                T d2 = copy.get(j);
                if(comparator.compare(d1, d2) > 0) {
                    copy.set(i, d2);
                    copy.set(j, d1);
                }
            }
        }
        return copy;
    }
}
