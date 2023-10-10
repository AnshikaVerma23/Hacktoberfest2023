//Radix Sort
import java.util.Arrays;
public class RadixSort {
    // A utility function to get the maximum value in arr[]
    private static int getMax(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    // Using counting sort to sort the elements based on significant places
    private static void countingSort(int arr[], int exp) {
        int n = arr.length;
        int output[] = new int[n];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] contains
        // sorted numbers according to current digit
        System.arraycopy(output, 0, arr, 0, n);
    }

    // The main function to that sorts 'n' digits using Radix Sort
    private static void radixSort(int arr[]) {
        // Find the maximum number to know the number of digits
        int max = getMax(arr);

        // Do counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSort(arr, exp);
    }

    // A utility function to print an array
    private static void print(int arr[]) {
        int n = arr.length;
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }

    // Driver method to test above
    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;

        System.out.println("Original array:");
        print(arr);

        radixSort(arr);

        System.out.println("Sorted array:");
        print(arr);
    }
}
