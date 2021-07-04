package co.uk.fractalwrench.dsaa.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class SelectionSortTest {

    private enum SearchMethod {
        SELECTION_SORT,
        BUBBLE_SORT
    }

    @Parameterized.Parameters(name = "{0}")
    public static Iterable<SearchMethod> getSearchMethods() {
        return Arrays.asList(SearchMethod.values());
    }

    @Parameterized.Parameter
    public SearchMethod searchMethod;

    @Test
    public void testEmptyArray() {
        int[] elements = {};
        sortArray(elements);
        assertArrayEquals(new int[0], elements);
    }

    @Test
    public void testSingleElementArray() {
        int[] elements = {5};
        sortArray(elements);
        assertArrayEquals(new int[]{5}, elements);
    }

    @Test
    public void testSort() {
        int[] elements = {-509, 50923, 4234, 100, 0, 20934829, 28, 8, 840, 9, -572934};
        sortArray(elements);
        int[] expected = {-572934, -509, 0, 8, 9, 28, 100, 840, 4234, 50923, 20934829};
        assertArrayEquals(expected, elements);
    }

    private void sortArray(int[] array) {
        switch (searchMethod) {
            case SELECTION_SORT:
                SearchUtils.selectionSort(array);
                break;
            case BUBBLE_SORT:
                SearchUtils.bubbleSort(array);
                break;
            default:
                throw new IllegalStateException("Unexpected search method: " + searchMethod);
        }
    }
}
