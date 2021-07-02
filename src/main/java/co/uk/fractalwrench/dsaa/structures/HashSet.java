package co.uk.fractalwrench.dsaa.structures;

import java.util.HashMap;
import java.util.Map;

/**
 * A custom implementation of a HashSet. This data structure contains a collection of unordered objects which
 * are all distinct from each other. This implementation is backed by an associative array.
 * <p></p>
 * This implementation is for education purposes only and is not production ready - there is
 * no attempt to deal with hash collisions or growing capacity for example.
 * <table>
 * <td>
 *     <tr>Access: O(1)</tr>
 *     <tr>Indel:  O(n)</tr>
 *     <tr>Search: O(1)</tr>
 *     <tr>Space:  O(n)</tr>
 * </td>
 * </table>
 *
 * @param <T> the data type
 */
public class HashSet<T> {

    private static final Object VALUE_PRESENT = new Object();
    private final Map<T, Object> store = new HashMap<>();

    /**
     * Adds the given element to the set. This has no effect if it is already present.
     *
     * @param element the element.
     */
    public void add(T element) {
        store.put(element, VALUE_PRESENT);
    }

    /**
     * Removes the given element from the set if it is already present.
     *
     * @param element the element.
     */
    public void remove(T element) {
        store.remove(element);
    }

    /**
     * Returns true whether the given element is contained within the set.
     *
     * @param element the element.
     */
    public boolean contains(T element) {
        return store.containsKey(element);
    }

    /**
     * @return the current size of the set.
     */
    public int size() {
        return store.size();
    }
}
