package vn.edu.usth.doconcall.Doctor.HealthCheck.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import vn.edu.usth.doconcall.R;

public class Patient_Information_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Layout
        View v = inflater.inflate(R.layout.fragment_patient__information_, container, false);

        // Set information
        set_patient_information(v);

        // Button Function
        patient_information_function(v);
        
        return v;
    }

    private void patient_information_function(View v) {
        // Back
        ImageButton back_button = v.findViewById(R.id.back_button);
        back_button.setOnClickListener(view -> {
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        // Contact
        Button contact_button = v.findViewById(R.id.button_Contact);
    }

    private void set_patient_information(View v) {
        // Find views
        TextView nameView = v.findViewById(R.id.patient_information_name);
        TextView genderView = v.findViewById(R.id.patient_information_gender);
        TextView phoneView = v.findViewById(R.id.patient_information_phone);
        TextView dob = v.findViewById(R.id.patient_information_dob);

        // Get data from bundle
        Bundle bundle = getArguments();
        if (bundle != null) {
            String patientName = bundle.getString("Patient Name", "N/A");
            String patientGender = bundle.getString("Patient Gender", "N/A");
            String patientPhone = bundle.getString("Patient Phone Number", "N/A");
            String patientDob = bundle.getString("Patient Dob", "N/A");

            // Set to views
            nameView.setText("Name: " + patientName);
            genderView.setText("Gender: " + patientGender);
            phoneView.setText("Phone Number: " + patientPhone);
            dob.setText("Dob: "+ patientDob);
        }

    }

}