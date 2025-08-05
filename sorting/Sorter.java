package sorting;

import java.util.Map;
import java.util.TreeMap;

public class Sorter {

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int lp = low;
        int rp = high;

        int pivot = arr[high];

        while(lp < rp) {
            while(arr[lp] <= pivot && lp < rp) {
                lp++;
            }

            while(arr[rp] >= pivot && lp < rp) {
                rp--;
            }
            swap(arr, lp, rp);
        }
        swap(arr, lp, high);
        quickSort(arr, low, lp - 1);
        quickSort(arr, lp + 1, high);
    }

    public static void selectionSort(int[] arr) {
        int smallest = 0;
        int pointer = 0;
        while(pointer < arr.length) {
            smallest = pointer;
            for(int i = pointer; i < arr.length; i++) {
                if(arr[smallest] > arr[i]) smallest = i;
            }
            swap(arr, smallest, pointer);
            pointer++;
        }
    }

    public static void bubbleSort(int[] arr) {
        boolean swapped = false;
        for(int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
        if(!swapped) break;
        }
    }
    
    public static int[] countingSort(int[] arr) {
        Map<Integer, Integer> buckets = new TreeMap<>();
        for(int i = 0; i < arr.length; i++ ) {
            if(!buckets.containsKey(arr[i])) {
                buckets.put(arr[i], 1);
                continue;
            }
            int counter = buckets.get(arr[i]) + 1;
            buckets.put(arr[i], counter);
        }
        int pointer = 0;
        int[] newArray = new int[arr.length];
        for(Map.Entry<Integer, Integer> entry : buckets.entrySet()) {
            for(int i = 0; i < entry.getValue(); i++) {
                newArray[pointer] = entry.getKey();
                pointer++;
            }
        }
        return newArray;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1]; // The value of index2
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}