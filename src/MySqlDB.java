/***
 * This class handles the DB queries
 *
 * @author Peter Mica
 */

import java.sql.*;

//Query methods
public class MySqlDB {
    Connection db;

    //This function must be called before any use of queries to establish connection to the DB
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

    //Return user's appointments from db
    public dbAppointment getAppointment(User myUser) {

        dbAppointment myAppt = null;

        //Query to grab all appointments from the appointments table where the student matches the current user
        String query = String.format("SELECT APPOINTMENT_NUMBER FROM APPOINTMENTS WHERE Student = `%s`", myUser.userID);

        try {
            Statement stmt = db.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            //Query Statement
            ResultSet rs = stmt.executeQuery(query);

            //Desired information
            while (rs.next()) {
                String appointmentNumber = rs.getString("APPOINTMENT_NUMBER");
                Integer date = rs.getInt("Date");
                Integer time = rs.getInt("Time");
                String location = rs.getString("Location");
                String subject = rs.getString("Subject");
                String tutor = rs.getString("Tutor");
                String student = rs.getString("Student");

                myAppt = new dbAppointment(appointmentNumber,date,time,location,subject,tutor,student);
            }
        }catch (SQLException e) { //Exception in case of no connection
            System.err.println(e);
        }

        //Returns the appointment object
        return myAppt;
    }

    //Returns the user information of the user credentials given
    public User getLogin(String argPassword, String argUsername) {

        User myUser = null;

        String query = String.format("SELECT Password FROM USERS WHERE USER_ID = `%s` AND Password = `%s`", argUsername, argPassword);

        try {
            Statement stmt = db.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            //Query Statement
            ResultSet rs = stmt.executeQuery(query);

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

        String jdbcURL = "jdbc:mysql://localhost:3306/411DB";
        String username = "plm5256";
        String password = "pass";

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            Statement stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            //Query Statement
            ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENTS");

            //Desired information
            while (rs.next()) {
                String s = rs.getString("STUDENT_ID");
                String s1 = rs.getString("Name");
                System.out.println(s + s1);
            }
        } catch (SQLException e) {
            System.err.println(e);

        }
    }
}
