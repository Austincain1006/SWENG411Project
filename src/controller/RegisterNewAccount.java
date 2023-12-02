package controller;

import Model.Database;
import Model.Exceptions.MissingFieldException;
import Model.Student;
import Model.Tutor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.GUI;
import view.LogInScene;
import view.RegisterUserScene;

public class RegisterNewAccount implements EventHandler<ActionEvent> {
    private RegisterUserScene registerScene;
    @Override
    public void handle(ActionEvent event) {
        registerScene = GUI.getRegisterUserScene();

        try {
            createAccount();
            GUI.setScene( GUI.getLogInScene() );
        } catch (MissingFieldException mfe) {
            GUI.popupError( mfe );
        }

    }


    private void createAccount() throws MissingFieldException {
        if ( registerScene.getUserButton().isSelected() ){
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

            Integer id = GUI.getDB().addAccount(newStudent);
            newStudent.setID( id );

        } else if ( registerScene.getTutorButton().isSelected() ) {
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

            Integer id = GUI.getDB().addAccount(newTutor);
            newTutor.setID( id );

        } else {
            throw new MissingFieldException();
        }
    }
}
