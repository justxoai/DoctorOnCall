package vn.edu.usth.doconcall;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

import vn.edu.usth.doconcall.DoctorList.List_Doctor_Activity;
import vn.edu.usth.doconcall.HealthCheck.HealthCheck_Activity;
import vn.edu.usth.doconcall.Home.Fragment_home_changing;
import vn.edu.usth.doconcall.Login.Login_Activity;
import vn.edu.usth.doconcall.Profile.Profile_Activity;
import vn.edu.usth.doconcall.Schedule.Schedule_Activity;
import vn.edu.usth.doconcall.Setting.Setting_Activity;

public class Dashboard_Activity extends AppCompatActivity {

    private ViewPager2 mViewPager;
    private BottomNavigationView bottomNavigationView;
    private DrawerLayout mDrawLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout: activity_main
        setContentView(R.layout.activity_main);

        // ViewPager: Change Dashboard and Notification Fragment
        mViewPager = findViewById(R.id.dashboard_view_pager);

        // Bottom Navigator
        bottomNavigationView = findViewById(R.id.dashboard_bottom_navigation);

        Fragment_home_changing adapter =new Fragment_home_changing(getSupportFragmentManager(), getLifecycle());
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
        mDrawLayout = findViewById(R.id.home_activity);

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

        // Sidebar function
        side_bar_function();
    }

    private void side_bar_function(){
        LinearLayout dashboard_page = findViewById(R.id.to_dashboard_page);
        dashboard_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard_Activity.this, Dashboard_Activity.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout schedule_page = findViewById(R.id.to_schedule_page);
        schedule_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard_Activity.this, Schedule_Activity.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout health_page = findViewById(R.id.to_health_check_page);
        health_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard_Activity.this, HealthCheck_Activity.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout doctor_page = findViewById(R.id.to_doctor_list_page);
        doctor_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard_Activity.this, List_Doctor_Activity.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout profile_page = findViewById(R.id.to_profile_page);
        profile_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard_Activity.this, Profile_Activity.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout setting_page = findViewById(R.id.to_setting_page);
        setting_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard_Activity.this, Setting_Activity.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout log_out = findViewById(R.id.to_log_out);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(Dashboard_Activity.this, Login_Activity.class);
                startActivity(i);
                finish();
            }
        });
    }
}