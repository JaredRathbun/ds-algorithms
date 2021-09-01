public class Driver {
    public static void main(String... args) {
        int[] array = ArrayGeneration.generateSortedArray(10000, 555);
        new Driver(array);
    }

    public Driver(int[] array) {
        PrettyPrinter.prettyPrint(array, "Performing binarySearch() on " +
                "the following array:", SearchingAlgorithms
                .binarySearch(263,0, array.length, array), true);
    }
}
