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
 * 
 * Lays out the methods any Tree should implement. Implementation and algorithms
 * are up to the programmer.
 * 
 * @author Jared Rathbun
 * @version 1.0
 */
public interface TreeInterface<T extends Comparable<T>> {

    /**
     * Adds new data to the tree.
     * 
     * @param data The data to add.
     */
    public void add(T data);

    /**
     * Removes the given data from the tree.
     * 
     * @param data The data to remove from the tree.
     * @return True if the removal was successful, false otherwise.
     */
    public boolean remove(T data);

    /**
     * Returns whether or not the tree is empty.
     * 
     * @return A boolean representing if the tree is empty.
     */
    public boolean isEmpty();

    /**
     * Returns the size of the tree (number of elements).
     * 
     * @return The number of elements in the tree.
     */
    public int size();

    /**
     * Returns whether or not the given data is in the tree.
     * 
     * @param data The data to search for.
     * @return A boolean if the data is in the tree or not.
     */
    public boolean contains(T data);
}
