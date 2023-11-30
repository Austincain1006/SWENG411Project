package controller;

import Model.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * HandleLogInEvent.java
 * Event Handler for Logging In
 */
public class HandleLogInEvent implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        System.out.println( "Log in button pressed!" );


    }
}
