package co.uk.fractalwrench.dsaa.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchUtilsTest {

    @Test
    public void testEmptyArray() {
        assertEquals(-1, SearchUtils.binarySearch(new int[]{}, -1));
    }

    @Test
    public void testBasicEvenArray() {
        assertEquals(2, SearchUtils.binarySearch(new int[]{1, 3, 5, 7, 9, 11}, 5));
    }

    @Test
    public void testBasicOddArray() {
        assertEquals(2, SearchUtils.binarySearch(new int[]{1, 3, 5, 7, 9}, 5));
    }

    @Test
    public void testNegativeArray() {
        assertEquals(1, SearchUtils.binarySearch(new int[]{-103, -85, -8, 2, 5, 100, 509}, -85));
    }

    @Test
    public void testZerothIndex() {
        assertEquals(0, SearchUtils.binarySearch(new int[]{-103, -85, -8, 2, 5, 100, 509}, -103));
    }

    @Test
    public void testLastIndex() {
        assertEquals(6, SearchUtils.binarySearch(new int[]{-103, -85, -8, 2, 5, 100, 509}, 509));
    }
}
