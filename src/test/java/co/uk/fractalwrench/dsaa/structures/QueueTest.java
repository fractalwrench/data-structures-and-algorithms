package co.uk.fractalwrench.dsaa.structures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests the {@link Queue} data structure using {@link String}
 */
public class QueueTest {

    @Test
    public void testIsEmpty() {
        Queue<String> queue = new Queue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue("test");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testSize() {
        Queue<String> queue = new Queue<>();
        assertEquals(0, queue.size());

        queue.dequeue();
        assertEquals(0, queue.size());

        queue.enqueue("test");
        queue.enqueue("test2");
        assertEquals(2, queue.size());

        queue.dequeue();
        assertEquals(1, queue.size());
    }

    @Test
    public void testEnqueueAndDequeue() {
        Queue<String> queue = new Queue<>();
        String firstObj = "first";
        String secondObj = "second";
        String thirdObj = "third";

        queue.enqueue(firstObj);
        queue.enqueue(secondObj);
        assertEquals(firstObj, queue.dequeue());

        queue.enqueue(thirdObj);
        assertEquals(secondObj, queue.dequeue());
        assertEquals(thirdObj, queue.dequeue());
    }

    @Test
    public void testEmptyDequeue() {
        Queue<String> queue = new Queue<>();
        assertNull(queue.dequeue());
    }

    /**
     * Tests the stack using a large number of objects
     */
    @Test
    public void testLargeElementUse() {
        Queue<Integer> integerQueue = new Queue<>();

        for (int k = 0; k < 10000; k++) {
            integerQueue.enqueue(k);
            assertEquals(k + 1, integerQueue.size());
        }

        assertEquals(0, (int) integerQueue.dequeue());
    }

}
