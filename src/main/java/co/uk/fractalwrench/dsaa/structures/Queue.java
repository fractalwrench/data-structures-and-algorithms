package co.uk.fractalwrench.dsaa.structures;

/**
 * A Java implementation of a Queue data structure, which is an ordered FIFO collection. A Queue
 * is very similar to a LinkedList - the key difference is elements must be polled from the start
 * and added to the end.
 * <p></p>
 * Queues can be very useful when data must be processed in a sequential order,
 * such as responding to messages on an HTTP endpoint. They are also very useful for implementing BFS.
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
 * @param <T> the data type
 */
public class Queue<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    /**
     * Adds the given object to the last position in the queue
     *
     * @param object the given object
     */
    public void enqueue(T object) {
        Node<T> node = new Node<>(object);

        if (first == null) {
            last = node;
            first = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    /**
     * Removes and returns the first object in the queue
     *
     * @return the first object in the queue, or null if none exists
     */
    public T dequeue() {
        if (first != null) {
            size--;
            T data = first.data;
            first = first.next;

            if (first == null) {
                last = null; // avoid memory leak by removing obsolete reference
            }
            return data;
        }
        return null;
    }

    /**
     * Calculates the number of elements currently enqueued
     *
     * @return the number of elements
     */
    public int size() {
        return size;
    }

    /**
     * Determines whether the queue has any elements or not
     *
     * @return true if no elements, otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Holds the data and a pointer to the next {@link Node} in the queue.
     *
     * @param <T> the data type
     */
    private static class Node<T> {

        private final T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

}
