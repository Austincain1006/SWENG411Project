package Model;

import java.util.ArrayList;

/**
 * Student.java
 * Represents a Student User
 * @author Austin Cain
 */
public class Student extends Account{
    ArrayList<Appointment> appointments;

    public Student() {
        super();

    }

    Student(String username, String password) {
        super(username, password);
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

}
