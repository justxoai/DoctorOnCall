package vn.edu.usth.doconcall.Doctor.Schedule.Hour;

import java.time.LocalTime;
import java.util.ArrayList;

import vn.edu.usth.doconcall.Doctor.Schedule.Event.Doctor_Event;

public class Doctor_HourEvent {

    LocalTime time;
    ArrayList<Doctor_Event> events;

    public Doctor_HourEvent(LocalTime time, ArrayList<Doctor_Event> events)
    {
        this.time = time;
        this.events = events;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }

    public ArrayList<Doctor_Event> getEvents()
    {
        return events;
    }

    public void setEvents(ArrayList<Doctor_Event> events)
    {
        this.events = events;
    }
}
