public class Main {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.addNode(new Node<>("A"));
        graph.addNode(new Node<>("B"));
        graph.addNode(new Node<>("C"));
        graph.addNode(new Node<>("D"));
        graph.addNode(new Node<>("E"));

        graph.generate(new int[][] {
            {0, 0, 0, 2, 0},
            {5, 0, 6, 0, 4},
            {0, 6, 0, 0, 0},
            {0, 0, 2, 0, 0},
            {0, 0, 0, 3, 0},
        });

        Node a = graph.getNode(0);
        Node target = graph.getNode(4);

        var answer1 = graph.bfs(a, target);
        System.out.println(String.format("BFS : %s (%d)", answer1.getNode(), answer1.getWeight()));

        var answer2 = graph.dfs(a, target);
        System.out.println(String.format("DFS : %s (%d)", answer2.getNode(), answer1.getWeight()));
    }
}