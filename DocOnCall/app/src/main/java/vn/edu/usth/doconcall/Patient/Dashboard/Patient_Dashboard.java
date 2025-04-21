package vn.edu.usth.doconcall.Patient.Dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

import vn.edu.usth.doconcall.Auth.Login_Activity;
import vn.edu.usth.doconcall.Patient.Dashboard.Adapter.Patient_Dashboard_Adapter;
import vn.edu.usth.doconcall.Patient.HealthCheck.Patient_HealthCheck;
import vn.edu.usth.doconcall.Patient.List_Doctor.Patient_List_Doctor;
import vn.edu.usth.doconcall.Patient.Profile.Patient_Profile;
import vn.edu.usth.doconcall.Patient.Schedule.Patient_Schedule;
import vn.edu.usth.doconcall.R;

public class Patient_Dashboard extends AppCompatActivity {

    private ViewPager2 mViewPager;
    private BottomNavigationView bottomNavigationView;
    private DrawerLayout mDrawLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout
        setContentView(R.layout.activity_patient_dash_board);
        
        // ViewPager: Change Dashboard and Notification Fragment
        mViewPager = findViewById(R.id.patient_dashboard_view_pager);

        // Bottom Navigator
        bottomNavigationView = findViewById(R.id.patient_dashboard_bottom_navigation);

        Patient_Dashboard_Adapter adapter =new Patient_Dashboard_Adapter(getSupportFragmentManager(), getLifecycle());
        mViewPager.setAdapter(adapter);
        mViewPager.setUserInputEnabled(false);

        // ViewPager2 setup Function
        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                switch (position)
                {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.dashboard_page).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.notification_page).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        // BottomNavigation setup Function
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.dashboard_page) {
                    mViewPager.setCurrentItem(0, true); // Switch to the first fragment
                    return true;
                }
                if (item.getItemId() == R.id.notification_page) {
                    mViewPager.setCurrentItem(1, true); // Switch to the first fragment
                    return true;
                }
                return false;
            }
        });

        // Side navigate
        mDrawLayout = findViewById(R.id.patient_home_activity);

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

        // Dashboard Function
        dashboard_function();
    }

    private void dashboard_function() {
    }

    private void side_bar_function(){
        // Dashboard
        LinearLayout dashboard_page = findViewById(R.id.to_dashboard_page);
        dashboard_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_Dashboard.this, Patient_Dashboard.class);
                startActivity(i);
                finish();
            }
        });

        // Schedule
        LinearLayout schedule_page = findViewById(R.id.to_schedule_page);
        schedule_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_Dashboard.this, Patient_Schedule.class);
                startActivity(i);
                finish();
            }
        });

        // Health Check
        LinearLayout health_page = findViewById(R.id.to_health_check_page);
        health_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_Dashboard.this, Patient_HealthCheck.class);
                startActivity(i);
                finish();
            }
        });

        // List Doctor
        LinearLayout doctor_page = findViewById(R.id.to_doctor_list_page);
        doctor_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_Dashboard.this, Patient_List_Doctor.class);
                startActivity(i);
                finish();
            }
        });

        // Profile
        LinearLayout profile_page = findViewById(R.id.to_profile_page);
        profile_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_Dashboard.this, Patient_Profile.class);
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
                Intent i = new Intent(Patient_Dashboard.this, Login_Activity.class);
                startActivity(i);
                finish();
            }
        });
    }

}