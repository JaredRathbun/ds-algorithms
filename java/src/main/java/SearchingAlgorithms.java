import java.util.Arrays;

public class SearchingAlgorithms {

    private static int binarySearchCount = 0;

    /**
     * Performs a binary search on the specified array. If the element cannot
     * be found, 0 is returned. Offers a O(lg n) average/worst-case running time.
     *
     * @param target The target value.
     * @param start The index to start at in the array.
     * @param end The index to end at in the array.
     * @param array The array to check against the target.
     * @return A boolean representing whether the value was found.
     */
    public static Object[] binarySearch(int target, int start, int end, int[] array) {
        binarySearchCount++;

        if (!ArrayGeneration.isSorted(array)) {
            throw new IllegalArgumentException("Array must be sorted!");
        }

        if (start == end) {
            int tempCount = binarySearchCount;
            binarySearchCount = 0;
            return new Object[]{false, tempCount};

        } else {
            int midIdx = (int) Math.floor((end + start) / 2);

            if (array[midIdx] == target) {
                int tempCount = binarySearchCount;
                binarySearchCount = 0;
                return new Object[]{true, tempCount};
            }

            if (target < array[midIdx]) {
                return binarySearch(target, start, midIdx, array);
            } else {
                return binarySearch(target, midIdx + 1, end, array);
            }
        }
    }
}
