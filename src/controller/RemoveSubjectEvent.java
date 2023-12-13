package controller;

import Model.Exceptions.AccountNotFoundException;
import Model.Exceptions.MissingFieldException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.GUI;
import view.SetSubjectsScreen;

/**
 * RemoveSubjectEvent.java
 * Listener Class for when Tutor User Selects to Remove a designated Subject
 * @author Austin Cain
 */
public class RemoveSubjectEvent implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        System.out.println("Remove Subject Event Call");

        SetSubjectsScreen setSubjectsScreen = GUI.getSetSubjectsScreen();

        try {
            if (setSubjectsScreen.getTutor() == null)
                throw new AccountNotFoundException();
            if ( setSubjectsScreen.getSubjects().getValue() == null)
                throw new MissingFieldException();

            // REMOVE TUTOR SUBJECT HERE

        } catch (Exception e) {
            GUI.popupError( e );
        }
    }
}
