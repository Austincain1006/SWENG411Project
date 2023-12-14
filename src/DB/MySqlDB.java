/***
 * This class handles the DB queries
 *
 * @author Peter Mica
 */

package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

//Query methods
public class MySqlDB {
    static Connection db;

    /**
     * This function must be called before any use of queries to establish connection to the DB
     *
     */
    public void init() {
        try {
            //Arguments for DB connection
            String jdbcURL = "jdbc:mysql://localhost:3306/411DB";
            String username = "plm5256";
            String password = "pass";

            db = DriverManager.getConnection(jdbcURL, username, password);

            System.out.println("init db");
        } catch (SQLException e) {  //Exception in case of no connection
            System.err.println(e);
        }
    }

    /**
     * Below two methods are the setters/getters for the appointments table
     *
     */

    //Insert a new User
    public void addAppointment(dbAppointment myNewAppointment) {

        String query = "INSERT INTO APPOINTMENTS (APPOINTMENT_NUMBER,Date,Time,Location,Subject,Tutor,Student)" +
                "VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = db.prepareStatement(query);
            preparedStatement.setInt(1,myNewAppointment.appointmentNumber);
            preparedStatement.setString(2,String.valueOf(myNewAppointment.date));
            preparedStatement.setString(3,String.valueOf(myNewAppointment.time));
            preparedStatement.setString(4,myNewAppointment.location);
            preparedStatement.setString(5,myNewAppointment.subject);
            preparedStatement.setString(6,myNewAppointment.tutor);
            preparedStatement.setString(7,myNewAppointment.student);

            preparedStatement.execute();

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    //Return user's appointments from db
    public ArrayList<dbAppointment> getAppointment(User myUser) {

        ArrayList<dbAppointment> myApptList = new ArrayList<>();


        //Query to grab all appointments from the appointments table where the student matches the current user
        String query = "SELECT * FROM APPOINTMENTS WHERE Student = ? ORDER BY Date ASC";

        try {
            PreparedStatement preparedStatement = db.prepareStatement(query);
            preparedStatement.setString(1,myUser.userID);


            //Query Statement
            preparedStatement.execute();


            ResultSet rs = preparedStatement.getResultSet();

            //Desired information
            while (rs.next()) {
                Integer appointmentNumber = rs.getInt("APPOINTMENT_NUMBER");
                Integer date = rs.getInt("Date");
                Integer time = rs.getInt("Time");
                String location = rs.getString("Location");
                String subject = rs.getString("Subject");
                String tutor = rs.getString("Tutor");
                String student = rs.getString("Student");

                myApptList.add(new dbAppointment(appointmentNumber,date,time,location,subject,tutor,student));
            }
        }catch (SQLException e) { //Exception in case of no connection
            System.err.println(e);
        }

        //Returns the appointment object
        return myApptList;
    }

    /**
     * Below two methods are the setters/getters for the user table
     *
     */

    //Insert a new User
    public void addUser(User myNewUser) {

        //Query to inserts the new user information into the DB
        String query = "INSERT INTO USERS (USER_ID,Password,Email,Name,UserType)" +
                "VALUES (?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = db.prepareStatement(query);
            preparedStatement.setString(1,myNewUser.userID);
            preparedStatement.setString(2,myNewUser.password);
            preparedStatement.setString(3,myNewUser.email);
            preparedStatement.setString(4,myNewUser.name);
            preparedStatement.setString(5,myNewUser.userType);

            preparedStatement.execute();

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    //Returns the user information of the user credentials given
    public User getLogin(String argPassword, String argUsername) {

        //Create temp user object to store retrieved data
        User myUser = null;

        //Query to get user information based on the given user/pass
        String query = "SELECT * FROM USERS WHERE USER_ID = ? AND Password = ?";

        try {

            PreparedStatement preparedStatement = db.prepareStatement(query);
            preparedStatement.setString(1,argUsername);
            preparedStatement.setString(2,argPassword);

            //Query Statement
            preparedStatement.execute();

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.getResultSet();


            //Desired information
            while (rs.next()) {

                String username = rs.getString("USER_ID");
                String password = rs.getString("Password");
                String email = rs.getString("Email");
                String name = rs.getString("Name");
                String userType = rs.getString("UserType");

                if (!Objects.equals(username, argUsername) || !Objects.equals(password, argPassword)) {
                    System.out.println("Bad login");
                    return null;
                }

                myUser = new User(username,password,email,name,userType);
            }

        }catch (SQLException e) {
            System.err.println(e);
        }

        //Returns the user object
        return myUser;
    }

    public void closeConnection() {
        try {
            db.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    //Function to get the list of tutors
    public ArrayList<User> getTutorList() {
        //Creat temp list
        ArrayList<User> tutorList = new ArrayList<>();

        //Query to grab all appointments from the appointments table where the student matches the current user
        String query = "SELECT * FROM USERS WHERE UserType = 'Tutor' ORDER BY Name ASC";

        try {
            PreparedStatement preparedStatement = db.prepareStatement(query);

            //Query Statement
            preparedStatement.execute();


            ResultSet rs = preparedStatement.getResultSet();

            //Desired information
            while (rs.next()) {
                String userID = rs.getString("USER_ID");
                String pass = rs.getString("Date");
                String email = rs.getString("Time");
                String name = rs.getString("Name");
                String userType = rs.getString("UserType");

                tutorList.add(new User(userID,pass,email,name,userType));
            }
        }catch (SQLException e) { //Exception in case of no connection
            System.err.println(e);
        }

        return tutorList;
    }

    //Main method for testing DB queries
    public static void main(String[] args) {

        //Initialize DB
        MySqlDB db = new MySqlDB();
        db.init();

        //Create User
        User peter = new User("plm5256","password","plm5256@psu.edu","Peter Mica","Student");


        User result = db.getLogin(peter.password,peter.userID);

        //Get the appointment list resultset as an arraylist
        ArrayList<dbAppointment> apptList = db.getAppointment(result);

        //Get size of the Appointment list
        int size = apptList.size();

        //Iterate over appointment list
        for (int i =0; i < size; i++) {
            dbAppointment tempAppt = apptList.get(i);
            System.out.println(tempAppt.date);
        }

    }


}
