package co.uk.fractalwrench.dsaa.structures;

import org.junit.Test;

import static co.uk.fractalwrench.dsaa.structures.ArrayList.DEFAULT_CAPACITY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ArrayListTest {

    private static final String TEST_OBJ_1 = "test";
    private static final String TEST_OBJ_2 = "SECOND";

    @Test
    public void testDelete() {
        ArrayList<String> list = new ArrayList<>();
        list.add(TEST_OBJ_1);
        list.add(TEST_OBJ_2);
        list.add(TEST_OBJ_1);

        assertEquals(TEST_OBJ_1, list.delete(TEST_OBJ_1));
        assertEquals(2, list.size());
        assertEquals(1, list.indexOf(TEST_OBJ_1));
        assertEquals(TEST_OBJ_1, list.delete(TEST_OBJ_1));
        assertNull(list.delete(TEST_OBJ_1));
    }

    @Test
    public void testClear() {
        ArrayList<String> list = new ArrayList<>();
        list.add(TEST_OBJ_1);
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertEquals(-1, list.indexOf(TEST_OBJ_1));
    }

    @Test
    public void testIsEmpty() {
        ArrayList<String> list = new ArrayList<>();
        assertTrue(list.isEmpty());

        list.add(TEST_OBJ_1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());

        list.add(null);
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
    }

    @Test
    public void testIndexOf() {
        ArrayList<String> list = new ArrayList<>();
        assertEquals(-1, list.indexOf(TEST_OBJ_1));

        list.add(TEST_OBJ_1);
        list.add(TEST_OBJ_1);
        assertEquals(0, list.indexOf(TEST_OBJ_1));

        list.add(TEST_OBJ_2);
        assertEquals(2, list.indexOf(TEST_OBJ_2));
    }

    @Test
    public void testGetCapacity() {
        ArrayList<String> list = new ArrayList<>();
        assertEquals(DEFAULT_CAPACITY, list.getCapacity());

        for (int k = 0; k < DEFAULT_CAPACITY; k++) {
            list.add("");
        }
        assertEquals(DEFAULT_CAPACITY, list.getCapacity());

        list.add("");
        assertEquals(DEFAULT_CAPACITY * 2, list.getCapacity());

        for (int k = 1; k < DEFAULT_CAPACITY; k++) {
            list.add("");
        }
        assertEquals(DEFAULT_CAPACITY * 2, list.getCapacity());

        list.add("");
        assertEquals(DEFAULT_CAPACITY * 4, list.getCapacity());
    }
}
