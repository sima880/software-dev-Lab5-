import java.util.Arrays;

/**
 * Demonstrates sorting algorithms (Quick Sort and Merge Sort) along with
 * array swapping and sorted-order verification utilities.
 *
 * @author sima
 * @version 1.0
 */
public class SortExample {

    /**
     * Runs sample arrays through Quick Sort and Merge Sort and prints the results.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Integer[] array1 = new Integer[] { 12, 13, 24, 10, 3, 6, 90, 70 };
        int[] array2 = { 2, 6, 3, 5, 1 };

        quickSort(array1, 0, array1.length - 1);
        System.out.println(Arrays.toString(array1));

        mergeSort(array2, array2.length);
        System.out.println(Arrays.toString(array2));
    }

    /**
     * Sorts an {@code Integer} array in ascending order using the Quick Sort algorithm.
     *
     * @param arr  the array of {@code Integer} elements to sort
     * @param low  the starting index of the partition to sort
     * @param high the ending index of the partition to sort
     */
    public static void quickSort(Integer[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        int i = low, j = high;

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    /**
     * Swaps two elements in an {@code Integer} array at the specified indices.
     *
     * @param array the {@code Integer} array containing elements to swap
     * @param x     the index of the first element
     * @param y     the index of the second element
     */
    public static void swap(Integer[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     * Sorts an {@code int} array in ascending order using the Merge Sort algorithm.
     *
     * @param a the {@code int} array to sort
     * @param n the number of elements to include from the start of the array
     */
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }

    /**
     * Merges two sorted subarrays ({@code l} and {@code r}) into a single sorted
     * target array ({@code a}).
     *
     * @param a     the target {@code int} array that receives the merged elements
     * @param l     the sorted left subarray
     * @param r     the sorted right subarray
     * @param left  the number of elements in the left subarray {@code l}
     * @param right the number of elements in the right subarray {@code r}
     */
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    /**
     * Checks whether an {@code int} array is sorted in non-decreasing (ascending) order.
     *
     * @param x the {@code int} array to check
     * @return {@code true} if all elements are in ascending order, {@code false} otherwise
     */
    private static boolean isSorted(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] > x[i + 1]) {
                return false;
            }
        }
        return true;
    }
}