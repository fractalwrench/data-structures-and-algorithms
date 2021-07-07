package co.uk.fractalwrench.dsaa.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RadixSortTest {

    @Test
    public void testEmptyArray() {
        int[] elements = {};
        SearchUtils.radixSort(elements);
        assertArrayEquals(new int[0], elements);
    }

    @Test
    public void testSingleElementArray() {
        int[] elements = {5};
        SearchUtils.radixSort(elements);
        assertArrayEquals(new int[]{5}, elements);
    }

    @Test
    public void testSort() {
        int[] elements = {50923, 4234, 100, 20934829, 28, 8, 840, 9};
        SearchUtils.radixSort(elements);
        int[] expected = {8, 9, 28, 100, 840, 4234, 50923, 20934829};
        assertArrayEquals(expected, elements);
    }
}
