package vn.edu.usth.doconcall.Patient.List_Doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.doconcall.Auth.Login_Activity;
import vn.edu.usth.doconcall.Patient.Dashboard.Patient_Dashboard;
import vn.edu.usth.doconcall.Patient.HealthCheck.Patient_HealthCheck;
import vn.edu.usth.doconcall.Patient.List_Doctor.RecyclerView.Doctor_Adapter;
import vn.edu.usth.doconcall.Patient.List_Doctor.RecyclerView.Doctor_Items;
import vn.edu.usth.doconcall.Patient.Profile.Patient_Profile;
import vn.edu.usth.doconcall.Patient.Schedule.Patient_Schedule;
import vn.edu.usth.doconcall.R;

public class Patient_List_Doctor extends AppCompatActivity {

    private List<Doctor_Items> filter_items;
    private List<Doctor_Items> items;

    private SearchView doctor_search;
    private RecyclerView doctor_recycler;

    private Doctor_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_patient_list_doctor);

        // Side navigate
        DrawerLayout mDrawLayout = findViewById(R.id.patient_list_doctor_activity);

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

        // Setup RecyclerView and SearchView
        doctor_recycler_and_search_view_function();

        // Sidebar function
        side_bar_function();

    }

    private void doctor_recycler_and_search_view_function() {
        doctor_search = findViewById(R.id.doctor_searchView);
        doctor_search.clearFocus();

        doctor_recycler = findViewById(R.id.recycler_view_doctor);

        items = new ArrayList<Doctor_Items>();
        filter_items = new ArrayList<Doctor_Items>();

        items.add(new Doctor_Items("Dr. Emily Carter", "Cardiologist", "4.9",R.drawable.doctor_image_1));
        items.add(new Doctor_Items("Dr. James Patel", "Neurologist", "4.8", R.drawable.doctor_image_1));
        items.add(new Doctor_Items("Dr. Olivia Nguyen", "Dermatologist", "4.7", R.drawable.doctor_image_1));
        items.add(new Doctor_Items("Dr. Michael Thompson", "Pediatrician", "4.6", R.drawable.doctor_image_1));
        items.add(new Doctor_Items("Dr. Sarah Lopez", "Orthopedic Surgeon", "4.9", R.drawable.doctor_image_1));
        items.add(new Doctor_Items("Dr. Daniel Kim", "Psychiatrist", "4.8", R.drawable.doctor_image_1));
        items.add(new Doctor_Items("Dr. Aisha Rahman", "Ophthalmologist", "4.5", R.drawable.doctor_image_1));
        items.add(new Doctor_Items("Dr. John Miller", "Gynecologist", "4.6", R.drawable.doctor_image_1));
        items.add(new Doctor_Items("Dr. Priya Sharma", "Oncologist", "4.9", R.drawable.doctor_image_1));
        items.add(new Doctor_Items("Dr. Robert Chen", "General Practitioner", "4.7", R.drawable.doctor_image_1));

        filter_items.addAll(items);

        adapter = new Doctor_Adapter(this, filter_items);
        doctor_recycler.setLayoutManager(new LinearLayoutManager(this));
        doctor_recycler.setAdapter(adapter);

        doctor_search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);
                return false;
            }
        });
    }

    private void side_bar_function(){
        LinearLayout dashboard_page = findViewById(R.id.to_dashboard_page);
        dashboard_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_List_Doctor.this, Patient_Dashboard.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout schedule_page = findViewById(R.id.to_schedule_page);
        schedule_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_List_Doctor.this, Patient_Schedule.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout health_page = findViewById(R.id.to_health_check_page);
        health_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_List_Doctor.this, Patient_HealthCheck.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout doctor_page = findViewById(R.id.to_doctor_list_page);
        doctor_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_List_Doctor.this, Patient_List_Doctor.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout profile_page = findViewById(R.id.to_profile_page);
        profile_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_List_Doctor.this, Patient_Profile.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout log_out = findViewById(R.id.to_log_out);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(Patient_List_Doctor.this, Login_Activity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void filterList(String text) {
        filter_items.clear();
        for (Doctor_Items item : items) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filter_items.add(item);
            }
        }

        if (filter_items.isEmpty()) {
            Toast.makeText(this, "No results found", Toast.LENGTH_SHORT).show();
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
    
}