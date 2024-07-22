package utils;

public class InputValidator {

    // using regex to allow for future validations to take place
    public static boolean validateInput(String input, String validationPattern) {

        return input.matches(validationPattern);
    }
}
