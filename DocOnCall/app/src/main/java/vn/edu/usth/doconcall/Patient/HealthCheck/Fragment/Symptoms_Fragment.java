package vn.edu.usth.doconcall.Patient.HealthCheck.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import vn.edu.usth.doconcall.R;

public class Symptoms_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Layout
        View v = inflater.inflate(R.layout.fragment_symptoms_, container, false);

        // Symptoms Fragment
        symptoms_function(v);

        return v;
    }

    private void symptoms_function(View v) {
        // Back
        ImageButton back_button = v.findViewById(R.id.back_button);
        back_button.setOnClickListener(view -> {
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        // Skip
        Button skip_button = v.findViewById(R.id.btn_skip);
        skip_button.setOnClickListener(view -> {
            Fragment doctor_select = new Doctor_Select_Fragment();
            FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(android.R.id.content, doctor_select);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        // Continue
        Button continue_button = v.findViewById(R.id.btn_continue);
        continue_button.setOnClickListener(view -> {
            Fragment doctor_select = new Doctor_Select_Fragment();
            FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(android.R.id.content, doctor_select);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });
    }

}