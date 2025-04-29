package vn.edu.usth.doconcall.Doctor.Schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

import vn.edu.usth.doconcall.Doctor.Schedule.Calendar.Doctor_Calendar_Utils;
import vn.edu.usth.doconcall.Doctor.Schedule.Event.Doctor_Event;
import vn.edu.usth.doconcall.Doctor.Schedule.Hour.Doctor_HourEvent;
import vn.edu.usth.doconcall.Doctor.Schedule.Hour.Doctor_Hour_Adapter;
import vn.edu.usth.doconcall.R;

public class Doctor_Daily_Fragment extends Fragment {

    private TextView monthDayText;
    private TextView dayOfWeekTV;
    private ListView hourListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_doctor_daily_, container, false);

        initWidgets(v);

        Button back_day = v.findViewById(R.id.back_day_button);
        back_day.setOnClickListener(view -> {
            Doctor_Calendar_Utils.selectedDate = Doctor_Calendar_Utils.selectedDate.minusDays(1);
            setDayView();
        });

        Button next_day = v.findViewById(R.id.next_day_button);
        next_day.setOnClickListener(view -> {
            Doctor_Calendar_Utils.selectedDate = Doctor_Calendar_Utils.selectedDate.plusDays(1);
            setDayView();
        });

        return v;
    }

    private void initWidgets(View v)
    {
        monthDayText = v.findViewById(R.id.monthDayText);
        dayOfWeekTV = v.findViewById(R.id.dayOfWeekTV);
        hourListView = v.findViewById(R.id.hourListView);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        setDayView();
    }

    private void setDayView()
    {
        monthDayText.setText(Doctor_Calendar_Utils.monthDayFromDate(Doctor_Calendar_Utils.selectedDate));
        String dayOfWeek = Doctor_Calendar_Utils.selectedDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
        dayOfWeekTV.setText(dayOfWeek);
        setHourAdapter();
    }

    private void setHourAdapter()
    {
        Doctor_Hour_Adapter hourAdapter = new Doctor_Hour_Adapter(requireContext(), hourEventList());
        hourListView.setAdapter(hourAdapter);
    }

    private ArrayList<Doctor_HourEvent> hourEventList()
    {
        ArrayList<Doctor_HourEvent> list = new ArrayList<>();

        for(int hour = 0; hour < 24; hour++)
        {
            LocalTime time = LocalTime.of(hour, 0);
            ArrayList<Doctor_Event> events = Doctor_Event.eventsForDateAndTime(Doctor_Calendar_Utils.selectedDate, time);
            Doctor_HourEvent hourEvent = new Doctor_HourEvent(time, events);
            list.add(hourEvent);
        }

        return list;
    }

}