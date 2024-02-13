import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class InsertSort implements Sortable {
    @Override
    public <T> List<T> sort(List<T> list, Comparator<T> comparator) {
        List<T> copy = new LinkedList<>(list);
        int size = copy.size();

        for(int i=1; i<size; i++) {
            T d1 = copy.get(i);
            for(int j=i-1; j>=0; j--) {
                T d2 = copy.get(j);
                if(comparator.compare(d1, d2) > 0) break;
                copy.remove(j);
                copy.add(j+1, d2);
            }
        }
        return copy;
    }
}
