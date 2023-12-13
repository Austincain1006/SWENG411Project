package controller;

import Model.*;
import Model.Exceptions.InvalidLoginException;
import Model.Exceptions.MissingFieldException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.FacultyHomeScreen;
import view.GUI;
import view.LogInScene;

/**
 * RemoveTutorEvent.java
 * Removes a specified tutor from database
 * @author Austin Cain
 */
public class RemoveTutorEvent implements EventHandler<ActionEvent> {
    private FacultyHomeScreen facultyHomeScreen;
    private Account account;
    @Override
    public void handle(ActionEvent event) {
        System.out.println("Remove Tutor Event Called");

        // Remove Tutor from DB

    }

}
