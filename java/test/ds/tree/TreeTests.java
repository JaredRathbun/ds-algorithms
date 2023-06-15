package tree;

import java.util.Random;

public class TreeTests {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        Random rand = new Random();

        int randRoot = rand.nextInt();
        tree.add(randRoot, null);

        for (int i = 0; i < 10; i++) {
            int selectedVal = rand.nextInt();
            tree.add(selectedVal, randRoot);

            if (rand.nextDouble() < .5) {
                for (int j = 0; j < rand.nextInt(10); j++) 
                    tree.add(rand.nextInt(), selectedVal);
            }
        } 
        tree.printTree();
    }

    
}