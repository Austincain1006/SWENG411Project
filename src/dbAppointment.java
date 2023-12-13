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
}