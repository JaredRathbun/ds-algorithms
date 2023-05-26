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

    public void add(T data);

    public void addAll(List<T> list);

    public boolean remove(T data);

    public boolean removeAll(T data);

    public boolean isEmpty();

    public int indexOf(T data);

    public int lastIndexOf(T data);

    public int countOf(T data);

    public void clear();

    public int size();

    public boolean contains();

    public boolean containsAll(List<T> list);

    public T replace(int index, T data);

    public T replace(T oldData, T newData);

    /**
     * Replaces all {@code oldData} instances with {@code newData}.
     * 
     * @param oldData The data to replace.
     * @param newData The data to set as the replacement.
     * @return The number of replacements made.
     */
    public int replaceAll(T oldData, T newData);

    public List<T> subList(int start, int end);

    public T[] toArray();

    public Iterator<T> iterator();
}
