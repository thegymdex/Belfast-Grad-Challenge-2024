package primeFinder;

import utils.FileCacheUtils;
import utils.InputValidator;

import java.util.TreeSet;

public class PrimeFinderMainApplication {
    public static void main(String[] args) {

        // define treeset to store all primes in ascending order
        TreeSet<Integer> primesList = new TreeSet<>();

        // load previous file data in
        if (!FileCacheUtils.loadFileData(primesList)) {
            System.out.println("Unable to load file data into cache! More details in logs.");
            return;
        }

        // define username and numeric value
        String username = "testUser1234";
        String numericValue = "12345";

        // define validation pattern
        String validationPattern = "\\s|[a-zA-Z]";

        // validate numeric value
        if (!InputValidator.validateInput(numericValue, validationPattern)) {
            System.out.println("Validation Failed! Numeric Value did not meet requirements");
            return;
        }

        // create user object
        User user = new User(username, numericValue);

        // call prime finder class with username.value
        PrimeFinder primeFinder = new PrimeFinder(primesList, user.getNumericValue());

        // output contents of cache
        System.out.println(FileCacheUtils.formatOutput(primesList));

        // write cache to file
        if (!FileCacheUtils.writeFileData(primesList)) {
            System.out.println("Unable to write file data into cache! More details in logs.");
        }
    }
}
