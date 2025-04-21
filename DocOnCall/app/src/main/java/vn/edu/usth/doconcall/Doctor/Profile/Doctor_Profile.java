package vn.edu.usth.doconcall.Doctor.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.firebase.auth.FirebaseAuth;

import vn.edu.usth.doconcall.Doctor.Dashboard.Doctor_Dashboard;
import vn.edu.usth.doconcall.Doctor.HealthCheck.Doctor_HealthCheck;
import vn.edu.usth.doconcall.Auth.Login_Activity;
import vn.edu.usth.doconcall.Doctor.Schedule.Doctor_Schedule;
import vn.edu.usth.doconcall.R;

public class Doctor_Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_doctor_profile);

        // Side navigate
        DrawerLayout mDrawLayout = findViewById(R.id.doctor_profile_activity);

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

        // Other Function
        profile_function();
    }

    private void profile_function() {

    }

    private void side_bar_function(){
        // Dashboard
        LinearLayout dashboard_page = findViewById(R.id.to_dashboard_page);
        dashboard_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Doctor_Profile.this, Doctor_Dashboard.class);
                startActivity(i);
                finish();
            }
        });

        // Schedule
        LinearLayout schedule_page = findViewById(R.id.to_schedule_page);
        schedule_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Doctor_Profile.this, Doctor_Schedule.class);
                startActivity(i);
                finish();
            }
        });

        // Health Check
        LinearLayout health_page = findViewById(R.id.to_health_check_page);
        health_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Doctor_Profile.this, Doctor_HealthCheck.class);
                startActivity(i);
                finish();
            }
        });

        // Profile
        LinearLayout profile_page = findViewById(R.id.to_profile_page);
        profile_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Doctor_Profile.this, Doctor_Profile.class);
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
                Intent i = new Intent(Doctor_Profile.this, Login_Activity.class);
                startActivity(i);
                finish();
            }
        });
    }
}