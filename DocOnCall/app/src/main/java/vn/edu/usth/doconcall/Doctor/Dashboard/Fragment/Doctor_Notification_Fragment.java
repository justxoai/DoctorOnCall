package vn.edu.usth.doconcall.Doctor.Dashboard.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.doconcall.Doctor.Dashboard.Notification.Doctor_notification_adapter;
import vn.edu.usth.doconcall.Doctor.Dashboard.Notification.Doctor_notification_items;
import vn.edu.usth.doconcall.R;

public class Doctor_Notification_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Layout
        View v = inflater.inflate(R.layout.fragment_doctor__notification_, container, false);

        // Notification Fragment Function
        notification_function(v);

        // Notification recyclerview
        notification_recyclerview(v);

        return v;
    }

    private void notification_recyclerview(View v) {
        RecyclerView notification_recycler = v.findViewById(R.id.doctor_notification_recycler_view);

        List<Doctor_notification_items> items = new ArrayList<Doctor_notification_items>();

        items.add(new Doctor_notification_items("Appointment Reminder", "You have an appointment tomorrow at 10:00 AM."));
        items.add(new Doctor_notification_items("New Message", "Your patient has sent you a new message."));

        Doctor_notification_adapter adapter = new Doctor_notification_adapter(requireContext(), items);
        notification_recycler.setLayoutManager(new LinearLayoutManager(requireContext()));
        notification_recycler.setAdapter(adapter);

    }


    private void notification_function(View v) {
    }
}