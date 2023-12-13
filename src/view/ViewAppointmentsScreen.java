package view;

import Model.Appointment;
import Model.Student;
import controller.ScheduleAppointmentEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ViewAppointmentsScreen implements AppScene{
    private VBox root;
    private HBox line1, line2, line3, line4, line5, line6, line7;
    private Label selectAppt;
    private ComboBox selectAppointment;
    private ArrayList<Appointment> appointments;
    private Label date, tutor, subject, location, comments;
    private Student student;
    private Button backButton;

    @Override
    public Scene makeScene() {

        System.out.println( "MAKING SCENE" );
        root = new VBox();
        line1 = new HBox();
        line2 = new HBox();
        line3 = new HBox();
        line4 = new HBox();
        line5 = new HBox();
        line6 = new HBox();
        line7 = new HBox();

        root.setAlignment( Pos.CENTER );
        line1.setAlignment( Pos.CENTER );
        line2.setAlignment( Pos.CENTER );
        line3.setAlignment( Pos.CENTER );
        line4.setAlignment( Pos.CENTER );
        line5.setAlignment( Pos.CENTER );
        line6.setAlignment( Pos.CENTER );
        line7.setAlignment( Pos.CENTER );

        selectAppt = new Label("Select an Appointment: ");
        selectAppointment = new ComboBox();
        appointments =  getAppointments();
        selectAppointment.getItems().addAll( appointments );

        date = new Label("Null Date");
        tutor = new Label("Null Tutor");
        subject = new Label("Null Subject");
        location = new Label("Null Location");
        comments = new Label("Null Commments");
        Appointment appt = (Appointment) selectAppointment.getValue();
        if (appt != null) {
            date.setText( appt.getDateTime().printString() );
            tutor.setText( appt.getTutor().getUsername() );
            subject.setText( appt.getSubject() );
            location.setText( appt.getLocation() );
            comments.setText( appt.getComments() );
        }

        backButton = new Button("Back");
        backButton.setOnAction( event -> GUI.setScene( GUI.getStudentHomeScreen() ));


        line1.getChildren().add(selectAppt);
        line1.getChildren().add(selectAppointment);
        line2.getChildren().add(date);
        line3.getChildren().add(tutor);
        line4.getChildren().add(subject);
        line5.getChildren().add(location);
        line6.getChildren().add(comments);
        line7.getChildren().add(backButton);


        root.getChildren().add(line1);
        root.getChildren().add(line2);
        root.getChildren().add(line3);
        root.getChildren().add(line4);
        root.getChildren().add(line5);
        root.getChildren().add(line6);
        root.getChildren().add(line7);

        return new Scene(root, 400, 300 );
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    private ArrayList<Appointment> getAppointments(){
        ArrayList<Appointment> results = new ArrayList<>();

        // Get Appointments from Database

        return results;
    }


}
