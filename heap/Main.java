package heap;

public class Main {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(3);
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(3);
        minHeap.insert(6);


        print(minHeap);
    }

    public static void print(Object x) {
        System.out.println(x);
    }
}
