import java.util.Comparator;
import java.util.List;

public interface Sortable {
    <T> List<T> sort(List<T> list, Comparator<T> comparator);

    default <T extends Comparable> List<T> sort(List<T> list) {
        return sort(list, Comparable::compareTo);
    }
}
