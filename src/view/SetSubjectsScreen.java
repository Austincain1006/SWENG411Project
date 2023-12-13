package view;

import Model.Tutor;
import controller.AddSubjectEvent;
import controller.RemoveSubjectEvent;
import controller.SubmitTimeEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SetSubjectsScreen implements AppScene{
    private VBox root;
    private HBox line1, line2, line3, line4;
    private Button backButton;
    private Button addSubjectButton;
    private Button removeSubjectButton;
    private ComboBox subjects;
    private Label subjectLable;
    private Tutor tutor;


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

        subjectLable = new Label("Select a Subject to Add/Remove");
        subjects = new ComboBox();
        subjects.getItems().addAll(
                "SWENG411",
                "SWENG311",
                "GAME480",
                "MATH121",
                "MATH122",
                "CMPSC121",
                "CMPSC122",
                "CMPSC360",
                "CMPSC335"
        );

        addSubjectButton = new Button("Add");
        addSubjectButton.setOnAction( new AddSubjectEvent() );

        removeSubjectButton = new Button("Remove");
        removeSubjectButton.setOnAction( new RemoveSubjectEvent());

        backButton = new Button("Back");
        backButton.setOnAction( event -> GUI.setScene( GUI.getTutorHomeScreen() ));


        line1.getChildren().add(subjectLable);
        line2.getChildren().add(subjects);
        line3.getChildren().add(addSubjectButton);
        line3.getChildren().add(removeSubjectButton);
        line4.getChildren().add(backButton);

        root.getChildren().add(line1);
        root.getChildren().add(line2);
        root.getChildren().add(line3);
        root.getChildren().add(line4);

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

    public ComboBox getSubjects() {
        return subjects;
    }
}
