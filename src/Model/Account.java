package Model;

/**
 * Account.java
 * Abstract class to represent generic accounts. To be used in Inheritance-based polymorphism between tutors, users, and faculty
 * @author Austin Cain
 */
abstract public class Account {
    protected String username;
    protected String password;
    private Integer id;

    public Account() {

    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        System.out.println("Creating account");
        System.out.println(username);
        System.out.println(password);
    }

    // Gets Username of Account
    public String getUsername() {
        return username;
    }

    // Gets Username of Account
    public void setUsername(String username) {
        this.username = username;
    }

    // Gets Username of Account
    public String getPassword() {
        return password;
    }

    // Gets Username of Account
    public void setPassword(String password) {
        this.password = password;
    }

    // Set ID of Account
    public void setID(Integer id) {
        this.id = id;
    }

    // Get ID of Account
    public Integer getID() {
        return id;
    }
}
