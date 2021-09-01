public class Driver {
    public static void main(String... args) {
        int[] array = {19,22,23,25,32,34,43,52, 66, 77, 88, 99, 102, 204, 222, 445, 6567, 67767};
        new Driver(array);
    }

    public Driver(int[] array) {
        PrettyPrinter.prettyPrint(array, "Performing binarySearch() on the following:", SearchingAlgorithms
                .binarySearch(22,0, array.length, array), true);
    }
}
