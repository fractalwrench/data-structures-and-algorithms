package co.uk.fractalwrench.dsaa.structures;

/**
 * A custom implementation of a Stack. The Stack data structure is a LIFO meaning the most recent
 * addition can be removed first. This suits it particularly well for storing temporary information that
 * is likely to be removed soon.
 * <p></p>
 * Recursive algorithms can be implemented iteratively using Stacks, which can improve the worst case memory usage.
 * <p></p>
 * This implementation is for education purposes only and is not production ready - there is
 * no attempt to deal with concurrent modifications for example.
 * <table>
 * <td>
 *     <tr>Access: O(1)</tr>
 *     <tr>Indel:  O(1)</tr>
 *     <tr>Search: O(n)</tr>
 *     <tr>Space:  O(n)</tr>
 * </td>
 * </table>
 *
 * @param <T> the type of data held in the elements of this list.
 */
public class Stack<T> {

    private Node<T> top;
    private int size;

    /**
     * Removes the top-most object from the stack and returns it.
     * <p>
     * O(1)
     *
     * @return the popped object
     * @throws IllegalStateException - if no items are in the stack
     */
    public T pop() throws IllegalStateException {
        if (top == null) {
            throw new IllegalStateException("pop() cannot be called on an empty Stack!");
        } else {
            T data = top.data;
            top = top.next;
            size--;
            return data;
        }
    }

    /**
     * Adds the given object to the top of the stack.
     * <p>
     * O(1)
     *
     * @param object the given object
     */
    public void push(T object) {
        top = new Node<>(object, top);
        size++;
    }

    /**
     * Retrieves the top-most object from the stack and returns it.
     * <p>
     * O(1)
     *
     * @return the top-most object
     */
    public T peek() {
        if (top == null) {
            throw new IllegalStateException("peek() cannot be called on an empty Stack!");
        } else {
            return top.data;
        }
    }

    /**
     * Determines whether there are any objects in the stack.
     * <p>
     * O(1)
     *
     * @return true if the stack is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Calculates the number of objects in the stack.
     * <p>
     * O(1)
     *
     * @return the stack's size
     */
    public int size() {
        return size;
    }

    /**
     * Holds the data and a pointer to the {@link Node} below.
     *
     * @param <T> the data type
     */
    private static class Node<T> {

        private final T data;
        private final Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

}
