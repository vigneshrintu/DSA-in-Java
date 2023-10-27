
public class SortingAlgos {

    public static void swap(int[] arr, int a, int b) {
        // In Java primitives such as int are always passed by value so we have to use
        // the array to swap
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void bubbleSort(int arr[]) {
        /*
         * - In nth iteration nth largest element will arrive at nth last index in an
         * array
         * - This takes least time to check if the array is sorted or not.O(n)
         */
        /*
         * Compares adjacent elements and if not in order then swaps them else moves on
         */
        // You can modify this code for descending order such that smallest element will
        // bubble up at last index
        for (int i = 0; i < arr.length - 1; i++) {
            boolean noSwaps = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    noSwaps = false;
                    swap(arr, j, j + 1);
                }
            }
            if (noSwaps) {
                return;
            }
        }

    }

    public static void selectionSort(int arr[]) {
        // In nth iteration nth smallest element will arrive at nth place in an array
        /*
         * - In each iteration, the algorithm selects the element at the current index
         * (i) as the minimum element.
         * - It then compares this minimum element with the elements from the next index
         * (i+1) to the end of the array.
         * - If it finds an element smaller than the current minimum, it updates the
         * minimum element's index to the index of the smaller element.
         * - After completing the iteration, it swaps the element at the minimum index
         * with the element at the current index (i).
         */
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;

                }
            }
            swap(arr, i, min);
        }

    }

    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int curr = arr[i];
            /*
             * Store arr[i] in curr since it is overwritten while moving the other elements
             * in array
             */

            while (j >= 0 && (arr[j] > curr)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr;
        }
    }

    public static void countingSort(int[] arr) {
        // Use count sort only when the range is very low and you can even optimise it
        // for negative numbers by making them positive and sorting in descending order
        // and adding them to final array
        int largest = Integer.MIN_VALUE;

        // Find the largest element in the input array
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // Create a count array to store the count of each element
        int[] count = new int[largest + 1];

        // Count the occurrences of each element in the input array
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Sorting - Reconstruct the sorted array
        int j = 0; // Index for the original array

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        for (i = si, k = 0; k < temp.length; i++, k++) {
            arr[i] = temp[k];
        }

    }

    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);

    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    public static void main(String args[]) {

    }

}
