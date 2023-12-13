package controller;

import Model.Exceptions.AccountNotFoundException;
import Model.Exceptions.MissingFieldException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.GUI;
import view.SetAvailabilityScreen;

/**
 * HandleLogInEvent.java
 * Event Handler for Logging In
 */
public class SubmitTimeEvent implements EventHandler<ActionEvent> {
    private SetAvailabilityScreen scene;
    @Override
    public void handle(ActionEvent event) {

        scene = GUI.getSetAvailabilityScreen();

        try {
            submitTime();
        } catch (Exception e) {
            GUI.popupError( e );
        }

    }

    private void submitTime() throws MissingFieldException, AccountNotFoundException {
        if (    scene.getDay().getValue() == null   ||
                scene.getMonth().getValue() == null ||
                scene.getYear().getValue() == null  ||
                scene.getHours().getValue() == null ||
                scene.getMinutes().getValue() == null
            )
            throw new MissingFieldException();


        if (scene.getTutor() == null)
            throw new AccountNotFoundException();
    }
}
