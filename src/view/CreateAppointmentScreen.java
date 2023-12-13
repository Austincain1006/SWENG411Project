package view;

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

import java.util.ArrayList;

/**
 * CreateAppointmentScreen.java
 * Screen from which User Creates Appointments
 * @author Austin Cain
 */
public class CreateAppointmentScreen implements AppScene{
    private VBox root;
    private HBox line1, line2, line3, line4, line5, line6;
    private Label appointmentHeader;
    private Label tutorLabel, subjectLabel, commentLabel;
    private ComboBox tutor, subject;
    private TextField comments;
    private Label dateLabel;
    private Student student;

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
        line6 = new HBox();

        root.setAlignment( Pos.CENTER );
        line1.setAlignment( Pos.CENTER );
        line2.setAlignment( Pos.CENTER );
        line3.setAlignment( Pos.CENTER );
        line4.setAlignment( Pos.CENTER );
        line5.setAlignment( Pos.CENTER );
        line6.setAlignment( Pos.CENTER );


        appointmentHeader = new Label("Appointment Creation");


        tutorLabel = new Label("Select a Tutor:");
        tutor = new ComboBox();


        subjectLabel = new Label("Select a Subject:");
        subject = new ComboBox();


        dateLabel = new Label("Select Date:");
        year = new ComboBox();
        for (Integer i = 23; i <= 35; i++)
            year.getItems().add("20" + i );
        year.getSelectionModel().select(0);

        month = new ComboBox();
        month.getItems().addAll(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        );
        month.getSelectionModel().select(0);
        month.setOnAction( event -> {
            day.getItems().clear();
            day.getItems().addAll( getDays(month.getValue().toString()));
        } );


        day = new ComboBox();
        day.getItems().addAll( getDays( month.getValue().toString() ) );
        day.getSelectionModel().select(0);

        timeLabel = new Label("Enter Time:");

        hours = new ComboBox();

        for (int i = 0; i < 24; i++)
            hours.getItems().add(i);
        hours.getSelectionModel().select(11);

        minutes = new ComboBox();
        for (int i = 1; i <= 60; i++)
            minutes.getItems().add(i);
        minutes.getSelectionModel().select(0);

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

        line5.getChildren().add(timeLabel);
        line5.getChildren().add(hours);
        line5.getChildren().add(minutes);

        line6.getChildren().add(commentLabel);
        line6.getChildren().add(comments);

        root.getChildren().add(line1);
        root.getChildren().add(line2);
        root.getChildren().add(line3);
        root.getChildren().add(line4);
        root.getChildren().add(line5);
        root.getChildren().add(line6);

        return new Scene(root, 400, 300 );
    }

    // Gets Amount of Days in a Month as a List of Strings
    private ArrayList<String> getDays(String month) {
        ArrayList<String> result = new ArrayList<>();

        // All Months have at LEAST 29 days
        for (Integer i = 1; i <= 29; i++)
            result.add(i.toString());

        switch (month) {
            case "April":
            case "June":
            case "September":
            case "November":
                result.add("30");
                break;
            case "January":
            case "March":
            case "May":
            case "July":
            case "August":
            case "October":
            case "December":
                result.add("30");
                result.add("31");
                break;
        }

        return result;
    }


    public ComboBox getTutor() {
        return tutor;
    }

    public ComboBox getSubject() {
        return subject;
    }

    public TextField getComments() {
        return comments;
    }

    public ComboBox getDay() {
        return day;
    }

    public ComboBox getMonth() {
        return month;
    }

    public ComboBox getYear() {
        return year;
    }

    public ComboBox getHours() {
        return hours;
    }

    public ComboBox getMinutes() {
        return minutes;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


}
