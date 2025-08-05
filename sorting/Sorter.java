package sorting;

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

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1]; // The value of index2
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}