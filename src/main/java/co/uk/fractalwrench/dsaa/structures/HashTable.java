package co.uk.fractalwrench.dsaa.structures;

/**
 * A custom implementation of a HashTable. This data structure maps a key object to a value object
 * by generating a hashcode that acts as an ID.
 * <p></p>
 * Hash tables are good for lookup of specific data, as the typical cost if a key is known is O(1).
 * In the worst case where every object has encountered a hash collision this can degrade to O(n).
 * <p></p>
 * This implementation is for education purposes only and is not production ready - there is
 * no attempt to deal with hash collisions or growing capacity for example.
 * <table>
 * <td>
 *     <tr>Access: O(n)</tr>
 *     <tr>Indel:  O(n)</tr>
 *     <tr>Search: O(n)</tr>
 *     <tr>Space:  O(n)</tr>
 * </td>
 * </table>
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class HashTable<K, V> {

    private static final int DEFAULT_CAPACITY = 128;

    private V[] values;

    public HashTable() {
        clear();
    }

    /**
     * Adds a value to the map with the given key
     *
     * @param key   the key
     * @param value the value
     * @throws IllegalArgumentException if the key is null
     */
    public void put(K key, V value) throws IllegalArgumentException {
        checkForNullKey(key);
        int index = getIndexForKey(key);
        values[index] = value;
    }

    /**
     * Retrieves the value mapped with the given key
     *
     * @param key the key
     * @return the value, or null if not present
     * @throws IllegalArgumentException if the key is null
     */
    public V get(K key) {
        checkForNullKey(key);
        int index = getIndexForKey(key);
        return values[index];
    }

    /**
     * Removes the value mapped with the given key
     *
     * @param key the key
     * @return the removed value
     * @throws IllegalArgumentException if the key is null
     */
    public V remove(K key) {
        checkForNullKey(key);
        int index = getIndexForKey(key);
        V value = values[index];
        values[index] = null;
        return value;
    }

    /**
     * Clears all values from the map
     */
    public void clear() {
        //noinspection unchecked
        values = (V[]) new Object[DEFAULT_CAPACITY];
    }

    private void checkForNullKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Cannot use null key");
        }
    }

    /**
     * Gets the index in the array to store the object, by generating a hash code from the key.
     *
     * @param key the key which will generate the hashcode
     * @return the index in the array store
     */
    private int getIndexForKey(K key) {
        return key.hashCode() % DEFAULT_CAPACITY;
    }
}
