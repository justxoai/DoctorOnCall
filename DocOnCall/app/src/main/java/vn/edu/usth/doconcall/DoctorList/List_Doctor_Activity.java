package vn.edu.usth.doconcall.DoctorList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import vn.edu.usth.doconcall.Dashboard_Activity;
import vn.edu.usth.doconcall.DoctorList.Doctor.Doctor_Adapter;
import vn.edu.usth.doconcall.DoctorList.Doctor.Doctor_Items;
import vn.edu.usth.doconcall.HealthCheck.HealthCheck_Activity;
import vn.edu.usth.doconcall.Login.Login_Activity;
import vn.edu.usth.doconcall.Profile.Profile_Activity;
import vn.edu.usth.doconcall.R;
import vn.edu.usth.doconcall.Schedule.Schedule_Activity;
import vn.edu.usth.doconcall.Setting.Setting_Activity;

public class List_Doctor_Activity extends AppCompatActivity {

    private List<Doctor_Items> filter_items;
    private List<Doctor_Items> items;

    private SearchView doctor_search;
    private RecyclerView doctor_recycler;

    private Doctor_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_doctor);

        // Setup RecyclerView
        doctor_search = findViewById(R.id.doctor_searchView);
        doctor_search.clearFocus();

        doctor_recycler = findViewById(R.id.recycler_view_doctor);

        items = new ArrayList<Doctor_Items>();
        filter_items = new ArrayList<Doctor_Items>();

        items.add(new Doctor_Items("Dr. Emily Carter", "Cardiologist", "4.9"));
        items.add(new Doctor_Items("Dr. James Patel", "Neurologist", "4.8"));
        items.add(new Doctor_Items("Dr. Olivia Nguyen", "Dermatologist", "4.7"));
        items.add(new Doctor_Items("Dr. Michael Thompson", "Pediatrician", "4.6"));
        items.add(new Doctor_Items("Dr. Sarah Lopez", "Orthopedic Surgeon", "4.9"));
        items.add(new Doctor_Items("Dr. Daniel Kim", "Psychiatrist", "4.8"));
        items.add(new Doctor_Items("Dr. Aisha Rahman", "Ophthalmologist", "4.5"));
        items.add(new Doctor_Items("Dr. John Miller", "Gynecologist", "4.6"));
        items.add(new Doctor_Items("Dr. Priya Sharma", "Oncologist", "4.9"));
        items.add(new Doctor_Items("Dr. Robert Chen", "General Practitioner", "4.7"));

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


        // Sidebar function
        side_bar_function();
    }

    private void side_bar_function(){
        LinearLayout dashboard_page = findViewById(R.id.to_dashboard_page);
        dashboard_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(List_Doctor_Activity.this, Dashboard_Activity.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout schedule_page = findViewById(R.id.to_schedule_page);
        schedule_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(List_Doctor_Activity.this, Schedule_Activity.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout health_page = findViewById(R.id.to_health_check_page);
        health_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(List_Doctor_Activity.this, HealthCheck_Activity.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout doctor_page = findViewById(R.id.to_doctor_list_page);
        doctor_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(List_Doctor_Activity.this, List_Doctor_Activity.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout profile_page = findViewById(R.id.to_profile_page);
        profile_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(List_Doctor_Activity.this, Profile_Activity.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout setting_page = findViewById(R.id.to_setting_page);
        setting_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(List_Doctor_Activity.this, Setting_Activity.class);
                startActivity(i);
                finish();
            }
        });

        LinearLayout log_out = findViewById(R.id.to_log_out);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(List_Doctor_Activity.this, Login_Activity.class);
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