import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

// Original Bubble Sort Implementation
class GFG {
    // An optimized version of Bubble Sort
    static void bubbleSort(int arr[], int n) {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }

    // Function to print an array
    static void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        int n = arr.length;
        bubbleSort(arr, n);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}

// Test class for GFG
public class GFGTest {
    
    // Utility method to check if array is sorted
    private boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Positive Cases
    @Test
    public void testNormalArray() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};
        GFG.bubbleSort(arr, arr.length);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] arr = {5, 2, 8, 5, 2, 6, 9};
        int[] expected = {2, 2, 5, 5, 6, 8, 9};
        GFG.bubbleSort(arr, arr.length);
        assertArrayEquals(expected, arr);
    }

    // Boundary Cases
    @Test
    public void testEmptyArray() {
        int[] arr = {};
        GFG.bubbleSort(arr, arr.length);
        assertEquals(0, arr.length);
    }

    @Test
    public void testSingleElementArray() {
        int[] arr = {42};
        int[] expected = {42};
        GFG.bubbleSort(arr, arr.length);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        GFG.bubbleSort(arr, arr.length);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        GFG.bubbleSort(arr, arr.length);
        assertArrayEquals(expected, arr);
    }

    // Performance Cases
    @Test
    public void testLargeArray() {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        GFG.bubbleSort(arr, arr.length);
        assertTrue(isSorted(arr));
    }

    // Negative Cases
    @Test(expected = NullPointerException.class)
    public void testNullArray() {
        int[] arr = null;
        GFG.bubbleSort(arr, 0);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testIncorrectLength() {
        int[] arr = {1, 2, 3};
        GFG.bubbleSort(arr, 4); // Passing length greater than array size
    }

    // Idempotency Cases
    @Test
    public void testMultipleSorts() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};
        
        // First sort
        GFG.bubbleSort(arr, arr.length);
        assertArrayEquals(expected, arr);
        
        // Second sort
        GFG.bubbleSort(arr, arr.length);
        assertArrayEquals(expected, arr);
        
        // Third sort
        GFG.bubbleSort(arr, arr.length);
        assertArrayEquals(expected, arr);
    }

    // Additional edge cases
    @Test
    public void testArrayWithNegativeNumbers() {
        int[] arr = {-5, 12, -3, 0, -8, 9};
        int[] expected = {-8, -5, -3, 0, 9, 12};
        GFG.bubbleSort(arr, arr.length);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testArrayWithAllSameElements() {
        int[] arr = {4, 4, 4, 4, 4};
        int[] expected = {4, 4, 4, 4, 4};
        GFG.bubbleSort(arr, arr.length);
        assertArrayEquals(expected, arr);
    }
}