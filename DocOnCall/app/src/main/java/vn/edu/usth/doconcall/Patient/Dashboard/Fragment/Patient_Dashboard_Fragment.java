package vn.edu.usth.doconcall.Patient.Dashboard.Fragment;

import static vn.edu.usth.doconcall.Doctor.Schedule.Calendar.Doctor_Calendar_Utils.monthYearFromDate;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.doconcall.Doctor.Schedule.Calendar.Doctor_Calendar_Utils;
import vn.edu.usth.doconcall.Doctor.Schedule.Event.Doctor_Event;
import vn.edu.usth.doconcall.Doctor.Schedule.Event.Doctor_Event_Adapter;
import vn.edu.usth.doconcall.Patient.HealthCheck.Patient_HealthCheck;
import vn.edu.usth.doconcall.Patient.List_Doctor.Patient_List_Doctor;
import vn.edu.usth.doconcall.Patient.List_Doctor.RecyclerView.Doctor_Adapter;
import vn.edu.usth.doconcall.Patient.List_Doctor.RecyclerView.Doctor_Items;
import vn.edu.usth.doconcall.R;

public class Patient_Dashboard_Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_patient__dashboard_, container, false);

        // Dashboard Fragment Function
        dashboard_function(v);

        // Setup Doctor RecyclerView
        doctor_recycler_view(v);

        // Setup Calendar
        calendar_setup_function(v);

        return v;
    }

    private void calendar_setup_function(View v) {
        // Get Locate Time
        Doctor_Calendar_Utils.selectedDate = LocalDate.now();

        // Month and year
        TextView month_year = v.findViewById(R.id.monthYearTV_patient_dashboard);
        month_year.setText(monthYearFromDate(Doctor_Calendar_Utils.selectedDate));

        // Day and Month
        TextView day = v.findViewById(R.id.dayOfWeekTV_patient_dashboard);
        day.setText(Doctor_Calendar_Utils.monthDayFromDate(Doctor_Calendar_Utils.selectedDate));

        // List Event
        ListView event = v.findViewById(R.id.eventListView_patient_dashboard);
        ArrayList<Doctor_Event> dailyEvents = Doctor_Event.eventsForDate(Doctor_Calendar_Utils.selectedDate);
        Doctor_Event_Adapter eventAdapter = new Doctor_Event_Adapter(requireContext(), dailyEvents);
        event.setAdapter(eventAdapter);
    }

    private void doctor_recycler_view(View v) {
        RecyclerView doctor_recycler = v.findViewById(R.id.recycler_view_doctor_dashboard);

        List<Doctor_Items> items = new ArrayList<Doctor_Items>();
        List<Doctor_Items> filter_items = new ArrayList<Doctor_Items>();


        items.add(new Doctor_Items("Dr. Hannah Brooks", "Endocrinologist", "4.8", R.drawable.doctor_image_1));
        items.add(new Doctor_Items("Dr. Ahmed Nasser", "Rheumatologist", "4.6", R.drawable.doctor_image_1));
        items.add(new Doctor_Items("Dr. Sofia Martinez", "Pulmonologist", "4.7", R.drawable.doctor_image_1));

        filter_items.addAll(items);

        Doctor_Adapter adapter = new Doctor_Adapter(requireContext(), filter_items);
        doctor_recycler.setLayoutManager(new LinearLayoutManager(requireContext()));
        doctor_recycler.setAdapter(adapter);

    }

    private void dashboard_function(View v) {

        RelativeLayout see_all_doctor = v.findViewById(R.id.see_all_doctor);
        see_all_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), Patient_List_Doctor.class);
                startActivity(i);
            }
        });

        Button to_health_check = v.findViewById(R.id.health_check_patient_dashboard);
        to_health_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), Patient_HealthCheck.class);
                startActivity(i);
            }
        });

    }
}