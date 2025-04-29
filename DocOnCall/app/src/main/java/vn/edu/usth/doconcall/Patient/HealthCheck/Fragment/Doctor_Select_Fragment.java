package vn.edu.usth.doconcall.Patient.HealthCheck.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.doconcall.Patient.HealthCheck.SelectDoctor.Select_Doctor_Adapter;
import vn.edu.usth.doconcall.Patient.HealthCheck.SelectDoctor.Select_Doctor_Items;
import vn.edu.usth.doconcall.R;

public class Doctor_Select_Fragment extends Fragment {

    private List<Select_Doctor_Items> items;
    private List<Select_Doctor_Items> filteredItems;
    private Select_Doctor_Adapter adapter;

    private SearchView doctorSearch;
    private RecyclerView doctorRecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_doctor__select_, container, false);

        //
        setupRecyclerView(v);

        setupBackButton(v);

        return v;
    }

    private void setupRecyclerView(View v) {
        doctorSearch = v.findViewById(R.id.doctor_searchView_fragment);
        doctorSearch.clearFocus();

        doctorRecycler = v.findViewById(R.id.recycler_view_doctor_fragment);

        // Data
        items = new ArrayList<>();
        filteredItems = new ArrayList<>();

        items.add(new Select_Doctor_Items("Dr. Emily Carter", "Cardiologist", "4.9", R.drawable.doctor_image_1));
        items.add(new Select_Doctor_Items("Dr. James Patel", "Neurologist", "4.8", R.drawable.doctor_image_1));
        items.add(new Select_Doctor_Items("Dr. Olivia Nguyen", "Dermatologist", "4.7", R.drawable.doctor_image_1));
        items.add(new Select_Doctor_Items("Dr. Michael Thompson", "Pediatrician", "4.6", R.drawable.doctor_image_1));
        items.add(new Select_Doctor_Items("Dr. Sarah Lopez", "Orthopedic Surgeon", "4.9", R.drawable.doctor_image_1));
        items.add(new Select_Doctor_Items("Dr. Daniel Kim", "Psychiatrist", "4.8", R.drawable.doctor_image_1));
        items.add(new Select_Doctor_Items("Dr. Aisha Rahman", "Ophthalmologist", "4.5", R.drawable.doctor_image_1));
        items.add(new Select_Doctor_Items("Dr. John Miller", "Gynecologist", "4.6", R.drawable.doctor_image_1));
        items.add(new Select_Doctor_Items("Dr. Priya Sharma", "Oncologist", "4.9", R.drawable.doctor_image_1));
        items.add(new Select_Doctor_Items("Dr. Robert Chen", "General Practitioner", "4.7", R.drawable.doctor_image_1));

        filteredItems.addAll(items);

        adapter = new Select_Doctor_Adapter(requireContext(), filteredItems);
        doctorRecycler.setLayoutManager(new LinearLayoutManager(requireContext()));
        doctorRecycler.setAdapter(adapter);

        doctorSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void setupBackButton(View v) {
        ImageButton backButton = v.findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> requireActivity().getSupportFragmentManager().popBackStack());
    }

    private void filterList(String text) {
        filteredItems.clear();
        for (Select_Doctor_Items item : items) {
            if (item.getName().toLowerCase().contains(text.toLowerCase()) ||
                    item.getSpecialization().toLowerCase().contains(text.toLowerCase())) {
                filteredItems.add(item);
            }
        }

        if (filteredItems.isEmpty()) {
            Toast.makeText(requireContext(), "No results found", Toast.LENGTH_SHORT).show();
        }

        adapter.notifyDataSetChanged();
    }
}
