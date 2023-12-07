package Model;

import java.util.ArrayList;

public class Appointment {
    private ArrayList<Student> students;
    private Tutor tutor;
    private DateTime dateTime;
    private String location;

    Appointment(Tutor t, ArrayList<Student> s, DateTime d, String loc) {
        tutor = t;
        students = s;
        dateTime = d;
        location = loc;
    }

}
