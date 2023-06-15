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
import java.util.Iterator;

/**
 * Lays out the methods any List should implement. Implementation and algorithms
 * are up to the programmer.
 * 
 * @author Jared Rathbun
 * @version 1.0
 */
public interface List<T> extends Iterable<T> {

    /**
     * Adds new data to the list.
     * 
     * @param data The data to add.
     */
    public void add(T data);

    /**
     * Adds all elements in the specified {@code List} to {@code this}.
     * 
     * @param list
     */
    public void addAll(List<T> list);

    /**
     * Removes the provided element from the list.
     * 
     * @param data The data to remove from the list.
     * @return True if the element was found and removed, false otherwise.
     */
    public boolean remove(T data);

    /**
     * Removes all elements in the {@code List} from {@code this}.
     * 
     * @param data The {@code List} of elements to remove.
     * @return True if all elements were removed, false otherwise.
     */
    public boolean removeAll(T data);

    /**
     * Returns whether or not the list is empty.
     * 
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Finds and returns the index of the specified data.
     * 
     * @param data The data to search for.
     * @return The index of the element if found, -1 otherwise.
     */
    public int indexOf(T data);

    /**
     * Returns the last index the specified element was found at.
     * 
     * @param data The data to search for.
     * @return The last element where the element was found, -1 otherwise.
     */
    public int lastIndexOf(T data);

    /**
     * Returns the number of specified elements in the list.
     * 
     * @param data The data to count for.
     * @return The number of elements found.
     */
    public int countOf(T data);

    /**
     * Clears the list.
     */
    public void clear();

    /**
     * Returns the size of the list.
     * 
     * @return An int containing the size of the list.
     */
    public int size();

    /**
     * Searches the list for the specified element.
     * 
     * @return True if the data was found, false otherwise.
     */
    public boolean contains(T data);

    /**
     * Compares every element in the specified list against {@code this} for set
     * containment.
     * 
     * @param list The list to check for containment.
     * @return True if all elements were present, false otherwise.
     */
    public boolean containsAll(List<T> list);

    /**
     * Replaces the element at the specified index with the provided data.
     * 
     * @param index The index to replace the element at.
     * @param data The replacement data.
     * @return The data was replaced, if present. {@code null} otherwise.
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    public T replace(int index, T data);

    /**
     * Replaces the specified {@code oldData} with {@code newData}.
     * 
     * @param oldData The data to replace.
     * @param newData The replacement data.
     * @return True if the data was replaced, false otherwise.
     */
    public boolean replace(T oldData, T newData);

    /**
     * Replaces all {@code oldData} instances with {@code newData}.
     * 
     * @param oldData The data to replace.
     * @param newData The data to set as the replacement.
     * @return The number of replacements made.
     */
    public int replaceAll(T oldData, T newData);

    /**
     * Generates a sublist from the specified {@code start} and {@code end} 
     * indicies.
     *  
     * @param start The start index. 
     * @param end The end index.
     * @return A {@code List<T>} sublist.
     * @throws IndexOutOfBoundsException If the start or end are outside the 
     * size of the list.
     */
    public List<T> subList(int start, int end);

    /**
     * Converts {@code this} to an array of type {@code T[]}.
     * 
     * @return An array of type {@code T[]}.
     */
    public T[] toArray();

    /**
     * Returns an iterator for the list.
     * 
     * @return An {@code Iterator<T>} for the list.
     */
    public Iterator<T> iterator();
}
