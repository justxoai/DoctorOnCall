package vn.edu.usth.doconcall.Doctor.Schedule;

import static vn.edu.usth.doconcall.Doctor.Schedule.Calendar.Doctor_Calendar_Utils.daysInMonthArray;
import static vn.edu.usth.doconcall.Doctor.Schedule.Calendar.Doctor_Calendar_Utils.monthYearFromDate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

import vn.edu.usth.doconcall.Doctor.Schedule.Calendar.Doctor_Calendar_Adapter;
import vn.edu.usth.doconcall.Doctor.Schedule.Calendar.Doctor_Calendar_Utils;
import vn.edu.usth.doconcall.R;

public class Doctor_Monthly_Fragment extends Fragment  implements  Doctor_Calendar_Adapter.OnItemListener{

    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_doctor_monthly_, container, false);

        initWidgets(v);
        Doctor_Calendar_Utils.selectedDate = LocalDate.now();
        setMonthView();

        Button back_month_button = v.findViewById(R.id.back_month_button);
        back_month_button.setOnClickListener(view -> {
            Doctor_Calendar_Utils.selectedDate = Doctor_Calendar_Utils.selectedDate.minusMonths(1);
            setMonthView();
        });

        Button next_month_button = v.findViewById(R.id.next_month_button);
        next_month_button.setOnClickListener(view -> {
            Doctor_Calendar_Utils.selectedDate = Doctor_Calendar_Utils.selectedDate.plusMonths(1);
            setMonthView();
        });

        return v;
    }

    private void initWidgets(View v)
    {
        calendarRecyclerView = v.findViewById(R.id.calendarRecyclerView);
        monthYearText = v.findViewById(R.id.monthYearTV);
    }

    private void setMonthView()
    {
        monthYearText.setText(monthYearFromDate(Doctor_Calendar_Utils.selectedDate));
        ArrayList<LocalDate> daysInMonth = daysInMonthArray();

        Doctor_Calendar_Adapter calendarAdapter = new Doctor_Calendar_Adapter(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(requireContext(), 7);

        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }

    @Override
    public void onItemClick(int position, LocalDate date)
    {
        if(date != null)
        {
            Doctor_Calendar_Utils.selectedDate = date;
            setMonthView();
        }
    }

}