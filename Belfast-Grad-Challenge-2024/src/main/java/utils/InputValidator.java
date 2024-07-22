package main.java.utils;

public class InputValidator {

    // method to validate a given input against a regex - future proof
    public static boolean validateInput(String input, String validationPattern) {
        return input.matches(validationPattern);
    }
}
