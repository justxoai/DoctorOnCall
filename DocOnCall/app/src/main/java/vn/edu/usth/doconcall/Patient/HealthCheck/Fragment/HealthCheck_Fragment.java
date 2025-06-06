package vn.edu.usth.doconcall.Patient.HealthCheck.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

import vn.edu.usth.doconcall.Auth.Login_Activity;
import vn.edu.usth.doconcall.Patient.Dashboard.Patient_Dashboard;
import vn.edu.usth.doconcall.Patient.HealthCheck.Patient_HealthCheck;
import vn.edu.usth.doconcall.Patient.List_Doctor.Patient_List_Doctor;
import vn.edu.usth.doconcall.Patient.Profile.Patient_Profile;
import vn.edu.usth.doconcall.Patient.Schedule.Patient_Schedule;
import vn.edu.usth.doconcall.R;

public class HealthCheck_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Layout
        View v = inflater.inflate(R.layout.fragment_health_check_, container, false);

        // Side navigate
        DrawerLayout mDrawLayout = v.findViewById(R.id.health_check_fragment);

        // Function to open Side-menu
        ImageButton mImageView = v.findViewById(R.id.menu_button);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDrawLayout != null && !mDrawLayout.isDrawerOpen(GravityCompat.END)) {
                    mDrawLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        // Side Bar Function
        side_bar_function(v);

        // Health Check Fragment Function
        health_check_function(v);

        return v;
    }

    private void health_check_function(View v) {
        // Start Symptoms survey
        Button start_survey = v.findViewById(R.id.start_health_check_button);
        start_survey.setOnClickListener(view -> {
            Fragment doctor_select = new Doctor_Select_Fragment();
            FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(android.R.id.content, doctor_select);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

    }

    private void side_bar_function(View v) {
        // Dashboard
        LinearLayout dashboard_page = v.findViewById(R.id.to_dashboard_page);
        dashboard_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), Patient_Dashboard.class);
                startActivity(i);

            }
        });

        // Schedule
        LinearLayout schedule_page = v.findViewById(R.id.to_schedule_page);
        schedule_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), Patient_Schedule.class);
                startActivity(i);

            }
        });

        // Health Check
        LinearLayout health_page = v.findViewById(R.id.to_health_check_page);
        health_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), Patient_HealthCheck.class);
                startActivity(i);

            }
        });

        // List Doctor
        LinearLayout doctor_page = v.findViewById(R.id.to_doctor_list_page);
        doctor_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), Patient_List_Doctor.class);
                startActivity(i);

            }
        });

        // Profile
        LinearLayout profile_page = v.findViewById(R.id.to_profile_page);
        profile_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), Patient_Profile.class);
                startActivity(i);

            }
        });

        // Log out
        LinearLayout log_out = v.findViewById(R.id.to_log_out);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(requireContext(), Login_Activity.class);
                startActivity(i);
            }
        });
    }

}