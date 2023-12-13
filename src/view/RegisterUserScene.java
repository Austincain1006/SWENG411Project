package view;

import controller.RegisterNewAccountEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RegisterUserScene implements AppScene {
    private VBox root;
    private HBox line0, line1, line2, line3, line4;
    private Label nameLabel, passwordLabel, accountLabel;
    private TextField nameField, passwordTextField;
    private Button backButton, enterButton;
    private boolean isCreatingUser = true;

    RegisterUserScene(){
        ToggleGroup typeGroup = new ToggleGroup();
        accountLabel = new Label();

        nameLabel = new Label("Name: ");
        nameField = new TextField();
        passwordLabel = new Label("Password: ");
        passwordTextField = new TextField();
        backButton = new Button("Back");
        enterButton = new Button("Enter");
        enterButton.setOnAction( new RegisterNewAccountEvent() );
    }

    @Override
    public Scene makeScene() {
        root = new VBox();
        line0 = new HBox();
        line1 = new HBox();
        line2 = new HBox();
        line3 = new HBox();
        line4 = new HBox();

        root.setAlignment( Pos.CENTER );
        line0.setAlignment( Pos.CENTER );
        line1.setAlignment( Pos.CENTER );
        line2.setAlignment( Pos.CENTER );
        line3.setAlignment( Pos.CENTER );
        line4.setAlignment( Pos.CENTER );

        if (isCreatingUser) {
            accountLabel.setText("User Registration");
            backButton.setOnAction( event -> GUI.setScene( GUI.getLogInScene() ));
        }
        else {
            accountLabel.setText("Tutor Registration");
            backButton.setOnAction( event -> GUI.setScene( GUI.getTutorHomeScreen() ));
        }



        line0.getChildren().add(accountLabel);

        line2.getChildren().add(nameLabel);
        line2.getChildren().add(nameField);

        line3.getChildren().add(passwordLabel);
        line3.getChildren().add(passwordTextField);

        line4.getChildren().add(backButton);
        line4.getChildren().add(enterButton);

        root.getChildren().add(line0);
        root.getChildren().add(line1);
        root.getChildren().add(line2);
        root.getChildren().add(line3);
        root.getChildren().add(line4);

        return new Scene(root, 400, 300 );
    }

    public TextField getNameField() {
        return nameField;
    }

    public TextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setCreatingUser(boolean creatingUser) {
        isCreatingUser = creatingUser;
    }

    public boolean getIsCreatingUser() {
        return isCreatingUser;
    }
}
