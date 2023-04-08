package tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.add(50);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.add(70);
        tree.add(60);
        tree.add(80);

        tree.inOrderPrint();

        System.out.println();

        tree.remove(30);
        tree.remove(60);

        tree.inOrderPrint();
    }
}
