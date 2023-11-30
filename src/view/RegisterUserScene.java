package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RegisterUserScene implements AppScene {
    private VBox root;
    private HBox line1;
    private HBox line2;
    private HBox line3;
    private HBox line4;
    private RadioButton userButton;
    private RadioButton tutorButton;
    private Label nameLabel;
    private Label IDLabel;
    private TextField nameField;
    private TextField IDField;
    private Button backButton;
    private Button enterButton;


    /**
     * Default Contructor for LogInScene
     */
    RegisterUserScene(){
        ToggleGroup typeGroup = new ToggleGroup();
        userButton = new RadioButton("User");
        userButton.setToggleGroup(typeGroup);
        tutorButton = new RadioButton("Tutor");
        tutorButton.setToggleGroup(typeGroup);
        nameLabel = new Label("Name: ");
        nameField = new TextField();
        IDLabel = new Label("PSU ID: ");
        IDField = new TextField();
        backButton = new Button("Back");
        backButton.setOnAction( (event -> GUI.setScene( GUI.getScene("LogInScene") )) );
        enterButton = new Button("Enter");
    }

    /**
     * Builds and Returns the LogInScene
     * @return Scene to be Displayed
     */
    @Override
    public Scene makeScene() {
        root = new VBox();
        line1 = new HBox();
        line2 = new HBox();
        line3 = new HBox();
        line4 = new HBox();

        root.setAlignment( Pos.CENTER );
        line1.setAlignment( Pos.CENTER );
        line2.setAlignment( Pos.CENTER );
        line3.setAlignment( Pos.CENTER );
        line4.setAlignment( Pos.CENTER );

        line1.getChildren().add(userButton);
        line1.getChildren().add(tutorButton);

        line2.getChildren().add(nameLabel);
        line2.getChildren().add(nameField);

        line3.getChildren().add(IDLabel);
        line3.getChildren().add(IDField);

        line4.getChildren().add(backButton);
        line4.getChildren().add(enterButton);

        root.getChildren().add(line1);
        root.getChildren().add(line2);
        root.getChildren().add(line3);
        root.getChildren().add(line4);

        return new Scene(root, 400, 300 );
    }
}
