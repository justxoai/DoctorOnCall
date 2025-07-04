package vn.edu.usth.doconcall.Patient.HealthCheck.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.doconcall.Patient.HealthCheck.Specialization.SpecializationAdapter;
import vn.edu.usth.doconcall.Patient.HealthCheck.Specialization.SpecializationItems;
import vn.edu.usth.doconcall.R;

public class Specialization_Select_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_specialization__select_, container, false);

        // Specialization RecyclerView Function
        setupRecyclerView(v);

        // Button Function
        setupBackButton(v);

        return v;
    }

    private void setupBackButton(View v) {
        ImageButton backButton = v.findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> requireActivity().getSupportFragmentManager().popBackStack());
    }

    private void setupRecyclerView(View v) {
        RecyclerView specialization = v.findViewById(R.id.recycler_view_specialization_fragment);

        List<SpecializationItems> items = new ArrayList<>();

        items.add(new SpecializationItems("General Internal Medicine"));
        items.add(new SpecializationItems("Family Medicine"));
        items.add(new SpecializationItems("Cardiology"));
        items.add(new SpecializationItems("Pulmonology"));
        items.add(new SpecializationItems("Endocrinology"));
        items.add(new SpecializationItems("Gastroenterology"));
        items.add(new SpecializationItems("Nephrology"));
        items.add(new SpecializationItems("Rheumatology"));
        items.add(new SpecializationItems("Hematology"));
        items.add(new SpecializationItems("Infectious Diseases"));
        items.add(new SpecializationItems("Oncology"));
        items.add(new SpecializationItems("Neurology"));
        items.add(new SpecializationItems("Psychiatry"));
        items.add(new SpecializationItems("Dermatology"));
        items.add(new SpecializationItems("Orthopedic Surgery"));
        items.add(new SpecializationItems("Obstetrics and Gynecology"));
        items.add(new SpecializationItems("Pediatrics"));
        items.add(new SpecializationItems("Urology"));
        items.add(new SpecializationItems("Ophthalmology"));
        items.add(new SpecializationItems("Otolaryngology"));
        items.add(new SpecializationItems("Allergy and Immunology"));
        items.add(new SpecializationItems("Physical Medicine and Rehabilitation"));
        items.add(new SpecializationItems("Pain Medicine"));

        SpecializationAdapter adapter = new SpecializationAdapter(requireContext(), items);

        specialization.setAdapter(adapter);
        specialization.setLayoutManager(new LinearLayoutManager(requireContext()));
    }
}