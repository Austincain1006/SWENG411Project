package view;
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
public class StudentHomeScreen implements AppScene {
   private VBox root;
   private HBox line1, line2, line3, line4;
   private Label studentName;
   private Button backButton, scheduleButton, viewAppointments;
   private Student student;

    /**
     * Default Contructor for LogInScene
     */
   StudentHomeScreen(){
       makeScene();
       backButton = new Button( "Log out" );
       backButton.setOnAction( event -> GUI.setScene( GUI.getLogInScene() ) );
       studentName = new Label();
       System.out.println("Successfully created student homescreen");
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

        studentName = new Label();
        if (student == null) {
            studentName.setText("null student");
        } else {
            studentName.setText(this.student.getUsername());
        }
        scheduleButton = new Button("Schedule Appointment");
        scheduleButton.setOnAction( event -> {
            GUI.getCreateAppointmentScreen().setStudent( this.student );
            GUI.setScene( GUI.getCreateAppointmentScreen() );
        });
        viewAppointments = new Button("View Appointments");
        viewAppointments.setOnAction( event -> {
            GUI.getViewAppointmentsScreen().setAccount( this.student );
            GUI.setScene( GUI.getViewAppointmentsScreen() );
        });

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
        System.out.println(student.getUsername() + "This one here!");
        System.out.println(studentName.isFocused() + "After here");
        studentName.setText( this.student.getUsername() );
    }
}
