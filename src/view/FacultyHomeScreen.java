package view;
import Model.Account;
import Model.Faculty;
import Model.Student;
import Model.Tutor;
import controller.RemoveTutorEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * LogInScene.java
 * Page for Logging into Accounts and Registering New Ones
 * @author Austin
 */
public class FacultyHomeScreen implements AppScene {
   private VBox root;
   private HBox line1, line2, line3, line4, linex;
   private Label facultyName;
   private Button backButton, removeTutor, addTutor;
   private ComboBox removeTutorComboBox;
   private Faculty faculty;

   //Default Contructor for LogInScene
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
        linex = new HBox();
        line1 = new HBox();
        line2 = new HBox();
        line3 = new HBox();
        line4 = new HBox();

        root.setAlignment( Pos.CENTER );
        line1.setAlignment( Pos.CENTER );
        linex.setAlignment( Pos.CENTER );
        line2.setAlignment( Pos.CENTER );
        line3.setAlignment( Pos.CENTER );
        line4.setAlignment( Pos.CENTER );

        facultyName = new Label();
        if (faculty != null)
            facultyName.setText( faculty.getUsername() );
        else
            facultyName.setText( "NULL FACULTY" );

        addTutor = new Button("Add Tutor");
        addTutor.setOnAction(event -> {
            GUI.getRegisterUserScene().setCreatingUser(false);
            GUI.setScene(GUI.getRegisterUserScene());
        });

        removeTutor = new Button("Remove Tutor");
        removeTutor.setOnAction( new RemoveTutorEvent() );
        removeTutorComboBox = new ComboBox();
        removeTutorComboBox.getItems().addAll( getTutors() );

        backButton = new Button("Log out");
        backButton.setOnAction( event -> GUI.setScene( GUI.getLogInScene() ));

        line1.getChildren().add(facultyName);
        linex.getChildren().add(addTutor);
        line2.getChildren().add(removeTutorComboBox);
        line2.getChildren().add(removeTutor);
        line3.getChildren().add(backButton);

        root.getChildren().add( line1 );
        root.getChildren().add( linex );
        root.getChildren().add( line2 );
        root.getChildren().add( line3 );
        root.getChildren().add( line4 );

        return new Scene( root, 400, 300 );
    }

    // Query Database to get List of All Tutors
    private ArrayList<String> getTutors() {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Tutor> tutors = new ArrayList<>();

        // Get ALL Tutors from DB
        // ... ADD DB CODE HERE

        // Get Names of Tutors
        Iterator<Tutor> iter = tutors.iterator();
        while (iter.hasNext())
            result.add( iter.next().getUsername() );

        return result;
    }

    public void setFaculty(Faculty f) {
        this.faculty = f;
    }

    public ComboBox getRemoveTutorComboBox() {
        return removeTutorComboBox;
    }
}
