package view;

import Model.Tutor;
import controller.SubmitTimeEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class SetAvailabilityScreen implements AppScene{
    private VBox root;
    private HBox line1, line2, line3, line4, line5, line6;
    private Button backButton, enterButton;
    private Label dateLabel,timeLabel, availableLabel;
    private ComboBox year, month, day, hours, minutes;
    private Tutor tutor;


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

        availableLabel = new Label("Select a Date where you can tutor for 1 hour.");

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

        for (int i = 0; i <= 23; i++)
            hours.getItems().add(i);
        hours.getSelectionModel().select(11);

        minutes = new ComboBox();
        for (int i = 1; i <= 60; i++)
            minutes.getItems().add(i);
        minutes.getSelectionModel().select(0);

        enterButton = new Button("Submit");
        enterButton.setOnAction( new SubmitTimeEvent() );

        backButton = new Button("Back");
        backButton.setOnAction( event -> GUI.setScene( GUI.getTutorHomeScreen() ));


        line1.getChildren().add(availableLabel);
        line2.getChildren().add(dateLabel);
        line3.getChildren().add(year);
        line3.getChildren().add(month);
        line3.getChildren().add(day);
        line4.getChildren().add(timeLabel);
        line5.getChildren().add(hours);
        line5.getChildren().add(minutes);
        line6.getChildren().add(backButton);
        line6.getChildren().add(enterButton);

        root.getChildren().add(line1);
        root.getChildren().add(line2);
        root.getChildren().add(line3);
        root.getChildren().add(line4);
        root.getChildren().add(line5);
        root.getChildren().add(line6);

        return new Scene(root, 400, 300 );
    }

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

    public Tutor getTutor() {
        return tutor;
    }

    public ComboBox getYear() {
        return year;
    }

    public ComboBox getMonth() {
        return month;
    }

    public ComboBox getDay() {
        return day;
    }

    public ComboBox getHours() {
        return hours;
    }

    public ComboBox getMinutes() {
        return minutes;
    }

}
