package vn.edu.usth.intern.project;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import vn.edu.usth.intern.project.Home.Fragment_home_changing;

public class Dashboard extends AppCompatActivity {

    private ViewPager2 mViewPager;
    private BottomNavigationView bottomNavigationView;
    private DrawerLayout mDrawLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout main
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

        // Move to Login Fragment
        navigateToLoginFragment();




    }

    private void navigateToLoginFragment() {
        Fragment loginFragment = new vn.edu.usth.intern.project.Login.LoginFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(android.R.id.content, loginFragment);
        transaction.commit();
    }
}