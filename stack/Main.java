package stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < 20; i++) {
            stack.push(i);
            print(stack);
        }
        print(stack);
        print(stack.size());
    }

    public static void print(Object x) {
        System.out.println(x);
    }
}