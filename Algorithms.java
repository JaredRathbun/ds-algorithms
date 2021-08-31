import java.security.SecureRandom;
import java.util.Arrays;

public class Algorithms implements PrettyPrinter {

    /** 
     * An array of 20 integers to serve as the test array.
     */
    private final int[] MASTER_ARRAY = {
        215, 828, 927, 178, 97, 929, 848, 601, 
        356, 644, 419, 803, 506, 380, 849, 927, 13, 218, 918, 262
    };

    public int call = 0;

    public Algorithms() {
        System.out.println(isSorted(MASTER_ARRAY));

        Arrays.sort(MASTER_ARRAY);
        System.out.println(binarySearch(852, 0, MASTER_ARRAY.length, 
            MASTER_ARRAY));
        
        prettyPrint(MASTER_ARRAY, "Test", true);
    }

    /**
     * Performs a binary search on the specified array. If the element cannot 
     * be found, 0 is returned. Offers a O(lg n) worst-case running time.
     * 
     * @param target The target value.
     * @param start The index to start at in the array.
     * @param end The index to end at in the array.
     * @param array The array to check against the target.
     * @return A boolean representing whether or not the value was found.
     */
    public boolean binarySearch(int target, int start, int end, int[] array) {
        if (!isSorted(array)) {
            throw new IllegalArgumentException("Array must be sorted!");
        }

        if (start == end && array[start] != target) {
            return false;
        } else {
            int midIdx = start + (end - start) / 2;
            int midVal = array[midIdx];

            if (target == midVal) {
                return true;
            }
            else if (target < midVal) {
                return binarySearch(target, start, midIdx, array);
            } else {
                return binarySearch(target, midIdx + 1, end, array);
            }
        }
    }

    /**
     * Generates an array of n integers, selected randomly between 1 and 10, 
     * inclusive.
     * 
     * @param n The length of the array to generate.
     * @return An array of length n integers.
     */
    public int[] generateArray(int n, int bound) {
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
    public int[] generateSortedArray(int n, int bound) {
        SecureRandom rand = new SecureRandom();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(1000);
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
    public boolean isSorted(int[] array) {
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
