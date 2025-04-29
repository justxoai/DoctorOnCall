package vn.edu.usth.doconcall.Doctor.Schedule.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Doctor_Event {

    public static ArrayList<Doctor_Event> eventsList = new ArrayList<>();

    public static ArrayList<Doctor_Event> eventsForDate(LocalDate date)
    {
        ArrayList<Doctor_Event> events = new ArrayList<>();

        for(Doctor_Event event : eventsList)
        {
            if(event.getDate().equals(date))
                events.add(event);
        }

        return events;
    }

    public static ArrayList<Doctor_Event> eventsForDateAndTime(LocalDate date, LocalTime time)
    {
        ArrayList<Doctor_Event> events = new ArrayList<>();

        for(Doctor_Event event : eventsList)
        {
            int eventHour = event.time.getHour();
            int cellHour = time.getHour();
            if(event.getDate().equals(date) && eventHour == cellHour)
                events.add(event);
        }

        return events;
    }


    private String name;
    private LocalDate date;
    private LocalTime time;

    public Doctor_Event(String name, LocalDate date, LocalTime time)
    {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }

}
