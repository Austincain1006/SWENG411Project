package controller;

import Model.*;
import Model.Exceptions.InvalidLoginException;
import Model.Exceptions.MissingFieldException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.ExceptionStage;
import view.GUI;
import view.LogInScene;
import DB.MySqlDB;
import DB.User;

import java.util.Objects;

/**
 * HandleLogInEvent.java
 * Event Handler for Logging In
 */
public class HandleLogInEvent implements EventHandler<ActionEvent> {
    private LogInScene loginscene;
    private Account account;
    @Override
    public void handle(ActionEvent event) {
        loginscene = GUI.getLogInScene();

        try {
            login();
        } catch (Exception E ) {
            GUI.popupError( E );
        }

    }

    /**
     * Logs user into account
     * @throws Exception
     */
    private void login() throws Exception {
        System.out.println("Starting to login");
        String username = loginscene.getUsernameField().getText();
        String password = loginscene.getPasswordField().getText();

        System.out.println(username);
        System.out.println(password);

        //Make Connection to Database
        MySqlDB db = new MySqlDB();
        db.init();

        if ( username.isEmpty() || password.isEmpty() )
            throw new MissingFieldException();

        //Create temp user object to check login credentials
        User loginUser = db.getLogin( password, username);

        if (loginUser == null) {
            System.out.println("null message");
        }
        //Check if the getLogin returned a userId to tempUser
        if ( loginUser!=null && loginUser.getUserID() != null ) {

            //Check if the account is a Student one
            if (Objects.equals(loginUser.getUserType(), "Student")) {
                System.out.println("Found student");
                account = new Student(loginUser.getUserID(),loginUser.getPassword());
                System.out.println(account.getUsername());

                //Check if the account is a Tutor one
            } else if (Objects.equals(loginUser.getUserType(), "Tutor")) {
                account = new Tutor(loginUser.getUserID(),loginUser.getPassword());
            } else {
                account = new Faculty(loginUser.getUserID(),loginUser.getPassword());
            }

            if (account instanceof Student){
                System.out.println( "Attempting student home page...");
                GUI.getStudentHomeScreen().setStudent( (Student)account );

                System.out.println("Get student home screen success");
                GUI.setScene(GUI.getStudentHomeScreen());
            } else if (account instanceof Tutor) {
                GUI.getTutorHomeScreen().setTutor( (Tutor)account );
                GUI.setScene(GUI.getTutorHomeScreen());
            } else if (account instanceof Faculty) {
                GUI.getFacultyHomeScreen().setFaculty( (Faculty)account );
                GUI.setScene(GUI.getFacultyHomeScreen());
            } else {
                System.out.println("What");
            }

        } else
            throw new InvalidLoginException();
    }
}
