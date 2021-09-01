public class PrettyPrinter {
    public static void prettyPrint(int[] array, String text, Object[] result, boolean drawLines) {
        String horizontalLine = "";
        for (int j = 0; j < array.length; j++) {
            horizontalLine += "=====";
        }

        if (drawLines) {
            System.out.println(horizontalLine);
        }

        System.out.println(text);

        // Calculate the center of the top line for neatness.
        int spaceShift = horizontalLine.length() / array.length;
        String padding = "";
        for (int i = 0; i < spaceShift; i++) {
            padding += "  ";
        }

        // Print the padding and another horizontal line.
        for (int j = 0; j < array.length; j++) {
            System.err.print("-----");
        }

        // Print the padding and then a single pipe to start the line.
        System.err.print("\n");

        System.err.print("|");

        for (int j = 0; j < array.length; j++) {
            System.err.printf(" %d |", array[j]);
        }

        System.err.print("\n");

        for (int j = 0; j < array.length; j++) {
            System.err.print("-----");
        }

        System.err.println("");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Result: " + result[0]);
        System.out.println("Completed in " + result[1] + " calls.");
        System.out.println(horizontalLine);
    }
}
