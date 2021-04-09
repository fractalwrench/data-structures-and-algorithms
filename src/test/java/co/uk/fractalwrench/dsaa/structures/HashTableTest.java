package co.uk.fractalwrench.dsaa.structures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HashTableTest {

    private static final String TEST_KEY = "key";
    private static final String TEST_VAL = "val";

    @Test(expected = IllegalArgumentException.class)
    public void testNullPut() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put(null, TEST_VAL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullGet() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.get(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullRemove() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.remove(null);
    }

    @Test
    public void testPutGetRemove() {
        HashTable<String, String> hashTable = new HashTable<>();
        assertNull(hashTable.get(TEST_KEY));
        assertNull(hashTable.remove(TEST_KEY));

        hashTable.put(TEST_KEY, TEST_VAL);
        assertEquals(TEST_VAL, hashTable.get(TEST_KEY));
        assertEquals(TEST_VAL, hashTable.remove(TEST_KEY));
    }

    @Test
    public void testClear() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put(TEST_KEY, TEST_VAL);
        assertEquals(TEST_VAL, hashTable.get(TEST_KEY));

        hashTable.clear();
        assertNull(hashTable.get(TEST_KEY));
    }

}
