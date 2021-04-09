package co.uk.fractalwrench.dsaa.structures;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests the {@link Stack} data structure using {@link String}
 */
@RunWith(JUnit4.class)
public class StackTest {

    /**
     * Ensures that the number of elements on the stack is calculated correctly
     */
    @Test
    public void testPopPeekPushSize() {
        Stack<String> stack = new Stack<>();
        assertEquals(0, stack.size());

        String firstObj = "First";
        String secondObj = "Second";
        stack.push(firstObj);
        stack.push(secondObj);
        assertEquals(2, stack.size());

        assertEquals(secondObj, stack.peek());
        assertEquals(2, stack.size());

        assertEquals(secondObj, stack.pop());
        assertEquals(1, stack.size());

        assertEquals(firstObj, stack.peek());
        assertEquals(1, stack.size());

        assertEquals(firstObj, stack.pop());
        assertEquals(0, stack.size());
    }

    /**
     * Ensures that popping an empty stack throws an exception
     */
    @Test(expected = IllegalStateException.class)
    public void testEmptyPop() {
        Stack<String> stack = new Stack<>();
        stack.pop();
    }

    /**
     * Ensures that peeking an empty stack throws an exception
     */
    @Test(expected = IllegalStateException.class)
    public void testEmptyPeek() {
        Stack<String> stack = new Stack<>();
        stack.peek();
    }

    /**
     * Ensures that the stack returns true if it has no objects
     */
    @Test
    public void testIsEmpty() {
        Stack<String> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        stack.push("");
        assertFalse(stack.isEmpty());
    }

    /**
     * Tests the stack using a large number of objects
     */
    @Test
    public void testLargeElementUse() {
        Stack<Integer> integerStack = new Stack<>();

        int elementCount = 10000;
        for (int k = 0; k < elementCount; k++) {
            integerStack.push(k);
            assertEquals(k + 1, integerStack.size());
        }

        assertEquals(elementCount - 1, (int) integerStack.peek());
        assertEquals(elementCount - 1, (int) integerStack.pop());
    }

}