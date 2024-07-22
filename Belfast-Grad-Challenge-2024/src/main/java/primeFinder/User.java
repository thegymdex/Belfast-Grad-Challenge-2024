package main.java.primeFinder;

public class User {
    private String username;
    private String numericValue;

    public User(String username, String numericValue) {

        this.username = username;
        this.numericValue = numericValue;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumericValue() {
        return numericValue;
    }

    public void setNumericValue(String numericValue) {
        this.numericValue = numericValue;
    }
}
