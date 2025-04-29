package vn.edu.usth.doconcall.Doctor.HealthCheck.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.doconcall.Auth.Login_Activity;
import vn.edu.usth.doconcall.Doctor.Dashboard.Doctor_Dashboard;
import vn.edu.usth.doconcall.Doctor.HealthCheck.Doctor_HealthCheck;
import vn.edu.usth.doconcall.Doctor.HealthCheck.List_Patient.Patient_Adapter;
import vn.edu.usth.doconcall.Doctor.HealthCheck.List_Patient.Patient_Item;
import vn.edu.usth.doconcall.Doctor.Profile.Doctor_Profile;
import vn.edu.usth.doconcall.Doctor.Schedule.Doctor_Schedule;
import vn.edu.usth.doconcall.R;

public class Patient_Select_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Layout
        View v =  inflater.inflate(R.layout.fragment_patient__select_, container, false);

        // Side navigate
        DrawerLayout mDrawLayout = v.findViewById(R.id.patient_select_fragment);

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

        // List of Patient Recycler
        list_patient_recycler_view(v);

        // Side bar function
        side_bar_function(v);

        return v;
    }

    private void list_patient_recycler_view(View v) {
        RecyclerView recyclerView = v.findViewById(R.id.list_patient_recycler_view);

        List<Patient_Item> items = new ArrayList<Patient_Item>();

        items.add(new Patient_Item("Alice Nguyen", "Female", "0901234567", "01/01/1990"));
        items.add(new Patient_Item("Brian Tran", "Male", "0934567890", "12/05/1988"));
        items.add(new Patient_Item("Catherine Le", "Female", "0967890123", "23/09/1992"));
        items.add(new Patient_Item("Daniel Pham", "Male", "0971122334", "15/03/1985"));
        items.add(new Patient_Item("Emma Vo", "Female", "0989988776", "30/06/1994"));
        items.add(new Patient_Item("Frank Bui", "Male", "0912345678", "08/11/1987"));
        items.add(new Patient_Item("Grace Hoang", "Female", "0945566778", "19/07/1991"));
        items.add(new Patient_Item("Henry Do", "Male", "0956677889", "04/04/1989"));
        items.add(new Patient_Item("Isabella Truong", "Female", "0933221144", "25/12/1993"));
        items.add(new Patient_Item("Jack Nguyen", "Male", "0908765432", "17/02/1990"));


        Patient_Adapter adapter = new Patient_Adapter(requireContext(), items);
        recyclerView. setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);
    }

    private void side_bar_function(View v){
        // Dashboard
        LinearLayout dashboard_page = v.findViewById(R.id.to_dashboard_page);
        dashboard_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), Doctor_Dashboard.class);
                startActivity(i);
            }
        });

        // Schedule
        LinearLayout schedule_page = v.findViewById(R.id.to_schedule_page);
        schedule_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), Doctor_Schedule.class);
                startActivity(i);
            }
        });

        // Health Check
        LinearLayout health_page = v.findViewById(R.id.to_health_check_page);
        health_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), Doctor_Schedule.class);
                startActivity(i);
            }
        });

        // Profile
        LinearLayout profile_page = v.findViewById(R.id.to_profile_page);
        profile_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), Doctor_Profile.class);
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