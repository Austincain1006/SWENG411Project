package view;
import Model.Account;
import Model.Faculty;
import Model.Student;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * LogInScene.java
 * Page for Logging into Accounts and Registering New Ones
 * @author Austin
 */
public class FacultyHomeScreen implements AppScene {
   private VBox root;
   private HBox line1;
   private HBox line2;
   private HBox line3;
   private HBox line4;
   private Label facultyName;
   private Button backButton;
   private Button removeTutor;
   private Faculty faculty;

    /**
     * Default Contructor for LogInScene
     */
   FacultyHomeScreen(){
       backButton = new Button( "Log out" );
       backButton.setOnAction( event -> GUI.setScene( GUI.getLogInScene() ) );
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

        facultyName = new Label();
        if (faculty != null)
            facultyName.setText( faculty.getUsername() );
        else
            facultyName.setText( "NULL FACULTY" );
        removeTutor = new Button("Remove Tutor");
        backButton = new Button("Log out");
        backButton.setOnAction( event -> GUI.setScene( GUI.getLogInScene() ));

        line1.getChildren().add(facultyName);
        line2.getChildren().add(removeTutor);
        line3.getChildren().add(backButton);

        root.getChildren().add( line1 );
        root.getChildren().add( line2 );
        root.getChildren().add( line3 );
        root.getChildren().add( line4 );

        return new Scene( root, 400, 300 );
    }


    public void setFaculty(Faculty f) {
        this.faculty = f;
    }
}
