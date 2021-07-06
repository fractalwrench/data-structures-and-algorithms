package co.uk.fractalwrench.dsaa.algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test(expected = IllegalArgumentException.class)
    public void negativeLimit() {
        Fibonacci.findSequenceToLimit(-1);
    }

    @Test
    public void zeroLimit() {
        assertEquals(Collections.singletonList(0), Fibonacci.findSequenceToLimit(0));
    }

    @Test
    public void findInitialSequence() {
        assertEquals(Arrays.asList(0, 1, 1), Fibonacci.findSequenceToLimit(1));
    }

    @Test
    public void smallSequence() {
        assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34), Fibonacci.findSequenceToLimit(34));
    }

    @Test
    public void findSequence() {
        assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144), Fibonacci.findSequenceToLimit(150));
    }
}