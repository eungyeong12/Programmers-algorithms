
public class Connection<T> {
    private Node<T> node;
    private int weight;

    public Connection(Node<T> node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public Node<T> getNode() {
        return node;
    }

    public int getWeight() {
        return weight;
    }
}
