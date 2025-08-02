package queue;
import linkedlist.LinkedList;

public class Queue <T>{
    private LinkedList<T> linkedList = new LinkedList<>();
    private final int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
    }

    public Queue() {
        this.capacity = 20;
    }

    public void enqueue(T data) {
        if(isFull()) throw new IllegalStateException("Queue is full!");
        linkedList.addLast(data);
    }

    public T dequeue() {
        if(isEmpty()) return null;
        T value = linkedList.getFirst();
        linkedList.removeFirst();
        return value;
    }

    public T getFront() {
        return linkedList.getFirst();
    }

    public T getRear() {
        return linkedList.getLast();
    }

    public boolean isFull() {
        return linkedList.size() == capacity;
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public int size() {
        return linkedList.size();
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder();
        sB.append("Front → ");
        for(int i = 0; i < linkedList.size(); i++) {
            sB.append(linkedList.get(i) + " ");
        }
        return sB.toString();
    }
}