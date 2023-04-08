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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

/**
 * Implementation of a N-Ary tree.
 * 
 * @author Jared Rathbun
 * @since 1.0
 */
public class Tree<T extends Comparable<T>> implements TreeInterface<T> {

    /**
     * The number of nodes the tree contains.
     */
    private int nodeCount;

    /**
     * The root of the tree.
     */
    private Node<T> root;

    /**
     * Constructs a new Tree.
     */
    public Tree() {
        root = null;
        nodeCount = 0;
    }

    /**
     * Constructs the Tree with the provided {@code data}.
     * 
     * @param data The data to add to the root of the tree.
     */
    public Tree(T data) {
        root = new Node<>(data, null);
        nodeCount = 1;
    }

    /**
     * Adds the given data to the tree.
     * 
     * @implSpec This method should only be used to add elements to the root of
     *           the tree. If the d{@code data} should be added as a child of an
     *           element already in the tree, then use the other
     *           {@link Tree#add(Comparable, Comparable) add} method
     *           implementation.
     * @implNote This method runs in O(n) time.
     * @param data The {@code data} to add to the tree.
     * @see Tree#add(Comparable, Comparable)
     */
    @Override
    public void add(T data) {
        Objects.requireNonNull(data, "Data must not be null.");

        if (root == null) {
            root = new Node<>(data, null);
        } else {
            root.addChild(data);
        }
    }

    /**
     * Adds the provided {@code data} as a child of {@code parent}.
     * 
     * @implSpec This method is designed to add data as a child of an element
     *           that is already in the tree. If the {@code parent} is
     *           {@code null} then the data is added as a child of the root.
     *           If you are looking to add data to the root of the tree, use
     *           {@link Tree#add(Comparable) add}.
     * @implNote This method runs in O(n) time.
     * @param data   The data to add.
     * @param parent The parent to add the data to as a child.
     */
    public void add(T data, T parent) {
        Objects.requireNonNull(data, "Data must not be null!");

        if (parent == null) {
            add(data);
        }

        Node<T> parentNode;
        if (parent != null) {
            parentNode = search(parent, false);
            parentNode.addChild(data);
        } else {
            root = new Node<>(data, null);
        }

        nodeCount++;
    }

    /**
     * Removes the given data from the tree.
     * 
     * @implNote This method runs in O(n) time.
     * @param data The data to remove.
     * @return A boolean representing if the data was removed successfully or
     *         not.
     */
    @Override
    public boolean remove(T data) {
        Objects.requireNonNull(data, "Data must not be null!");

        Node<T> parentNode;
        try {
            parentNode = search(data, true);
        } catch (NoSuchElementException ex) {
            return false;
        }

        if (parentNode.removeChild(data)) {
            nodeCount--;
            return true;
        } else {
            return false;
        }
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
     * Returns whether or not the given {@code data} is in the tree or not.
     * 
     * @implSpec The method runs in O(n) time.
     * @param data The data to check for membership in the tree.
     * @return True if the data is in the tree, false otherwise.
     */
    @Override
    public boolean contains(T data) {
        return (search(data, false) == null);
    }

    private Node<T> search(T target, boolean getParent)
            throws NoSuchElementException {
        Node<T> searchNode = breadthFirstSearch(target).get();

        if (getParent)
            return searchNode.getParent();

        return searchNode;
    }

    public void printTree() {
        LinkedList<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        HashSet<Node<T>> visitedSet = new HashSet<>();
        while (!queue.isEmpty()) {
            Node<T> currentNode = queue.pop();

            String childrenString = "";
            for (Node<T> child : currentNode.getChildrenNodes()) {
                childrenString += child.getData() + " ";
                queue.add(child);
            }

            visitedSet.add(currentNode);
            queue.removeAll(visitedSet);

            if (!childrenString.equals(""))
                System.out.println(currentNode
                        .getData() + " -> " + childrenString);
        }
    }

    private Optional<Node<T>> breadthFirstSearch(T target) {
        LinkedList<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        HashSet<Node<T>> visitedSet = new HashSet<>();

        while (!queue.isEmpty()) {
            Node<T> currentNode = queue.pop();

            if (currentNode.getData().equals(target))
                return Optional.of(currentNode);
            else
                visitedSet.add(currentNode);
            queue.addAll(currentNode.getChildrenNodes());
            queue.removeAll(visitedSet);
        }

        return Optional.empty();
    }

    private class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
        private T data;
        private Node<T> parent;
        private ArrayList<Node<T>> children;

        /**
         *
         * @param data
         * @param parent
         */
        public Node(T data, Node<T> parent) {
            this.data = data;
            this.parent = parent;
            this.children = new ArrayList<>();
        }

        public T getData() {
            return data;
        }

        public ArrayList<Node<T>> getChildrenNodes() {
            return children;
        }

        public Node<T> getParent() {
            return parent;
        }

        /**
         * Adds a new child to the {@code Node}.
         * 
         * @param child The child data to add to this node.
         * @return The number of children this {@code Node} has after inserting
         *         the new data.
         */
        public int addChild(T child) {
            Node<T> childNode = new Node<>(Objects.requireNonNull(child,
                    "Child must not be null!"), this);

            if (children == null)
                children = new ArrayList<>();

            children.add(childNode);

            Collections.sort(children);

            return children.size();
        }

        /**
         * Removes the provided child from the tree.
         *
         * @param child The data to remove.
         * @return A boolean representing if the removal was successful or not.
         */
        public boolean removeChild(T child) {
            T childData = (T) Objects.requireNonNull(child,
                    "Child must not be null!");

            if (children == null)
                return false;

            return children.removeIf((node) -> node.getData()
                    .equals(childData));
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
