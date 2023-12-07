package Model;

public class DateTime {
    private int month;
    private int day;
    private int year;
    private int hours;
    private int minutes;

    public DateTime(){
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.hours = 0;
        this.minutes = 0;
    }

    public DateTime( int year, int month, int day){
        this.day = day;
        this.month = month;
        this.year = year;
        this.hours = 0;
        this.minutes = 0;
    }

    public DateTime( int year, int month, int day, int hours, int minutes){
        this.day = day;
        this.month = month;
        this.year = year;
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getYear(){
        return this.year;
    }

    public int getMonth(){
        return this.month;
    }

    public int getDay(){
        return this.day;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}
