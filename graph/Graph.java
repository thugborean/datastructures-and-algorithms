package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    int nOfNodes;
    List<Node> nodes;
    List<List<Character>> adjecencyList;

    public Graph(int nOfNodes) {
        this.nOfNodes = nOfNodes;
        nodes = new ArrayList<>();
        for(int i = 0; i < nOfNodes; i++) {
            nodes.add(new Node(1)); // Adds a new node with the value of one, Nodes are named from A -> Z
        }
        for(int i = 0; i < nOfNodes; i++) {
            adjecencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(char from, char to) {
        if(from == to) throw new RuntimeException("Node cannot connect to itself!");
        adjecencyList.get(from).add(to); // Gets the nodes list of neighbours then adds the neighbour node to it
    }
}