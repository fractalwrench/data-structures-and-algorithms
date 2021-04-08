package co.uk.fractalwrench.dsaa.structures;

import co.uk.fractalwrench.dsaa.VisibleForTesting;

/**
 * A custom implementation of an ArrayList. The ArrayList data structure is an ordered collection
 * whose elements are backed by a dynamically sized array which can increase in size after initialization.
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
public class ArrayList<T> {

    public static final int DEFAULT_CAPACITY = 32;
    public static final int GROW_FACTOR = 2;

    private int size;

    // Use Object because type erasure prevents dynamic instantiation of generic arrays
    private Object[] values;

    public ArrayList() {
        this.values = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Adds the given object to the last position in the array
     *
     * @param object the object
     */
    public void add(T object) {
        if (size >= values.length) {
            increaseCapacity();
        }
        values[size] = object;
        size++;
    }

    /**
     * Deletes the given object from the first position it is found in the array
     *
     * @param object the object
     * @return the object, or null if not found
     */
    public T delete(T object) {
        int index = indexOf(object);

        if (index == -1) {
            return null;
        } else {
            // need to suppress to workaround type erasure for Object[]
            @SuppressWarnings("unchecked") T item = (T) values[index];

            // shift every element after N one to the left.
            for (int k = index, len = values.length; k < len - 1; k++) {
                int next = k + 1;
                values[k] = values[next];
            }
            values[size - 1] = null; // remove last item
            size--;
            return item;
        }

        // no attempt is made to shrink the array once it's less than half full
        // to reduce memory usage - this could be attempted at a later date.
    }

    /**
     * Clears the array of all objects
     */
    public void clear() {
        values = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Determines whether the list contains any objects or not
     *
     * @return true if no objects, otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the count of elements added to the list
     *
     * @return the number of objects
     */
    public int size() {
        return size;
    }

    /**
     * Returns the first index of the given object, or -1 if it is not in the list.
     * This is determined by comparative equality.
     *
     * @param object the object
     * @return the object's first index or -1
     */
    public int indexOf(T object) {
        for (int k = 0; k < values.length; k++) {
            Object value = values[k];
            if ((value == null && object == null) || object.equals(value)) {
                return k;
            }
        }
        return -1;
    }

    @VisibleForTesting
    int getCapacity() {
        return values.length;
    }

    /**
     * Copies the old array to a new one twice the size.
     */
    private void increaseCapacity() {
        int oldCapacity = values.length;
        int newCapacity = oldCapacity * GROW_FACTOR;
        Object[] newValues = new Object[newCapacity];
        System.arraycopy(values, 0, newValues, 0, oldCapacity);
        values = newValues;
    }
}
