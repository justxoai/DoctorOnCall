package vn.edu.usth.doconcall.Patient.Dashboard.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.doconcall.Patient.List_Doctor.Patient_List_Doctor;
import vn.edu.usth.doconcall.Patient.List_Doctor.RecyclerView.Doctor_Adapter;
import vn.edu.usth.doconcall.Patient.List_Doctor.RecyclerView.Doctor_Items;
import vn.edu.usth.doconcall.R;

public class Patient_Dashboard_Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_patient__dashboard_, container, false);

        // Dashboard Fragment Function
        dashboard_function(v);

        // Setup Doctor RecyclerView
        doctor_recycler_view(v);

        return v;
    }

    private void doctor_recycler_view(View v) {
        RecyclerView doctor_recycler = v.findViewById(R.id.recycler_view_doctor_dashboard);

        List<Doctor_Items> items = new ArrayList<Doctor_Items>();
        List<Doctor_Items> filter_items = new ArrayList<Doctor_Items>();


        items.add(new Doctor_Items("Dr. Hannah Brooks", "Endocrinologist", "4.8", R.drawable.doctor_image_1));
        items.add(new Doctor_Items("Dr. Ahmed Nasser", "Rheumatologist", "4.6", R.drawable.doctor_image_1));
        items.add(new Doctor_Items("Dr. Sofia Martinez", "Pulmonologist", "4.7", R.drawable.doctor_image_1));

        filter_items.addAll(items);

        Doctor_Adapter adapter = new Doctor_Adapter(requireContext(),filter_items);
        doctor_recycler.setLayoutManager(new LinearLayoutManager(requireContext()));
        doctor_recycler.setAdapter(adapter);

    }

    private void dashboard_function(View v) {
//        LinearLayout search_doctor = v.findViewById(R.id.search_view_dashboard);
//        search_doctor.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(requireContext(), List_Doctor_Activity.class);
//                startActivity(i);
//            }
//        });

        RelativeLayout see_all_doctor = v.findViewById(R.id.see_all_doctor);
        see_all_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), Patient_List_Doctor.class);
                startActivity(i);
            }
        });

    }
}