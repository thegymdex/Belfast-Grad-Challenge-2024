package test.java.utils;

import main.java.utils.InputValidator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputValidatorTest {

    @Test
    public void testRejectSpaces() {
        String input = "123 456";
        String validationPattern = "\\d+";
        assertFalse(InputValidator.validateInput(input, validationPattern));
    }

    @Test
    public void testRejectLetters() {
        String input = "123a456";
        String validationPattern = "\\d+";
        assertFalse(InputValidator.validateInput(input, validationPattern));
    }

    @Test
    public void testAcceptValidNumbers() {
        String input = "123456";
        String validationPattern = "\\d+";
        assertTrue(InputValidator.validateInput(input, validationPattern));
    }

    @Test
    public void testRejectEmptyString() {
        String input = "";
        String validationPattern = "\\d+";
        assertFalse(InputValidator.validateInput(input, validationPattern));
    }

    @Test
    public void testRejectNullInput() {
        String input = null;
        String validationPattern = "\\d+";
        assertFalse(InputValidator.validateInput(input, validationPattern));
    }
}
