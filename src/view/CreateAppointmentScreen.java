package view;

import controller.ScheduleAppointmentEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CreateAppointmentScreen implements AppScene{
    private VBox root;
    private HBox line1, line2, line3, line4, line5;
    private Label appointmentHeader;
    private Label tutorLabel, subjectLabel, commentLabel;
    private ComboBox tutor, subject;
    private TextField comments;
    private Label dateLabel;
    private ComboBox day, month, year;
    private Label timeLabel;
    private ComboBox hours, minutes;
    private Button backButton, enterButton;

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


        appointmentHeader = new Label("Appointment Creation");

        tutorLabel = new Label("Select a Tutor:");
        tutor = new ComboBox();

        subjectLabel = new Label("Select a Subject:");
        subject = new ComboBox();

        dateLabel = new Label("Select Date:");
        year = new ComboBox();
        month = new ComboBox();
        day = new ComboBox();

        commentLabel = new Label("Additional Comments:");
        comments = new TextField();

        backButton = new Button();
        backButton.setOnAction( event -> GUI.setScene( GUI.getStudentHomeScreen() ));

        enterButton = new Button();
        enterButton.setOnAction( new ScheduleAppointmentEvent() );


        line1.getChildren().add(appointmentHeader);
        line2.getChildren().add(tutorLabel);
        line2.getChildren().add(tutor);
        line3.getChildren().add(subjectLabel);
        line3.getChildren().add(subject);
        line4.getChildren().add(dateLabel);
        line4.getChildren().add(year);
        line4.getChildren().add(month);
        line4.getChildren().add(day);
        line5.getChildren().add(commentLabel);
        line5.getChildren().add(comments);

        root.getChildren().add(line1);
        root.getChildren().add(line2);
        root.getChildren().add(line3);
        root.getChildren().add(line4);

        return new Scene(root, 400, 300 );
    }


}
