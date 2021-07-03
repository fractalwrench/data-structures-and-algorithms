package co.uk.fractalwrench.dsaa.structures;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    @Test
    public void testBasicOperations() {
        DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
        linkedList.add("first");
        linkedList.add("second");
        linkedList.add("third");
        linkedList.add("first");
        assertEquals(4, linkedList.size());
        assertEquals(0, linkedList.indexOf("first"));
        assertEquals(1, linkedList.indexOf("second"));
        assertEquals(2, linkedList.indexOf("third"));

        // poll and check size/tail updated
        assertEquals("first", linkedList.poll());
        assertEquals(3, linkedList.size());
        assertEquals(2, linkedList.indexOf("first"));
        assertEquals(Arrays.asList("second", "third", "first"), linkedList.toList());

        // poll all remaining values
        assertEquals("second", linkedList.poll());
        assertEquals("third", linkedList.poll());
        assertEquals("first", linkedList.poll());
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testSimpleRemoval() {
        DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
        linkedList.add("apple");
        linkedList.remove("apple");
        assertEquals(0, linkedList.size());
        assertEquals(new ArrayList<>(), linkedList.toList());
    }

    @Test
    public void testRemoval() {
        DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
        linkedList.add("apple");
        linkedList.add("banana");
        linkedList.add("orange");
        linkedList.add("grapefruit");
        assertEquals(4, linkedList.size());

        linkedList.remove("banana");
        assertEquals(3, linkedList.size());
        assertEquals(Arrays.asList("apple", "orange", "grapefruit"), linkedList.toList());

        linkedList.remove("grapefruit");
        assertEquals(2, linkedList.size());
        assertEquals(Arrays.asList("apple", "orange"), linkedList.toList());

        linkedList.remove("apple");
        assertEquals(1, linkedList.size());
        assertEquals(Collections.singletonList("orange"), linkedList.toList());

        linkedList.remove("orange");
        assertEquals(0, linkedList.size());
        assertEquals(new ArrayList<>(), linkedList.toList());
    }

    @Test
    public void defaultValues() {
        DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
        assertEquals(0, linkedList.size());
        assertEquals(new ArrayList<>(), linkedList.toList());
        assertNull(linkedList.poll());
        assertEquals(-1, linkedList.indexOf(null));
    }

}
