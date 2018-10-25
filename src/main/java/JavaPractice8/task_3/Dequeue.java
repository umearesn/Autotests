package task_3;

public interface Dequeue<E> {
    boolean add(E e, boolean first);
    E poll(boolean first);
}
