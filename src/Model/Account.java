package Model;

abstract public class Account {
    private String username;
    private String password;

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    private Integer id;


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
}
