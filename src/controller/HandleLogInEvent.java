package controller;

import Model.Account;
import Model.Database;
import Model.Exceptions.InvalidLoginException;
import Model.Exceptions.MissingFieldException;
import Model.Student;
import Model.Tutor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.ExceptionStage;
import view.GUI;
import view.LogInScene;

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
            System.out.println("E: " + E);
            GUI.popupError( E );
        }

    }

    private void login() throws Exception {
        String username = loginscene.getUsernameField().getText();
        String password = loginscene.getPasswordField().getText();

        if ( username.isEmpty() || password.isEmpty() )
            throw new MissingFieldException();

        if ( Database.correctLogin( username, password) ) {
            account = Database.searchUsername( username );

            if (account instanceof Student){
                GUI.getStudentHomeScreen().setStudent( (Student)account );
                GUI.setScene(GUI.getStudentHomeScreen());
            }
            if (account instanceof Tutor) {
                GUI.getViewAccountScene().setAccount( account );
                GUI.setScene(GUI.getViewAccountScene());
            }
            else {
                System.out.println("What");
            }

        }
        else
            throw new InvalidLoginException();
    }
}
