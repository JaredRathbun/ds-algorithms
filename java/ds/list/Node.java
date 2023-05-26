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
        prev = node;
    }

    public Node<T> setNext(Node<T> node) {
        next = node;
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
