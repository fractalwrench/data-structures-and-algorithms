package co.uk.fractalwrench.dsaa.algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EratosthenesSieveTest {

    @Test(expected = IllegalArgumentException.class)
    public void zeroLimit() {
        EratosthenesSieve.findPrimes(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeLimit() {
        EratosthenesSieve.findPrimes(-1);
    }

    @Test
    public void emptyPrimes() {
        assertEquals(Collections.singletonList(2), EratosthenesSieve.findPrimes(2));
    }

    @Test
    public void findPrimes() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71);
        assertEquals(expected, EratosthenesSieve.findPrimes(71));
    }
}
