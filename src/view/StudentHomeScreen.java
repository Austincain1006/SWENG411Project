package view;
import Model.Exceptions.AccountNotFound;
import Model.Student;
import controller.HandleLogInEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * LogInScene.java
 * Page for Logging into Accounts and Registering New Ones
 * @author Austin
 */
public class StudentHomeScreen implements AppScene {
   private VBox root;
   private HBox line1;
   private HBox line2;
   private HBox line3;
   private HBox line4;
   private Label studentName;
   private Button backButton;
   private Button scheduleButton;
   private Button viewAppointments;
   private Student student;

    /**
     * Default Contructor for LogInScene
     */
   StudentHomeScreen(){
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

        studentName = new Label();
        studentName.setText( "Student Name" );
        scheduleButton = new Button("Schedule Appointment");
        viewAppointments = new Button("View Appointments");
        backButton = new Button("Log out");
        backButton.setOnAction( event -> GUI.setScene( GUI.getLogInScene() ));

        line1.getChildren().add(studentName);
        line2.getChildren().add(scheduleButton);
        line3.getChildren().add(viewAppointments);
        line4.getChildren().add(backButton);

        root.getChildren().add( line1 );
        root.getChildren().add( line2 );
        root.getChildren().add( line3 );
        root.getChildren().add( line4 );

        return new Scene( root, 400, 300 );
    }

    public void setStudent(Student student) {
        this.student = student;
        studentName.setText( this.student.getUsername() );
    }
}
