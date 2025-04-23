package vn.edu.usth.doconcall.Patient.HealthCheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;

import vn.edu.usth.doconcall.Auth.Login_Activity;
import vn.edu.usth.doconcall.Patient.Dashboard.Patient_Dashboard;
import vn.edu.usth.doconcall.Patient.HealthCheck.Fragment.HealthCheck_Fragment;
import vn.edu.usth.doconcall.Patient.HealthCheck.Fragment.Symptoms_Fragment;
import vn.edu.usth.doconcall.Patient.List_Doctor.Patient_List_Doctor;
import vn.edu.usth.doconcall.Patient.Profile.Patient_Profile;
import vn.edu.usth.doconcall.Patient.Schedule.Patient_Schedule;
import vn.edu.usth.doconcall.R;

public class Patient_HealthCheck extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout
        setContentView(R.layout.activity_patient_health_check);

        // Side navigate
        DrawerLayout mDrawLayout = findViewById(R.id.patient_health_check_activity);

        // Function to open Side-menu
        ImageButton mImageView = findViewById(R.id.menu_button);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDrawLayout != null && !mDrawLayout.isDrawerOpen(GravityCompat.END)) {
                    mDrawLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        // Sidebar Function
        side_bar_function();

        // Health Check Function
        health_check_function();
    }

    private void health_check_function() {
        Fragment health_check_fragment = new HealthCheck_Fragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(android.R.id.content, health_check_fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    private void side_bar_function() {
        // Dashboard
        LinearLayout dashboard_page = findViewById(R.id.to_dashboard_page);
        dashboard_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_HealthCheck.this, Patient_Dashboard.class);
                startActivity(i);
                finish();
            }
        });

        // Schedule
        LinearLayout schedule_page = findViewById(R.id.to_schedule_page);
        schedule_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_HealthCheck.this, Patient_Schedule.class);
                startActivity(i);
                finish();
            }
        });

        // Health Check
        LinearLayout health_page = findViewById(R.id.to_health_check_page);
        health_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_HealthCheck.this, Patient_HealthCheck.class);
                startActivity(i);
                finish();
            }
        });

        // List Doctor
        LinearLayout doctor_page = findViewById(R.id.to_doctor_list_page);
        doctor_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_HealthCheck.this, Patient_List_Doctor.class);
                startActivity(i);
                finish();
            }
        });

        // Profile
        LinearLayout profile_page = findViewById(R.id.to_profile_page);
        profile_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_HealthCheck.this, Patient_Profile.class);
                startActivity(i);
                finish();
            }
        });

        // Log out
        LinearLayout log_out = findViewById(R.id.to_log_out);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(Patient_HealthCheck.this, Login_Activity.class);
                startActivity(i);
                finish();
            }
        });
    }

}