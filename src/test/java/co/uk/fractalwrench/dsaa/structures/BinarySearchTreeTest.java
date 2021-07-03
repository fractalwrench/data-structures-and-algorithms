package co.uk.fractalwrench.dsaa.structures;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void testDefaults() {
        BinarySearchTree tree = new BinarySearchTree();
        assertEquals(Collections.emptyList(), tree.createSortedList());
    }

    @Test(expected = IllegalStateException.class)
    public void testEmptyMinValue() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.getMinimum();
    }

    @Test(expected = IllegalStateException.class)
    public void testEmptyMaxValue() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.getMaximum();
    }

    @Test
    public void addNodes() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(1209);
        tree.add(-409234);
        tree.add(5091);
        tree.add(42349);
        tree.add(10);
        tree.add(-1);
        tree.add(-23409);
        tree.add(-55);
        assertEquals(-409234, tree.getMinimum());
        assertEquals(42349, tree.getMaximum());
        assertEquals(Arrays.asList(-409234, -23409, -55, -1, 10, 1209, 5091, 42349), tree.createSortedList());
    }

    @Test(expected = IllegalStateException.class)
    public void addDuplicate() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(1);
        tree.add(1);
        assertEquals(Collections.singletonList(1), tree.createSortedList());
    }
}
