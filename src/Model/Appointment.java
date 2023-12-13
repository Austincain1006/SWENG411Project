package Model;

import java.util.ArrayList;

/**
 * Appointment.java
 * Represents an appointment between 1 tutor and 1
 * @author Austin Cain
 */
public class Appointment {
    private Student student;
    private Tutor tutor;
    private DateTime dateTime;
    private String location;
    private String subject;
    private String comments;


    Appointment(Tutor t, Student s, DateTime d, String loc) {
        tutor = t;
        student = s;
        dateTime = d;
        location = loc;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getComments(){
        return this.comments;
    }
}
