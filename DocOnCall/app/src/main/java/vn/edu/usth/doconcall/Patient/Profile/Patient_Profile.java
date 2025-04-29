package vn.edu.usth.doconcall.Patient.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.firebase.auth.FirebaseAuth;

import vn.edu.usth.doconcall.Auth.Login_Activity;
import vn.edu.usth.doconcall.Patient.Dashboard.Patient_Dashboard;
import vn.edu.usth.doconcall.Patient.HealthCheck.Patient_HealthCheck;
import vn.edu.usth.doconcall.Patient.List_Doctor.Patient_List_Doctor;
import vn.edu.usth.doconcall.Patient.Schedule.Patient_Schedule;
import vn.edu.usth.doconcall.R;

public class Patient_Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_patient_profile);

        // Side navigate
        DrawerLayout mDrawLayout = findViewById(R.id.patient_profile_activity);

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

        // SideBar Function
        side_bar_function();

        // Profile Function
        profile_function();

    }

    private void profile_function() {
        Button edit_profile = findViewById(R.id.edit_patient_profile);
        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_Profile.this, Edit_Patient_Profile.class);
                startActivity(i);
                finish();
            }
        });

        Button medical_history = findViewById(R.id.medical_history_patient_profile);
        medical_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_Profile.this, MedicalHistorySurvey_Activity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void side_bar_function(){
        LinearLayout dashboard_page = findViewById(R.id.to_dashboard_page);
        dashboard_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_Profile.this, Patient_Dashboard.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout schedule_page = findViewById(R.id.to_schedule_page);
        schedule_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_Profile.this, Patient_Schedule.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout health_page = findViewById(R.id.to_health_check_page);
        health_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_Profile.this, Patient_HealthCheck.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout doctor_page = findViewById(R.id.to_doctor_list_page);
        doctor_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_Profile.this, Patient_List_Doctor.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout profile_page = findViewById(R.id.to_profile_page);
        profile_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_Profile.this, Patient_Profile.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout log_out = findViewById(R.id.to_log_out);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(Patient_Profile.this, Login_Activity.class);
                startActivity(i);
                finish();
            }
        });
    }
}