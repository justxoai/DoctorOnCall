package vn.edu.usth.doconcall.Doctor.Schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

import vn.edu.usth.doconcall.Doctor.Schedule.Calendar.Doctor_Calendar_Adapter;
import vn.edu.usth.doconcall.Doctor.Schedule.Calendar.Doctor_Calendar_Utils;
import vn.edu.usth.doconcall.Doctor.Schedule.Event.Doctor_Event;
import vn.edu.usth.doconcall.Doctor.Schedule.Event.Doctor_Event_Adapter;
import vn.edu.usth.doconcall.R;

public class Doctor_Weekly_Fragment extends Fragment implements Doctor_Calendar_Adapter.OnItemListener {

    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private ListView eventListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_doctor_weekly_, container, false);

        initWidgets(v);

        setWeekView();

        Button back_week_button = v.findViewById(R.id.back_week_button);
        back_week_button.setOnClickListener(view -> {
            Doctor_Calendar_Utils.selectedDate = Doctor_Calendar_Utils.selectedDate.minusWeeks(1);
            setWeekView();
        });

        Button next_week_button = v.findViewById(R.id.next_week_button);
        next_week_button.setOnClickListener(view -> {
            Doctor_Calendar_Utils.selectedDate = Doctor_Calendar_Utils.selectedDate.plusWeeks(1);
            setWeekView();
        });

        return v;
    }

    private void initWidgets(View v)
    {
        calendarRecyclerView = v.findViewById(R.id.calendarRecyclerView);
        monthYearText = v.findViewById(R.id.monthYearTV);
        eventListView = v.findViewById(R.id.eventListView);
    }

    private void setWeekView()
    {
        monthYearText.setText(Doctor_Calendar_Utils.monthYearFromDate(Doctor_Calendar_Utils.selectedDate));
        ArrayList<LocalDate> days = Doctor_Calendar_Utils.daysInWeekArray(Doctor_Calendar_Utils.selectedDate);

        Doctor_Calendar_Adapter calendarAdapter = new Doctor_Calendar_Adapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(requireContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
        setEventAdpater();
    }

    @Override
    public void onItemClick(int position, LocalDate date)
    {
        Doctor_Calendar_Utils.selectedDate = date;
        setWeekView();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        setEventAdpater();
    }

    private void setEventAdpater()
    {
        ArrayList<Doctor_Event> dailyEvents = Doctor_Event.eventsForDate(Doctor_Calendar_Utils.selectedDate);
        Doctor_Event_Adapter eventAdapter = new Doctor_Event_Adapter(requireContext(), dailyEvents);
        eventListView.setAdapter(eventAdapter);
    }

}