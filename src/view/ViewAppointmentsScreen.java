package view;

import DB.MySqlDB;
import DB.User;
import DB.dbAppointment;
import Model.Account;
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

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * ViewAppointmentsScreen.java
 * Displays Information about Selected Appointment that a Student or Tutor has
 */
public class ViewAppointmentsScreen implements AppScene{
    private VBox root;
    private HBox line1, line2, line3, line4, line5, line6, line7;
    private Label selectAppt, appoinmentList;
    private ComboBox selectAppointment;
    private ArrayList<Appointment> appointments;
    private Label date, tutor, subject, location, comments;
    private Account account;
    private Button backButton;

    @Override
    public Scene makeScene() {
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

        selectAppt = new Label("Appointment list: ");

        appoinmentList = new Label(getAppointments().toString());
        System.out.println(account.getUsername());

        /**
        Appointment appt = (Appointment) selectAppointment.getValue();
        if (appt != null) {
            date.setText( appt.getDateTime().printString() );
            tutor.setText( appt.getTutor().getUsername() );
            subject.setText( appt.getSubject() );
            location.setText( appt.getLocation() );
            comments.setText( appt.getComments() );
        }*/

        backButton = new Button("Back");
        backButton.setOnAction( event -> {
            if (this.account instanceof Student)
                GUI.setScene(GUI.getStudentHomeScreen());
            else
                GUI.setScene(GUI.getTutorHomeScreen());
        });


        line1.getChildren().add(selectAppt);
        line2.getChildren().add(appoinmentList);

        line7.getChildren().add(backButton);


        root.getChildren().add(line1);
        root.getChildren().add(line2);

        root.getChildren().add(line7);

        return new Scene(root, 400, 300 );
    }

    public void setAccount(Account acc) {
        this.account = acc;
    }

    private ArrayList<String> getAppointments(){
        ArrayList<String> results = new ArrayList<>();

        // Get Appointments from Database tied to this account

        /**
         * Creation of the appointment list
         */

        //Initialize DB
        MySqlDB db = new MySqlDB();
        db.init();

        User result = db.getLogin(account.getPassword(), account.getUsername());

        //Get the appointment list resultset as an arraylist
        ArrayList<dbAppointment> apptList = db.getAppointment(result);


        //Get size of the Appointment list
        int size = apptList.size();

        //Iterate over appointment list
        for (int i =0; i < size; i++) {
            dbAppointment tempAppt = apptList.get(i);

            //Process date into readable format
            String dateUP = String.valueOf(tempAppt.getDate()); //Convert to string
            String date = dateUP.substring(0,2) + "/" + dateUP.substring(2,4) + "/" + dateUP.substring(4);

            //Process time into readable format

            Integer dbTime = tempAppt.getTime();
            //Determine AM or PM based on military time format
            String amOrPM;
            if (tempAppt.getTime() < 1200) {
                amOrPM = "AM";
            } else {
                amOrPM = "PM";
                if (tempAppt.getTime() > 1259) {
                    dbTime -= 1200;
                }

            }

            String timeUP = String.valueOf(dbTime); //Convert to string

            String time = timeUP.substring(0,2) + ":" + timeUP + amOrPM;

            //Converts relevant data to a string literal to put into the arraylist
            String appt = "Appointment Number: " + tempAppt.getAppointmentNumber() +
                    " | Date: " + date + "\n" +
                    " | Time: " + time + "\n" +
                    " | Location: " + tempAppt.getLocation() + "\n" +
                    " | Subject: " + tempAppt.getSubject() + "\n" +
                    " | Tutor: " + tempAppt.getTutor() + "\n" +
                    " | Student" + tempAppt.getStudent() + "\n\n";
            results.add(appt);
        }

        return results;
    }


}
