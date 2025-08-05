package sorting;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[10];
        for(int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }
        print("Before:");
        for(int i : array) {
            print(i);
        }

        Sorter.quickSort(array, 0, array.length - 1);

        print("After:");
        for(int i : array) {
            print(i);
        }

    }

    public static void print(Object x) {
        System.out.println(x);
    }
}