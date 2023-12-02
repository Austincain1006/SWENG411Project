package controller;

import Model.Database;
import Model.Exceptions.InvalidLoginException;
import Model.Exceptions.MissingFieldException;
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
    @Override
    public void handle(ActionEvent event) {
        System.out.println( "Log in button pressed!" );
        loginscene = GUI.getLogInScene();

        try {
            login();
        } catch (Exception E ) {
            GUI.popupError( E );
        }



    }

    private void login() throws Exception {
        String username = loginscene.getUsernameField().getText();
        String password = loginscene.getPasswordField().getText();

        if ( username.isEmpty() || password.isEmpty() )
            throw new MissingFieldException();

        if ( GUI.getDB().correctLogin( username, password) == true )
            GUI.setScene( GUI.getViewAccountScene() );
        else
            throw new InvalidLoginException();



    }
}
