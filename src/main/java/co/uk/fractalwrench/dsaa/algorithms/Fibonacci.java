package co.uk.fractalwrench.dsaa.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    /**
     * Calculates the Fibonacci sequence to the given limit.
     * <p></p>
     * The Fibonacci sequence is formed of the sum of the two preceding elements in the sequence.
     *
     * @param limit a positive integer
     * @return the fibonacci sequence to the given limit
     */
    public static List<Integer> findSequenceToLimit(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Expected positive integer for limit.");
        }

        List<Integer> sequence = new ArrayList<>();
        int a = 0;
        int b = 1;
        int c = 0;

        while (c <= limit) {
            sequence.add(c);
            a = b;
            b = c;
            c = a + b;
        }
        return sequence;
    }
}
