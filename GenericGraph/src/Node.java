import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Node<T> {
    private T data;
    private List<Connection<T>> links;
    public boolean visited;

    public Node(T name) {
        this.data = name;
        this.links = new LinkedList<>();
    }

    public List<Connection<T>> connections() {
        return links;
    }

    public void link(Node<T> node, int weight) {
        links.add(new Connection<>(node, weight));
    }

    public void resetVisit() {
        this.visited = false;
    }

    public void visit() {
        this.visited = true;
    }

    public boolean isVisited() {
        return this.visited;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
