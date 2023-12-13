package Model;

import java.util.ArrayList;

public class Appointment {
    private ArrayList<Student> students;
    private Tutor tutor;
    private DateTime dateTime;
    private String location;
    private String subject;
    private String comments;


    Appointment(Tutor t, ArrayList<Student> s, DateTime d, String loc) {
        tutor = t;
        students = s;
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

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public String getComments(){
        return this.comments;
    }
}
