package Model;

import java.util.ArrayList;

public class Student extends Account{
    ArrayList<Appointment> appointments;


    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Student() {
        super();

    }
    Student(String username, String password) {
        super(username, password);
    }



}
