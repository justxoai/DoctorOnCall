package vn.edu.usth.doconcall.Doctor.Dashboard.Fragment;

import static vn.edu.usth.doconcall.Doctor.Schedule.Calendar.Doctor_Calendar_Utils.daysInMonthArray;
import static vn.edu.usth.doconcall.Doctor.Schedule.Calendar.Doctor_Calendar_Utils.monthYearFromDate;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import vn.edu.usth.doconcall.Doctor.HealthCheck.Doctor_HealthCheck;
import vn.edu.usth.doconcall.Doctor.HealthCheck.List_Patient.Patient_Adapter;
import vn.edu.usth.doconcall.Doctor.HealthCheck.List_Patient.Patient_Item;
import vn.edu.usth.doconcall.Doctor.Schedule.Calendar.Doctor_Calendar_Utils;
import vn.edu.usth.doconcall.Doctor.Schedule.Event.Doctor_Event;
import vn.edu.usth.doconcall.Doctor.Schedule.Event.Doctor_Event_Adapter;
import vn.edu.usth.doconcall.Doctor.Schedule.Hour.Doctor_Hour_Adapter;
import vn.edu.usth.doconcall.R;

public class Doctor_Dashboard_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Layout
        View v = inflater.inflate(R.layout.fragment_doctor__dashboard_, container, false);

        // Dashboard Fragment Function
        dash_board_function(v);

        // RecyclerView List Patient in HealthCheck
        recycler_view_list_patient(v);

        // Setup Calendar
        calendar_setup_function(v);

        return v;
    }

    private void calendar_setup_function(View v) {
        // Get Locate Time
        Doctor_Calendar_Utils.selectedDate = LocalDate.now();

        // Month and year
        TextView month_year = v.findViewById(R.id.monthYearTV_doctor_dashboard);
        month_year.setText(monthYearFromDate(Doctor_Calendar_Utils.selectedDate));

        // Day and Month
        TextView day = v.findViewById(R.id.dayOfWeekTV_doctor_dashboard);
        day.setText(Doctor_Calendar_Utils.monthDayFromDate(Doctor_Calendar_Utils.selectedDate));

        // List Event
        ListView event = v.findViewById(R.id.eventListView_dashboard);
        ArrayList<Doctor_Event> dailyEvents = Doctor_Event.eventsForDate(Doctor_Calendar_Utils.selectedDate);
        Doctor_Event_Adapter eventAdapter = new Doctor_Event_Adapter(requireContext(), dailyEvents);
        event.setAdapter(eventAdapter);
    }

    private void recycler_view_list_patient(View v) {
        RecyclerView recyclerView = v.findViewById(R.id.recycler_view_patient_dashboard);

        List<Patient_Item> items = new ArrayList<Patient_Item>();

        items.add(new Patient_Item("Alice Nguyen", "Female", "0901234567", "01/01/1990"));
        items.add(new Patient_Item("Brian Tran", "Male", "0934567890", "12/05/1988"));
        items.add(new Patient_Item("Catherine Le", "Female", "0967890123", "23/09/1992"));

        Patient_Adapter adapter = new Patient_Adapter(requireContext(), items);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);

    }

    private void dash_board_function(View v) {
        RelativeLayout see_all_patient = v.findViewById(R.id.see_all_patient);
        see_all_patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), Doctor_HealthCheck.class);
                startActivity(i);
            }
        });
    }
}