package tree;

/**
 * This file is part of ds-algorithms.
 * 
 * ds-algorithms is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by the Free 
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * ds-algorithms is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more 
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * ds-algorithms. If not, see <https://www.gnu.org/licenses/>.
 */
import java.util.Objects;

/**
 * Implementation of a Binary Search Tree.
 * 
 * @author Jared Rathbun
 * @since 1.0
 */
public class BinarySearchTree<T extends Comparable<T>> implements 
        TreeInterface<T> {

    /**
     * The number of nodes the tree contains.
     */
    private int nodeCount;

    /**
     * The root of the tree.
     */
    private Node<T> root;

    /**
     * Constructs a new BST.
     */
    public BinarySearchTree() {
        root = null;
        nodeCount = 0;
    }

    /**
     * Creates a new BST with the data provided as the root.
     * 
     * @param data The data to add to the root of the tree.
     */
    public BinarySearchTree(T data) {
        root = new Node<T>(data);
        nodeCount = 0;
    }

    /**
     * Adds the given data to the tree.
     * 
     * @implNote This method runs in O(n) time.
     * @param data The data to add.
     */
    @Override
    public void add(T data) {
        Objects.requireNonNull(data, "Data must not be null.");

        if (root == null)
            root = new Node<T>(data);
        else
            recursiveInsert(root, data);

        nodeCount++;
    }

    /**
     * Removes the given data from the tree.
     *  
     * @implNote This method runs in O(n) time.
     * @param data The data to remove.
     * @return True if the removal was successful, false otherwise.
     */
    @Override
    public boolean remove(T data) {
        Objects.requireNonNull(data, "Data must not be null.");

        if (!contains(data))
            return false;

        root = recursiveDelete(root, data);
        
        return true;
    }

    /**
     * Returns whether or not the tree is empty.
     * 
     * @implNote This method runs in Θ(1) time.
     * @return True if the tree is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return (nodeCount == 0);
    }

    /**
     * Returns the size of the tree.
     * 
     * @implNote This method runs in Θ(1) time.
     * @return The size of the tree.
     */
    @Override
    public int size() {
        return nodeCount;
    }

    /**
     * Returns whether or not the tree contains the given data.
     * 
     * @apiNote This method runs in O(n) time.
     * @return True if the tree contains the data, false otherwise.
     */
    @Override
    public boolean contains(T data) {
        Objects.requireNonNull(data, "Data must not be null.");
        Node<T> searchResult = depthFirstSearch(root, data);

        return (searchResult == null) 
            ? false 
            : (searchResult.getData().equals(data));
    }

    /**
     * Prints the tree using a pre-order traversal.
     */
    public void inOrderPrint() {
        inOrderPrint(root);
    }

    /**
     * Recursively traverses through the tree using a pre-order traversal.
     * 
     * @apiNote This method runs in Θ(n) time.
     * @param root The root of the tree.
     */
    private void inOrderPrint(Node<T> root) {
        if (root != null) {
            inOrderPrint(root.getLeft());
            System.out.println(root.getData());
            inOrderPrint(root.getRight());
        }
    }

    /**
     * Recursively inserts the given data into the tree.
     * 
     * @implSpec This method runs in O(n) time.
     * @param root The root of the tree.
     * @param data The data to add.
     * @return The root of the tree.
     */
    private Node<T> recursiveInsert(Node<T> root, T data) {
        if (root == null) {
            return new Node<T>(data);
        } else {
            int compareResult = root.getData().compareTo(data);

            if (compareResult == 1) {
                root.setLeft(recursiveInsert(root.getLeft(), data));
            } else if (compareResult == -1) {
                root.setRight(recursiveInsert(root.getRight(), data));
            }

            return root;
        }
    }

    /**
     * Recursively removes the given data from the tree.
     * 
     * @implSpec This method runs in O(n) time.
     * @param root The root of the tree.
     * @param data The data to remove.
     * @return The root of the tree.
     */
    private Node<T> recursiveDelete(Node<T> root, T data) {
        if (root == null) {
            return root;
        } 
        
        int compareResult = root.getData().compareTo(data);
        Node<T> left = root.getLeft(), right = root.getRight();
        
        if (compareResult == 1) {
            root.setLeft(recursiveDelete(left, data));
        } else if (compareResult == -1) {
            root.setRight(recursiveDelete(right, data)); 
        } else {
            if (left == null)
                return right;
            else if (right == null) {
                return left;
            }

            root.setData((root.compareTo(left) < root.compareTo(right)) ? left
                .getData() : right.getData());
            root.setRight(recursiveDelete(right, root.getData()));
        }

        return root;
    }

    /**
     * Performs a depth first search on the tree.
     * 
     * @implSpec This method runs in O(n) time.
     * @param root The root of the tree.
     * @param key The key to search for.
     * @return The root of the tree.
     */
    private Node<T> depthFirstSearch(Node<T> root, T key) {
        if (root == null || key.equals(root.getData())) {
            return root;
        } 

        if (root.getData().compareTo(key) == 1) {
            return depthFirstSearch(root.getLeft(), key);
        } else {
            return depthFirstSearch(root.getRight(), key);
        }
    }

    private class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
        private T data;
        private Node<T> left, right;
        
        public Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }

        public void setLeft(Node<T> node) {
            left = node;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setRight(Node<T> node) {
            right = node;
        }

        public Node<T> getRight() {
            return right;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            Objects.requireNonNull(data, "Data must not be null.");
            this.data = data;
        }

        /**
         * Compares {@code this} node against another node.
         * 
         * @param o The other node to compare against.
         * @return The result of comparing the two nodes.
         */
        @Override
        public int compareTo(Node<T> o) {
            return data.compareTo(o.getData());
        }
    }
}