package vn.edu.usth.doconcall.Patient.Dashboard.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.doconcall.Patient.Dashboard.Notification.Patient_notification_adpater;
import vn.edu.usth.doconcall.Patient.Dashboard.Notification.Patient_notification_item;
import vn.edu.usth.doconcall.R;

public class Patient_Notification_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Layout
        View v = inflater.inflate(R.layout.fragment_patient__notification_, container, false);

        // Notification Fragment Function
        notification_function(v);

        // Notification recyclerview
        notification_recyclerview(v);

        return v;
    }

    private void notification_recyclerview(View v) {
        RecyclerView notification_recycler = v.findViewById(R.id.notification_recycler_view);

        List<Patient_notification_item> items = new ArrayList<Patient_notification_item>();

        items.add(new Patient_notification_item("Appointment Reminder", "You have an appointment tomorrow at 10:00 AM."));
        items.add(new Patient_notification_item("New Message", "Your doctor has sent you a new message."));
        items.add(new Patient_notification_item("Health Tip", "Drink at least 8 glasses of water a day."));
        items.add(new Patient_notification_item("Lab Results Ready", "Your recent lab results are now available."));
        items.add(new Patient_notification_item("Follow-Up Needed", "Please schedule a follow-up appointment with your doctor."));

        Patient_notification_adpater adapter = new Patient_notification_adpater(requireContext(), items);
        notification_recycler.setLayoutManager(new LinearLayoutManager(requireContext()));
        notification_recycler.setAdapter(adapter);

    }

    private void notification_function(View v) {
    }
}