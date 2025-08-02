package linkedlist;

public class LinkedList <T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(int index, T value) {
        // Check for out of bounds
        if(index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node<T> newNode = new Node<>(value);
        if(isEmpty()) {
            head = tail = newNode;
        } else {
            Node<T> beforeNode = head;
            // Browse forward to the index
            for(int i = 0; i < index; i++) {
                beforeNode = beforeNode.next;
            }
            //If it's the end of the list
            if(beforeNode == tail) {
                beforeNode.next = newNode;
                tail = newNode;
                size++;
                return;
            }
            Node<T> afterNode = beforeNode.next;
            beforeNode.next = newNode;
            newNode.next = afterNode;
        }
        size++;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if(isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
            if(tail == null) tail = head;
        }
        size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        if(isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if(isEmpty()) return;
        if(index == 0) {
            removeFirst();
            return;
        }
        Node<T> beforeNode = head;
        // Loop to before the node we want to delete
        for(int i = 0; i < index - 1; i++) {
            beforeNode = beforeNode.next;
        }
        Node<T> deletedNode = beforeNode.next;
        if(deletedNode == null) throw new IndexOutOfBoundsException();
        Node<T> afterNode = deletedNode.next;
        beforeNode.next = afterNode;
        if(afterNode == null) tail = beforeNode;
        size--;
    }

    public void removeFirst() {
        if(isEmpty()) return;
        Node<T> afterNode = head.next;
        head.next = null;
        head = afterNode;

        if(head == null) tail = null;
        size--;
    }

    public void removeLast() {
        if(isEmpty()) return;
        if(head == tail) {
            head = tail = null;
        } else {
            Node<T> currentNode = head;
            while(currentNode.next != tail) {
                currentNode = currentNode.next;
            }
        currentNode.next = null;
        tail = currentNode;
        }
        size--;
    }

    public T getFirst() {
        return isEmpty() ? null : head.value;
    }

    public T get(int index) {
        if(isEmpty()) return null;
        if(index < 0 || index >= size ) throw new IndexOutOfBoundsException();
        Node<T> currentNode = head;
        for(int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }

    public T getLast() {
        return isEmpty() ? null : tail.value;
    }

    public void set(int index, T value) {
        if(isEmpty()) return;
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> currentNode = head;
        for(int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.value = value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return this.size;
    }

    public boolean contains(T value) {
        if(isEmpty()) return false;
        Node<T> currentNode = head;
        if(currentNode.value == value) return true;
        while(currentNode != null) {
            if(currentNode.equals(value)) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    public void clear() {
        if(isEmpty()) return;
        if(head == tail) head = tail = null;
        while(head != null) removeFirst();
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder("[");
        Node<T> currentNode = head;
        while (currentNode != null) {
            sB.append(currentNode.value);
            if (currentNode.next != null) {
                sB.append(" → ");
            }
            currentNode = currentNode.next;
        }
        sB.append("]");
        return sB.toString();
    }
}