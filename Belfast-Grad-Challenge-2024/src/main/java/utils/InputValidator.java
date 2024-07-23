package main.java.utils;

public class InputValidator {

    // method to validate a given input against a regex - future proof
    public static boolean validateInput(String input, String validationPattern) {
        if (input == null) {
            return false;
        }
        return input.matches(validationPattern);
    }
}
