import java.security.SecureRandom;
import java.util.Arrays;

public class ArrayGeneration {

    /**
     * Generates an array of n integers, selected randomly between 1 and 10,
     * inclusive.
     *
     * @param n The length of the array to generate.
     * @return An array of length n integers.
     */
    public static int[] generateArray(int n, int bound) {
        SecureRandom rand = new SecureRandom();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(10) + 1;
        }

        return array;
    }

    /**
     * Generate a sorted array of n integers, selected randomly between the
     * specified bound, inclusive.
     *
     * @param n The length of the array to generate.
     * @return An sorted array of length n integers.
     */
    public static int[] generateSortedArray(int n, int bound) {
        SecureRandom rand = new SecureRandom();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(bound) + 1;
        }

        // SHOULD BE REPLACED WITH MERGE SORT
        Arrays.sort(array);

        return array;
    }

    /**
     * Checks to see if the specified array is sorted or not. Offers a
     * worst-case running time of O(n).
     *
     * @param array The array to analyze.
     * @return A boolean representing whether or not the array is sorted.
     */
    public static boolean isSorted(int[] array) {
        final int len = array.length;

        // Precondition check.
        if (len == 0) {
            throw new IllegalArgumentException("Array must not be empty!");
        }

        assert (len > 0);

        /* Check the base cases. If the array is of length 1, it is sorted. If
        the array is of length 2, then check the two elements. Otherwise, use a
        loop to check every element.*/
        if (len == 0 || len == 1) {
            return true;
        } else if (len == 2) {
            return array[0] < array[1];
        } else {
            // If the previous element is larger than it's predeccesor, break.
            int currentIDX = 1;
            while (currentIDX < len) {
                if (array[currentIDX - 1] > array[currentIDX]) {
                    return false;
                }

                currentIDX++;
            }
        }

        return true;
    }
}
