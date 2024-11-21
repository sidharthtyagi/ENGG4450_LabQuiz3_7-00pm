package Mathematics;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PrimesTest {

    @Test
    void getPrimeFactorization() {
        Map<Long, Long> factors = Primes.getPrimeFactorization(56);
        assertNotNull(factors, "Prime factorization result should not be null");
        assertEquals(3, factors.size(), "There should be 3 prime factors");
        assertEquals(3, factors.get(2), "2 appears 3 times");
        assertEquals(1, factors.get(7), "7 appears 1 time");
    }

    @Test
    void isPrime() {
        assertTrue(Primes.isPrime(2), "2 is a prime number");
        assertTrue(Primes.isPrime(3), "3 is a prime number");
        assertFalse(Primes.isPrime(4), "4 is not a prime number");
        assertFalse(Primes.isPrime(9), "9 is not a prime number");
    }

    @Test
    void sieveOfEratosthenes() {
        assertTrue(Primes.sieveOfEratosthenes(2), "2 is prime");
        assertTrue(Primes.sieveOfEratosthenes(3), "3 is prime");
        assertFalse(Primes.sieveOfEratosthenes(4), "4 is not prime");
        assertTrue(Primes.sieveOfEratosthenes(29), "29 is prime");
        assertFalse(Primes.sieveOfEratosthenes(100), "100 is not prime");
    }

    @Test
    void millerRabinTest() {
        assertTrue(Primes.millerRabinTest(2), "2 is prime");
        assertTrue(Primes.millerRabinTest(3), "3 is prime");
        assertFalse(Primes.millerRabinTest(4), "4 is not prime");
        assertTrue(Primes.millerRabinTest(97), "97 is prime");
        assertFalse(Primes.millerRabinTest(100), "100 is not prime");
    }
}