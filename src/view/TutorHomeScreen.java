package view;
import Model.Student;
import Model.Tutor;
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
public class TutorHomeScreen implements AppScene {
   private VBox root;
   private HBox line1;
   private HBox line2;
   private HBox line3;
   private HBox line4;
   private HBox line5;
   private Tutor tutor;
   private Button backButton;
   private Button viewAppointments;
   private Button setAvailability;
   private Button setSubjects;
   private Label tutorName;


    /**
     * Default Contructor for LogInScene
     */
   TutorHomeScreen(){
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
        line5 = new HBox();

        root.setAlignment( Pos.CENTER );
        line1.setAlignment( Pos.CENTER );
        line2.setAlignment( Pos.CENTER );
        line3.setAlignment( Pos.CENTER );
        line4.setAlignment( Pos.CENTER );
        line5.setAlignment( Pos.CENTER );

        tutorName = new Label();
        if (tutor != null)
            tutorName.setText( tutor.getUsername() );
        else
            tutorName.setText( "Null Tutor" );

        viewAppointments = new Button("View Appointments");
        viewAppointments.setOnAction( event -> {
            GUI.getViewAccountScene().setAccount( this.tutor );
            GUI.setScene( GUI.getViewAppointmentsScreen() );
        });

        setAvailability = new Button("Set Availability");
        //setAvailability.setOnAction(  );

        setSubjects = new Button("Set Subjects");
        //setSubjects.setOnAction( );

        line1.getChildren().add(tutorName);
        line2.getChildren().add(viewAppointments);
        line3.getChildren().add(setAvailability);
        line4.getChildren().add(setSubjects);
        line5.getChildren().add(backButton);

        root.getChildren().add( line1 );
        root.getChildren().add( line2 );
        root.getChildren().add( line3 );
        root.getChildren().add( line4 );
        root.getChildren().add( line5 );

        return new Scene( root, 400, 300 );
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
