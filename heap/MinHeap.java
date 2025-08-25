package heap;

public class MinHeap {
    private int[] heap;
    private int capacity;
    private int depth;
    private int heapPointer = 0;


    public MinHeap(int depth) {
        this.depth = depth;
        capacity = (int)(Math.pow(2, depth) -1) + 1;
        heap = new int[capacity];
    }

public void insert(int value) {
    if (heapPointer >= heap.length) {
        throw new IllegalStateException("Heap is full");
    }

    // Place value at the end
    heap[heapPointer] = value;

    // Bubble up
    int pointer = heapPointer;
    while (pointer > 0 && heap[pointer] < heap[getParentIndex(pointer)]) {
        System.out.println("Swapping " + heap[pointer] + " and " + heap[getParentIndex(pointer)]);
        swap(pointer, getParentIndex(pointer));
        pointer = getParentIndex(pointer);
    }

    heapPointer++;
}

    public int extract() {
        return heap[0];
    }

    public int peekTop() {
        return heap[0];
    }

    public int getSize() {
        return this.heapPointer;
    }

    private void heapify(int index) {
        int left = getLeftIndex(index);
        int right = getRightIndex(index);

        int smallest = index;

        if(left < heapPointer && heap[left] < heap[smallest]) smallest = left;

        if(right < heapPointer && heap[right] < heap[smallest]) smallest = right;

        if(smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    /*
    Selected Node: index
    Parent: (Index - 1) / 2
    Left: Index * 2 + 1
    Right: Index * 2 + 2
     */
    private int getParentIndex(int index) {
        int result = (index - 1) / 2;
        if(result < 0) return 0;
            else return (index - 1) / 2;
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

    @Override
    public String toString() {
       for(int i : heap) {
        print(i);
       }
        StringBuilder sB = new StringBuilder();
        int level = 0;
        int nodesInLevel = 1;
        int nodesPrinted = 0;

        sB.append("Level 0: ");

        for (int i = 0; i < heapPointer; i++) {
            sB.append(heap[i]).append(" ");
            nodesPrinted++;

            if (nodesPrinted == nodesInLevel && i != heapPointer - 1) {
                level++;
                nodesInLevel *= 2;
                nodesPrinted = 0;
                sB.append("\nLevel ").append(level).append(": ");
            }
        }
        return sB.toString();
    }

    private static void print(Object x) {
        System.out.println(x);
    }
}