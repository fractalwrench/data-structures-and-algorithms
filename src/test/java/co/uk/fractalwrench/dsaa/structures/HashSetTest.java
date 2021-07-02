package co.uk.fractalwrench.dsaa.structures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HashSetTest {

    @Test
    public void testSet() {
        HashSet<String> set = new HashSet<>();
        assertEquals(0, set.size());

        set.add("apple");
        set.add("banana");
        set.add("banana");
        assertEquals(2, set.size());
        assertTrue(set.contains("banana"));

        set.remove("apple");
        assertEquals(1, set.size());
        assertFalse(set.contains("apple"));
    }
}