package co.uk.fractalwrench.dsaa.algorithms;

import java.util.ArrayList;
import java.util.List;

public class EratosthenesSieve {

    /**
     * Finds primes up to the given limit by using a sieve of Eratosthenes.
     * The multiples of each known prime are marked as not prime as they are encountered.
     *
     * @param limit a positive integer greater than 1.
     * @return the primes up to the given limit.
     */
    public static List<Integer> findPrimes(int limit) {
        if (limit < 2) {
            throw new IllegalArgumentException("Limit must be a positive integer, received " + limit);
        }
        List<Integer> primes = new ArrayList<>();

        // 1. create a sieve and set each value to true
        boolean[] primeNumber = new boolean[limit + 1];

        for (int k = 0; k < primeNumber.length; k++) {
            primeNumber[k] = true;
        }

        // 2. sieve all candidates
        for (int k = 2; k <= limit; k++) {
            if (primeNumber[k]) {
                primes.add(k);

                // 3. remove all multiples of the prime number

                for (int j=k; (j * k) < limit; j++) {
                    primeNumber[j * k] = false;
                }
            }
        }
        return primes;
    }
}
