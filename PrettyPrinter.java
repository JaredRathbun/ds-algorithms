public interface PrettyPrinter {
    default void prettyPrint(int[] array, String text, boolean drawLines) {   
        String horizontalLine = "";
        for (int j = 0; j < array.length; j++) {
            horizontalLine += "--------";
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
        System.err.print(padding);
        for (int j = 0; j < array.length; j++) {
            System.err.print("------");
        }

        // Print the padding and then a single pipe to start the line.
        System.err.print("\n" + padding);
        System.err.print(" |");
        
        for (int j = 0; j < array.length; j++) {
            System.err.print(" " + array[j] + " |");
        }

        System.err.print("\n" + padding);

        for (int j = 0; j < array.length; j++) {
            System.err.print("------");
        }

        System.err.println("");
    
        if (drawLines) {
            System.out.println(horizontalLine);
        }
    }
}