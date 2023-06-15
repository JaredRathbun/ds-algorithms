package list;

import java.util.Iterator;
import java.util.Objects;

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

public class LinkedList<T extends Comparable<T>> implements List<T>, Queue<T> {
    
    /**
     * Pointers for the head and tail of the list.
     */
    private Node<T> head, tail;

    /**
     * A flag for allowing null data to be added to the list.
     */
    private final boolean ALLOW_NULL_DATA = false;

    /**
     * Constructs a new {@code LinkedList} with no elements.
     */
    public LinkedList() {

    }

    /**
     * Constructs a new {@code LinkedList} with the specified data.
     * 
     * @param data The data to add to the list.
     */
    public LinkedList(T data) {
        if (!ALLOW_NULL_DATA)
            Objects.requireNonNull(data, "Data must not be null.");

        head = new Node<>(data);
    }

    public void add(T data) {
        if (!ALLOW_NULL_DATA)
            Objects.requireNonNull(data, "Data must not be null.");

        Node<T> newNode = new Node<>(data);
        tail.setNext(newNode);
        newNode.setPrev(tail);

        tail = newNode;
    }

    @Override
    public void addAll(List<T> list) {
        if (!ALLOW_NULL_DATA)
            Objects.requireNonNull(list, "List must not be null.");

        list.forEach((data) -> add(data));
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> currentHead = head;

            @Override
            public boolean hasNext() {
                return (currentHead.getNext() != null);
            }

            @Override
            public T next() {
                Node<T> tempHead = head;
                head = head.getNext();
                return head.getData();
            }
            
            @Override
            public void remove() {

            }
        };
    }

    private Iterator<Node<T>> nodeIterator() {
        return new Iterator<Node<T>>() {

            private Node<T> currentHead = head;

            @Override
            public boolean hasNext() {
                return (currentHead.getNext() != null);
            }

            @Override
            public Node<T> next() {
                Node<T> tempHead = head;
                head = head.getNext();
                return currentHead.getNext();
            }

            @Override
            public void remove() {
                Node<T> tempPrev = currentHead.getPrev();
                Node<T> tempNext = currentHead.getNext();

                if (tempPrev != null) {
                    tempPrev.setNext(tempNext);
                    tempNext.setPrev(tempPrev);
                } else if (tempNext == null) {
                    tempPrev.setNext(null);
                } else {
                    head = tempNext;
                    tempNext.setPrev(head);
                }
            }
        };
    }

    @Override
    public boolean remove(T data) {
        if (!ALLOW_NULL_DATA)
            Objects.requireNonNull(data, "Data must not be null.");
        
        Iterator<Node<T>> itr = nodeIterator();

        while (itr.hasNext()) {
            Node<T> element = itr.next();

            if (element.getData().equals(data)) {
                itr.remove();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean removeAll(T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public int indexOf(T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public int lastIndexOf(T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
    }

    @Override
    public int countOf(T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'countOf'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean containsAll(List<T> list) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override
    public T replace(int index, T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replace'");
    }

    @Override
    public boolean replace(T oldData, T newData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replace'");
    }

    @Override
    public int replaceAll(T oldData, T newData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replaceAll'");
    }

    @Override
    public List<T> subList(int start, int end) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }

    @Override
    public T[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public void addToFront(T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToFront'");
    }

    @Override
    public void addToEnd(T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToEnd'");
    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pop'");
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'peek'");
    }

    @Override
    public boolean removeAll(List<T> list) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean contains(T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
}