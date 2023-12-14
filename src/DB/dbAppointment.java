package DB;

/**
 * This class stores the resultset from the DB
 * @author Peter Mica
 * */
public class dbAppointment {
    String location, subject, tutor, student;
    Integer appointmentNumber, date, time;

    public dbAppointment(Integer appointmentNumber, Integer date, Integer time, String location,
                         String subject, String tutor, String student) {
        this.appointmentNumber = appointmentNumber;
        this.date = date;
        this.time = time;
        this.location = location;
        this.subject = subject;
        this.tutor = tutor;
        this.student = student;
    }

    public Integer getAppointmentNumber() {
        return appointmentNumber;
    }

    public Integer getDate() {
        return date;
    }

    public Integer getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getSubject() {
        return subject;
    }

    public String getTutor() {
        return tutor;
    }

    public String getStudent() {
        return student;
    }
}