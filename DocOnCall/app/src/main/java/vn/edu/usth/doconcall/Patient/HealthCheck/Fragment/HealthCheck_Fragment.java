package vn.edu.usth.doconcall.Patient.HealthCheck.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vn.edu.usth.doconcall.R;

public class HealthCheck_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Layout
        View v = inflater.inflate(R.layout.fragment_health_check_, container, false);

        // Health Check Fragment Function
        health_check_function(v);

        return v;
    }

    private void health_check_function(View v) {
        // Start Symptoms survey
        Button start_survey = v.findViewById(R.id.start_health_check_button);
        start_survey.setOnClickListener(view -> {
            Fragment symptoms_fragment = new Symptoms_Fragment();
            FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(android.R.id.content, symptoms_fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });


    }
}