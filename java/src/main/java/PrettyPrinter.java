public class PrettyPrinter {
    public static void prettyPrint(int[] array, String text, Object[] result, boolean drawLines) {
        String indentedBorder = "\t+";
        String upperAndLowerBorder = "===";
        int horizontalLineLength = 0;

        // Build a String to hold the indented border.
        for (int i = 0; i < array.length; i++) {
            final int len = 2 + String.valueOf(array[i]).length();
            for (int j = 0; j < len; j++) {
                indentedBorder += "-";
                horizontalLineLength += len;
            }
            indentedBorder += "+";
        }

        // Draw the upper horizontal rule.
        for (int i = 0; i < horizontalLineLength / 3; i++) {
            upperAndLowerBorder += "=";
        }
        upperAndLowerBorder += "===";
        System.out.println(upperAndLowerBorder);

        // Print out the text.
        System.out.println(text);

        // Print the indented border, then the array.
        System.out.println(indentedBorder);
        System.out.print("\t|");
        for (int i = 0; i < array.length; i++) {
            System.out.printf(" %d |", array[i]);
        }
        System.out.println("\n" + indentedBorder);

        // Print the result.
        System.out.println("Result: " + result[0]);
        System.out.println("Total Number of Calls: " + result[1]);

        // Print the last horizontal rule.
        System.out.println(upperAndLowerBorder);
    }
}
