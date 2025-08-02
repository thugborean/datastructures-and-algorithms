package graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(6); // Create a new graph with 6 nodes
        graph.addEdge('A', 'B');
        graph.addEdge('B', 'A');
        graph.addEdge('B', 'C');
    }
}