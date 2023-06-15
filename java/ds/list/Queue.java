package list;

public interface Queue<T> extends Iterable<T> {
    public void addToFront(T data);

    public void addToEnd(T data);

    public T pop();

    public T peek();

    public boolean remove(T data);

    public boolean removeAll(List<T> list);

    // public boolean contains(T data);

    // public boolean containsAll(List<T> list);
}
