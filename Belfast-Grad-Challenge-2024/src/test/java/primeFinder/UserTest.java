package test.java.primeFinder;

import main.java.primeFinder.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;

    @Before
    public void setUp() {
        user = new User("testUser", "12345");
    }

    @Test
    public void testGetUsername() {
        assertEquals("testUser", user.getUsername());
    }

    @Test
    public void testSetUsername() {
        user.setUsername("newUser");
        assertEquals("newUser", user.getUsername());
    }

    @Test
    public void testGetNumericValue() {
        assertEquals("12345", user.getNumericValue());
    }

    @Test
    public void testSetNumericValue() {
        user.setNumericValue("67890");
        assertEquals("67890", user.getNumericValue());
    }
}
