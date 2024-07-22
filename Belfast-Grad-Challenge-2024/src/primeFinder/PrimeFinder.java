package primeFinder;

import java.util.TreeSet;

public class PrimeFinder {

    private TreeSet<Integer> primesList;
    private String numericValue;


    public PrimeFinder(TreeSet<Integer> primesList, String numericValue) {

        this.primesList = primesList;
        this.numericValue = numericValue;
    }

    // method to find all primes in given set
    public TreeSet<Integer> findPrimes() {

        for (int i = 0; i < numericValue.length(); i++) {
            for (int j = i + 1; j <= numericValue.length(); j++) {
                int numberToCheck = Integer.parseInt(numericValue.substring(i, j));

                if ((primesList.contains(numberToCheck) || isPrime(numberToCheck))) {
                    primesList.add(numberToCheck);
                }
            }
        }
        return this.primesList;
    }

    // method to test whether a number is prime
    private boolean isPrime (int number) {

        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
