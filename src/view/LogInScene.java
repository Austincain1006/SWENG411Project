package view;
import controller.HandleLogInEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * LogInScene.java
 * Page for Logging into Accounts and Registering New Ones
 * @author Austin
 */
public class LogInScene implements AppScene {
   private VBox root;
   private HBox line1;
   private HBox line2;
   private HBox line3;
   private HBox line4;
   private Label loginLabel;
   private Label usernameLabel;
   private Label passwordLabel;
   private TextField usernameField;
   private TextField passwordField;
   private Button registerButton;
   private Button loginButton;

    /**
     * Default Contructor for LogInScene
     */
   LogInScene(){
       loginLabel = new Label( "Please Log In ");
       usernameLabel = new Label( "Enter Username: ");
       passwordLabel = new Label( "Enter Password: ");

       usernameField = new TextField();
       passwordField = new TextField();

       registerButton = new Button( "Register" );
       registerButton.setOnAction( (event -> {
           GUI.getRegisterUserScene().setCreatingUser(true);
           GUI.setScene(GUI.getRegisterUserScene());
       }) );

       loginButton = new Button( "Log In");
       loginButton.setOnAction( new HandleLogInEvent() );

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

        line1.getChildren().add(loginLabel);

        line2.getChildren().add(usernameLabel);
        line2.getChildren().add(usernameField);

        line3.getChildren().add(passwordLabel);
        line3.getChildren().add(passwordField);

        line4.getChildren().add(registerButton);
        line4.getChildren().add(loginButton);

        root.getChildren().add( line1 );
        root.getChildren().add( line2 );
        root.getChildren().add( line3 );
        root.getChildren().add( line4 );

        return new Scene( root, 400, 300 );
    }

    public TextField getUsernameField(){
        return usernameField;
    }

    public TextField getPasswordField(){
        return passwordField;
    }

    public void clearTextFields() {
        usernameField.setText("");
        passwordField.setText("");
    }
}
