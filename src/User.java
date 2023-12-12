/**
 * This class stores the resultset from the DB
* @author Peter Mica
 * */
public class User {
    String userID, password, email, name, userType;

    public User(String username, String pass, String email, String Name, String userType) {
        userID = username;
        password = pass;
        this.name = Name;
        this.email = email;
        this.userType = userType;
    }
}