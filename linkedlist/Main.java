package linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.addFirst("C");
        print(linkedList);
        linkedList.clear();
        print(linkedList);
    }

    public static void print(Object x) {
        System.out.println(x.toString());
    }
}