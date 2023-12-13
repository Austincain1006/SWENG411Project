/***
 * This class handles the DB queries
 *
 * @author Peter Mica
 */

import java.sql.*;
import java.util.ArrayList;

//Query methods
public class MySqlDB {
    Connection db;

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

            ResultSet rs = preparedStatement.getResultSet();

            //Desired information
            while (rs.next()) {
                String username = rs.getString("USER_ID");
                String password = rs.getString("Password");
                String email = rs.getString("Email");
                String name = rs.getString("Name");
                String userType = rs.getString("UserType");

                myUser = new User(username,password,email,name,userType);
            }

        }catch (SQLException e) {
            System.err.println(e);
        }

        //Returns the user object
        return myUser;
    }

    //Main method for testing DB queries
    public static void main(String[] args) {

        //Initialize DB
        MySqlDB db = new MySqlDB();
        db.init();

        //Create User
        User peter = new User("plm5256","password","plm5256@psu.edu","Peter Mica","Student");

        db.getAppointment(peter);

        ArrayList<dbAppointment> apptList = db.getAppointment(peter);

        //Get size of apptList
        int size = apptList.size();

        //Iterate over arraylist of appts
        for (int i = 0; i < size; i++) {
            //Print the subject of each appointment
            System.out.println("Subject:" + apptList.get(i).date);
        }

    }
}
