package vn.edu.usth.doconcall.Patient.HealthCheck.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import vn.edu.usth.doconcall.Patient.Dashboard.Patient_Dashboard;
import vn.edu.usth.doconcall.Patient.HealthCheck.Patient_HealthCheck;
import vn.edu.usth.doconcall.R;

public class Confirm_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Layout
        View v = inflater.inflate(R.layout.fragment_confirm_, container, false);

        // Get arguments
        Bundle bundle = getArguments();
        if (bundle != null) {
            String doctorName = bundle.getString("Doctor Name");
            String specialization = bundle.getString("Specialization");
            String appointmentType = bundle.getString("Appointment Type");

            // Set data to TextViews
            TextView doctorNameText = v.findViewById(R.id.doctor_name_text);
            TextView doctorSpecText = v.findViewById(R.id.doctor_spec_text);
            TextView appointmentTypeText = v.findViewById(R.id.checkbox_video);

            doctorNameText.setText(doctorName);
            doctorSpecText.setText(specialization);
            appointmentTypeText.setText(appointmentType);
        }

        // Confirm Fragment Function
        confirm_function(v);

        return v;
    }

    private void confirm_function(View v) {
        // Back
        ImageButton back_button = v.findViewById(R.id.back_button);
        back_button.setOnClickListener(view -> {
           requireActivity().getSupportFragmentManager().popBackStack();
        });

        // Continue
        Button continue_button = v.findViewById(R.id.button_Contact);
        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "Appointment successfully booked!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(requireContext(), Patient_Dashboard.class);
                startActivity(i);
            }
        });
    }
}