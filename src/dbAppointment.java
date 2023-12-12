/**
 * This class stores the resultset from the DB
 * @author Peter Mica
 * */
public class dbAppointment {
    String appointmentNumber, location, subject, tutor, student;
    Integer date, time;

    public dbAppointment(String appointmentNumber, Integer date, Integer time, String location,
                         String subject, String tutor, String student) {
        this.appointmentNumber = appointmentNumber;
        this.date = date;
        this.time = time;
        this.location = location;
        this.subject = subject;
        this.tutor = tutor;
        this.student = student;
    }
}