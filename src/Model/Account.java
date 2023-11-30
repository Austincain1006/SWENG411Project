package Model;

abstract public class Account {
    private String username;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
