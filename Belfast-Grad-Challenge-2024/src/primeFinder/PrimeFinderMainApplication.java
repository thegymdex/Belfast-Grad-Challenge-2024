package primeFinder;

import utils.FileCacheUtils;
import utils.InputValidator;

import java.util.TreeSet;

public class PrimeFinderMainApplication {
    public static void main(String[] args) {

        // define tree set to store all primes in ascending order
        TreeSet<Integer> primesList = new TreeSet<>();

        // load previous file data in
        if (!FileCacheUtils.loadFileData(primesList)) {
            System.out.println("ERROR - Unable to load file data into cache! \nMore details can be found in logs.");
            return;
        }

        // define username and numeric value
        String username = "testUser1234";
        String numericValue = "12345";

        // define validation pattern - currently only digits
        String validationPattern = "\\d+";

        // validate numeric value
        if (!InputValidator.validateInput(numericValue, validationPattern)) {
            System.out.println("ERROR - Validation Failed! Numeric Value did not meet requirements! \nMore details can be found in logs.");
            return;
        }

        // create user object
        User user = new User(username, numericValue);

        // create primeFinder object
        PrimeFinder primeFinder = new PrimeFinder(primesList, user.getNumericValue());

        // call prime finder method
        primeFinder.findPrimes();

        // output contents of cache
        System.out.println(FileCacheUtils.formatOutput(primesList));

        // write cache to file
        if (!FileCacheUtils.writeFileData(primesList)) {
            System.out.println("ERROR - Unable to write file data into cache! \nMore details can be found in logs.");
        }
    }
}
