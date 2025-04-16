package vn.edu.usth.doconcall.Schedule;

import static vn.edu.usth.doconcall.Schedule.Calendar.Calendar_Utils.selectedDate;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

import vn.edu.usth.doconcall.R;
import vn.edu.usth.doconcall.Schedule.Calendar.Calendar_Utils;
import vn.edu.usth.doconcall.Schedule.Event.Event;
import vn.edu.usth.doconcall.Schedule.Hour.HourEvent;
import vn.edu.usth.doconcall.Schedule.Hour.Hour_Adapter;

public class Daily_Fragment extends Fragment {

    private TextView monthDayText;
    private TextView dayOfWeekTV;
    private ListView hourListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_daily_, container, false);

        initWidgets(v);

        Button back_day = v.findViewById(R.id.back_day_button);
        back_day.setOnClickListener(view -> {
            selectedDate = selectedDate.minusDays(1);
            setDayView();
        });

        Button next_day = v.findViewById(R.id.next_day_button);
        next_day.setOnClickListener(view -> {
            selectedDate = selectedDate.plusDays(1);
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
        monthDayText.setText(Calendar_Utils.monthDayFromDate(selectedDate));
        String dayOfWeek = selectedDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
        dayOfWeekTV.setText(dayOfWeek);
        setHourAdapter();
    }

    private void setHourAdapter()
    {
        Hour_Adapter hourAdapter = new Hour_Adapter(requireContext(), hourEventList());
        hourListView.setAdapter(hourAdapter);
    }

    private ArrayList<HourEvent> hourEventList()
    {
        ArrayList<HourEvent> list = new ArrayList<>();

        for(int hour = 0; hour < 24; hour++)
        {
            LocalTime time = LocalTime.of(hour, 0);
            ArrayList<Event> events = Event.eventsForDateAndTime(selectedDate, time);
            HourEvent hourEvent = new HourEvent(time, events);
            list.add(hourEvent);
        }

        return list;
    }

}