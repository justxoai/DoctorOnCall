package vn.edu.usth.doconcall.Doctor.Dashboard.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.usth.doconcall.R;

public class Doctor_Notification_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Layout
        View v = inflater.inflate(R.layout.fragment_doctor__notification_, container, false);

        // Notification Fragment Function
        notification_function(v);

        return v;
    }

    private void notification_function(View v) {
    }
}