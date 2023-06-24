public interface StackInterface<E> {
    int getSize();
    E peek();
    E pop();
    void push(E element);
    boolean isEmpty();
}
