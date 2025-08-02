package graph;

public class Node {
    static int counter = 0;
    char name;
    int value;

    public Node(int value) {
        if(counter >= 26) throw new RuntimeException("Too many nodes!");
        this.name = (char)('A' + counter);
        counter++;
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public char getName() {
        return this.name;
    }
}