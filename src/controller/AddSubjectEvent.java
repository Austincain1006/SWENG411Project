package controller;

import Model.Exceptions.AccountNotFoundException;
import Model.Exceptions.MissingFieldException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.GUI;
import view.SetSubjectsScreen;

import java.util.concurrent.ExecutionException;

public class AddSubjectEvent implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        System.out.println("Add Subject Event Call");

        SetSubjectsScreen setSubjectsScreen = GUI.getSetSubjectsScreen();

        try {
            if (setSubjectsScreen.getTutor() == null)
                throw new AccountNotFoundException();
            if ( setSubjectsScreen.getSubjects().getValue() == null)
                throw new MissingFieldException();

            // ADD TUTOR SUBJECT HERE

        } catch (Exception e) {
            GUI.popupError( e );
        }
    }
}
