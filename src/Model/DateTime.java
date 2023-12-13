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

    public String printString(){
        String result = "";

        Integer years, month, day, hours, minutes;
        years = this.year;
        month = this.month;
        day = this.day;
        hours = this.hours;
        minutes = this.minutes;

        result += month.toString() + " ";
        result += day.toString() + ", ";
        result += years.toString() + " @ ";
        result += hours.toString() + ":" + minutes.toString();

        return result;
    }
}
