/**
 * This class stores the resultset from the DB
* @author Peter Mica
 * */

package DB;
public class User {
    String userID, password, email, name, userType;

    //Empty Constructor
    public User(){

    }

    //Default Constructor
    public User(String username, String pass, String email, String Name, String userType) {
        userID = username;
        password = pass;
        this.name = Name;
        this.email = email;
        this.userType = userType;
    }

    //Add username
    public void addUserID(String username) {
        userID = username;
        email = username + "@psu.edu";  //Default assumption if given only user and no email
    }

    //Add password
    public void addPassword(String password) {
        this.password = password;
    }

    //Add name
    public void addName(String name) {
        this.name = name;
    }

    //Add email
    public void addEmail(String email) {
        this.email = email;
    }

    //Add user type
    public void addUserType(String userType) {
        this.userType = userType;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }
}