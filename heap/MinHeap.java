package heap;

public class MinHeap {
    private int[] heap;
    private int capacity;
    private int heapPointer = -1;

    public MinHeap(int depth) {
        capacity = (int)(Math.pow(2, depth) -1);
        heap = new int[capacity];
    }

    public void insert() {

    }

    public int extract() {
        return heap[0];
    }

    public int peekTop() {
        return heap[0];
    }
    /*
    Selected Node: index
    Parent: (Index - 1) / 2
    Left: Index * 2 + 1
    Right: Index * 2 + 2
     */
    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightIndex(int index) {
        return index * 2 + 2;
    }

    private void swap(int index1, int index2) {
        int val1 = heap[index1];
        int temp = heap[index2];
        heap[index1] = temp;
        heap[index2] = val1;
    }

}