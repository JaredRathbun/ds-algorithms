package list;

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

/**
 * Implementation for a doubly-linked Node.
 * 
 * @author Jared Rathbun
 * @version 1.0
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    private T data;
    private Node<T> prev, next;

    public Node(T data) {
        this.data = data;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public Node<T> setPrev(Node<T> node) {
        Node<T> currentPrev = prev;
        prev = node;
        return currentPrev;
    }

    public Node<T> setNext(Node<T> node) {
        Node<T> currentNext = next;
        next = node;
        return currentNext;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    @Override
    public int compareTo(Node<T> o) {
        return data.compareTo(o.getData());
    }
}
