package queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(100);
        for(int i = 0; i < 21; i++) queue.enqueue(i);
        print(queue.size());
    }

    public static void print(Object x) {
        System.out.println(x);
    }
}