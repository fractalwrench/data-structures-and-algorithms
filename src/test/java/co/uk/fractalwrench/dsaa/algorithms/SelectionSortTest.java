package co.uk.fractalwrench.dsaa.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SelectionSortTest {

    @Test
    public void testEmptyArray() {
        int[] elements = {};
        SearchUtils.selectionSort(elements);
        assertArrayEquals(new int[0], elements);
    }

    @Test
    public void testSingleElementArray() {
        int[] elements = {5};
        SearchUtils.selectionSort(elements);
        assertArrayEquals(new int[]{5}, elements);
    }

    @Test
    public void testSort() {
        int[] elements = {-509, 50923, 4234, 100, 0, 20934829, 28, 8, 840, 9, -572934};
        SearchUtils.selectionSort(elements);
        int[] expected = {-572934, -509, 0, 8, 9, 28, 100, 840, 4234, 50923, 20934829};
        assertArrayEquals(expected, elements);
    }
}
