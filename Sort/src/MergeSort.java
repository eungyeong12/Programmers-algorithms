import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeSort implements Sortable {
    @Override
    public <T> List<T> sort(List<T> list, Comparator<T> comparator) {
        List<T> copy = new LinkedList<>(list);
        return mergeSort(copy, comparator);
    }

    private <T> List<T> mergeSort(List<T> list, Comparator<T> comparator) {
        if(list.size() <= 1) return list;

        int mid = list.size() / 2;
        List<T> left = sort(list.subList(0, mid), comparator);
        List<T> right = sort(list.subList(mid, list.size()), comparator);

        List<T> merged = new LinkedList<>();
        while(!left.isEmpty() || !right.isEmpty()) {
            if(left.isEmpty()) {
                merged.addAll(right);
                break;
            }
            if(right.isEmpty()) {
                merged.addAll(left);
                break;
            }

            T leftFirst = left.get(0);
            T rightFirst = right.get(0);
            if(comparator.compare(leftFirst, rightFirst) < 0) {
                merged.add(left.remove(0));
            } else {
                merged.add(right.remove(0));
            }
        }
        return merged;
    }
}
