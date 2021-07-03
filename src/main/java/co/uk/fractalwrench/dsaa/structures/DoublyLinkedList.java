package co.uk.fractalwrench.dsaa.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A custom implementation of a doubly linked list. The LinkedList data structure is a collection of elements which
 * hold references to their adjacent nodes. In this case the LinkedList is doubly linked as each Node holds the previous
 * and next Node.
 * <p></p>
 * Linked Lists are very useful for processing data in the order in which it was added. They are used commonly in BFS.
 * <p></p>
 * This implementation is for education purposes only and is not production ready - there is
 * no attempt to deal with concurrent modifications for example.
 * <table>
 * <td>
 *     <tr>Indel:  O(1)</tr>
 *     <tr>Search: O(n)</tr>
 *     <tr>Space:  O(n)</tr>
 * </td>
 * </table>
 *
 * @param <T> the type of data held in the elements of this list.
 */
public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    /**
     * Adds an element to the end of the linked list.
     *
     * @param data the data to add.
     */
    public void add(T data) {
        Node<T> newElement = new Node<>(data);
        newElement.prev = tail;

        if (head == null) {
            head = newElement;
        } else {
            tail.next = newElement;
        }
        tail = newElement;
        size++;
    }

    /**
     * Removes an element from the linked list. If it is not present this operation has no effect.
     *
     * @param data the data to add.
     */
    public void remove(T data) {
        if (head == null) {
            return;
        }

        Node<T> node = head;

        while (node != null) {
            // find the first node matching the data and remove it
            if (node.getData().equals(data)) {
                Node<T> left = node.prev;
                Node<T> right = node.next;

                if (left != null) {
                    left.next = right;
                } else {
                    head = right;
                }
                if (right != null) {
                    right.prev = left;
                } else {
                    tail = left;
                }
                size--;
                return;
            }
            node = node.next;
        }
    }

    /**
     * Retrieves and removes the head of the queue. If no elements are in a queue this will return null.
     *
     * @return the head of the queue or null
     */
    public T poll() {
        T data = null;

        if (head != null) {
            data = head.getData();
            remove(data);
        }
        return data;
    }

    /**
     * Gets the first index of the element in the linked list, returning -1 if it is not present.
     *
     * @param data the data to add.
     * @return the index of the element in the list
     */
    public int indexOf(T data) {
        if (head != null) {
            Node<T> node = head;
            int index = 0;

            while (node != null) {
                if (node.getData().equals(data)) {
                    return index;
                }
                node = node.next;
                index++;
            }
        }
        return -1;
    }

    /**
     * @return the number of elements in this collection
     */
    public int size() {
        return size;
    }

    /**
     * @return the elements in the LinkedList as a List.
     */
    public List<T> toList() {
        if (head == null) {
            return Collections.emptyList();
        } else {
            ArrayList<T> list = new ArrayList<>();
            Node<T> node = head;

            while (node != null) {
                list.add(node.data);
                node = node.next;
            }
            return list;
        }
    }

    private static class Node<T> {
        private final T data;
        private Node<T> prev;
        private Node<T> next;

        Node(T data) {
            this.data = data;
        }

        T getData() {
            return data;
        }
    }
}
