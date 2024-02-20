

import java.util.*;

class Connection {
    Node node;
    int weight;

    public Connection(Node node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Node {
    String name;
    List<Connection> links;
    boolean visited;

    public Node(String name) {
        this.name = name;
        this.links = new LinkedList<>();
    }

    void link(Node node, int weight) {
        links.add(new Connection(node, weight));
    }

    void visit() {
        this.visited = true;
    }

    boolean isVisited() {
        return this.visited;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

public class Main {

    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        a.link(d, 2);
        b.link(a, 5);
        b.link(c, 6);
        b.link(e, 4);
        c.link(b, 6);
        d.link(c, 2);
        e.link(d, 3);

        Node target = e;

        // BFS
        Queue<Connection> queue = new ArrayDeque<>();
        queue.add(new Connection(a, 0));

        while(!queue.isEmpty()) {
            Connection con = queue.poll();
            Node n = con.node;
            int weight = con.weight;
            n.visit();
            System.out.println(n + " (" + weight + ")");

            if(n.equals(target)) {
                System.out.println("FOUND!!");
                break;
            }

            n.links.stream()
                    .filter(i -> !i.node.isVisited())
                    .filter(i -> !queue.contains(i))
                    .map(i -> new Connection(i.node, i.weight + weight))
                    .forEach(queue::add);
        }

        // DFS

        Stack<Connection> stack = new Stack<>();
        stack.push(new Connection(a, 0));

        while(!stack.isEmpty()) {
            Connection con = stack.peek();
            Node n = con.node;
            int weight = con.weight;
            n.visit();
            System.out.println(n + " (" + weight + ")");

            if(n.equals(target)) {
                System.out.println("FOUND!!");
                break;
            }

            n.links.stream()
                    .filter(i -> !i.node.isVisited())
                    .filter(i -> !stack.contains(i))
                    .map(i -> new Connection(i.node, i.weight + weight))
                    .forEach(stack::push);
        }
    }
}