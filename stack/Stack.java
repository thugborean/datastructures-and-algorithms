package stack;

public class Stack <T>{
    private int startingCap = 10;
    private int currentCap = startingCap;
    private int size = 0;
    private int stackPointer = -1;
    private T[] holdingStack;

    public Stack() {
        holdingStack = (T[]) new Object[startingCap];
    }

    public Stack(int size) {
        holdingStack = (T[]) new Object[size];
    }

    public void push(T value) {
        if(isFull()) resize();
        stackPointer++;
        size++;
        holdingStack[stackPointer] = value;
    }

    public T pop() {
        if(isEmpty()) return null;
        T value = holdingStack[stackPointer];
        stackPointer--;
        size--;
        return value;
    }

    public T peek() {
        return holdingStack[stackPointer];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return stackPointer == currentCap - 1;
    }

    public int size() {
        return this.size;
    }

    private void resize() {
        T[] newStack = (T[]) new Object[currentCap * 2];
        System.arraycopy(holdingStack, 0, newStack, 0, currentCap);
        holdingStack = newStack;
        currentCap *= 2;
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder();
        sB.append("Top → ");
        for(int i = size - 1; i >= 0; i--) {
            sB.append(holdingStack[i] + " ");
        }
        return sB.toString();
    }
}