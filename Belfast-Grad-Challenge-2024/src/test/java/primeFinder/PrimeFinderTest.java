package test.java.primeFinder;

import main.java.primeFinder.PrimeFinder;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.*;

public class PrimeFinderTest {

    private PrimeFinder primeFinder;

    @Before
    public void setUp() {
        TreeSet<Integer> primesList = new TreeSet<>();
        String numericValue = "235711";
        primeFinder = new PrimeFinder(primesList, numericValue);
    }

    @Test
    public void testFindPrimes() {
        TreeSet<Integer> expectedPrimes = new TreeSet<>();
        expectedPrimes.add(2);
        expectedPrimes.add(3);
        expectedPrimes.add(5);
        expectedPrimes.add(7);
        expectedPrimes.add(11);
        expectedPrimes.add(23);
        expectedPrimes.add(71);
        expectedPrimes.add(571);
        expectedPrimes.add(2357);
        expectedPrimes.add(3571);
        expectedPrimes.add(5711);
        TreeSet<Integer> foundPrimes = primeFinder.findPrimes();
        assertEquals(expectedPrimes, foundPrimes);
    }

    @Test
    public void testEmptyNumericValue() {
        PrimeFinder emptyNumericPrimeFinder = new PrimeFinder(new TreeSet<>(), "");
        TreeSet<Integer> foundPrimes = emptyNumericPrimeFinder.findPrimes();
        assertTrue(foundPrimes.isEmpty());
    }

    @Test
    public void testSingleDigitNumericValue() {
        PrimeFinder singleDigitPrimeFinder = new PrimeFinder(new TreeSet<>(), "7");
        TreeSet<Integer> expectedPrimes = new TreeSet<>();
        expectedPrimes.add(7);

        TreeSet<Integer> foundPrimes = singleDigitPrimeFinder.findPrimes();
        assertEquals(expectedPrimes, foundPrimes);
    }

    @Test
    public void testMultipleDigitsNonPrimeNumericValue() {
        PrimeFinder nonPrimeNumericPrimeFinder = new PrimeFinder(new TreeSet<>(), "46");
        TreeSet<Integer> expectedPrimes = new TreeSet<>();
        // 46 does not contain any prime numbers as substrings

        TreeSet<Integer> foundPrimes = nonPrimeNumericPrimeFinder.findPrimes();
        assertTrue(foundPrimes.isEmpty());
    }
}
