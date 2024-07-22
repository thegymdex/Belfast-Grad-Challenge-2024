package primeFinder;

public class User {
    private String username;
    private int numericValue;

    public User(String username, String numericValue) {
        this.username = username;
        this.numericValue = Integer.parseInt(numericValue);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumericValue() {
        return numericValue;
    }

    public void setNumericValue(int numericValue) {
        this.numericValue = numericValue;
    }
}
