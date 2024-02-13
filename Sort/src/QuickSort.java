import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class QuickSort implements Sortable{
    @Override
    public <T> List<T> sort(List<T> list, Comparator<T> comparator) {
        List<T> copy = new LinkedList<>(list);
        return quickSort(copy, comparator);
    }

    private <T> List<T> quickSort(List<T> list, Comparator<T> comparator) {
        if(list.size() <= 1) return list;

        T pivot = list.remove(list.size()/2);
        List<T> lesser = quickSort(sublist(list, (d) -> comparator.compare(pivot, d) > 0), comparator);
        List<T> greater = quickSort(sublist(list, (d) -> comparator.compare(pivot, d) <= 0), comparator);

        return new LinkedList<>() {{
            addAll(lesser);
            add(pivot);
            addAll(greater);
        }};
    }

    private <T> List<T> sublist(List<T> list, Predicate<T> filter) {
        return list.stream().filter(filter).collect(Collectors.toList());
    }
}
