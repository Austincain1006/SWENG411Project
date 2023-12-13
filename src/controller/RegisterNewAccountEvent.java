package controller;

import Model.Exceptions.MissingFieldException;
import Model.Student;
import Model.Tutor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.GUI;
import view.RegisterUserScene;

/**
 * RegisterNewAccountEvent.java
 * Listener Class for when User selects to Register a New Account
 * @author Austin Cain
 */
public class RegisterNewAccountEvent implements EventHandler<ActionEvent> {
    private RegisterUserScene registerScene;
    @Override
    public void handle(ActionEvent event) {
        registerScene = GUI.getRegisterUserScene();

        try {
            createAccount();

            if (registerScene.getIsCreatingUser())
                GUI.setScene( GUI.getLogInScene() );
            else
                GUI.setScene( GUI.getFacultyHomeScreen() );

        } catch (MissingFieldException mfe) {
            GUI.popupError( mfe );
        }

    }

    /**
     * Creates an account from user input from register scene
     * @throws MissingFieldException
     */
    private void createAccount() throws MissingFieldException {
        if ( registerScene.getIsCreatingUser() == true ){
            // Make Student
            Student newStudent = new Student();

            if ( !registerScene.getNameField().getText().isEmpty() ){
                newStudent.setUsername( registerScene.getNameField().getText() );
            } else {
                throw new MissingFieldException();
            }

            if ( !registerScene.getPasswordTextField().getText().isEmpty() ) {
                newStudent.setPassword( registerScene.getPasswordTextField().getText() );
            } else {
                throw new MissingFieldException();
            }

            newStudent.setID( GUI.getDB().addAccount(newStudent) );

        } else if ( registerScene.getIsCreatingUser() == false ) {
            // Make Tutor
            Tutor newTutor = new Tutor();

            if ( !registerScene.getNameField().getText().isEmpty() ){
                newTutor.setUsername( registerScene.getNameField().getText() );
            } else {
                throw new MissingFieldException();
            }

            if ( !registerScene.getPasswordTextField().getText().isEmpty() ) {
                newTutor.setPassword( registerScene.getPasswordTextField().getText() );
            } else {
                throw new MissingFieldException();
            }

            newTutor.setID( GUI.getDB().addAccount(newTutor) );

        } else {
            throw new MissingFieldException();
        }
    }
}
