public class Driver {
    public static void main(String... args) {
        int[] array = {19,22,23,25,32,34,43,52,53,53,64,65,66,71,79,83,85,85,93,99};
        new Driver(array);
    }

    public Driver(int[] array) {
        PrettyPrinter.prettyPrint(array, "Performing binarySearch() on the following:", SearchingAlgorithms
                .binarySearch(32,3, 0, array), true);
    }
}
