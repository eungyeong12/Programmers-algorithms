import java.util.*;

public class Graph<T> {
    private List<Node<T>> nodes = new ArrayList<>();

    public void addNode(Node<T> node) {
        nodes.add(node);
    }

    public Node<T> getNode(int index) {
        return nodes.get(index);
    }

    public void generate(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            int[] row = matrix[i];
            for(int j=0; j<row.length; j++) {
                if(row[j] == 0) continue;
                nodes.get(i).link(nodes.get(j), row[j]);
            }
        }
    }

    public void reset() {
        nodes.forEach(Node::resetVisit);
    }

    public Connection<T> bfs(Node<T> start, Node<T> target) {
        reset();

        Queue<Connection<T>> queue = new ArrayDeque<>();
        queue.offer(new Connection<>(start, 0));

        while(!queue.isEmpty()) {
            Connection<T> con = queue.poll();
            Node<T> n = con.getNode();
            int weight = con.getWeight();
            n.visit();

            if(n.equals(target)) {
                return new Connection<>(target, weight);
            }

            n.connections().stream()
                    .filter(i -> !i.getNode().isVisited())
                    .filter(i -> !queue.contains(i))
                    .map(i -> new Connection(i.getNode(), i.getWeight() + weight))
                    .forEach(queue::offer);
        }

        return null;
    }

    public Connection<T> dfs(Node<T> start, Node<T> target) {
        reset();

        Stack<Connection<T>> stack = new Stack<>();
        stack.push(new Connection<>(start, 0));

        while(!stack.isEmpty()) {
            Connection<T> con = stack.pop();
            Node<T> n = con.getNode();
            int weight = con.getWeight();
            n.visit();

            if(n.equals(target)) {
                return new Connection<>(target, weight);
            }

            n.connections().stream()
                    .filter(i -> !i.getNode().isVisited())
                    .filter(i -> !stack.contains(i))
                    .map(i -> new Connection(i.getNode(), i.getWeight() + weight))
                    .forEach(stack::push);
        }

        return null;
    }
}
