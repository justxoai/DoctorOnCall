package vn.edu.usth.doconcall.Patient.HealthCheck.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.doconcall.Patient.HealthCheck.Free_Appointment.Free_Appointment_Adapter;
import vn.edu.usth.doconcall.Patient.HealthCheck.Free_Appointment.Free_Appointment_Items;

import vn.edu.usth.doconcall.R;

public class Appointment_Select_Fragment extends Fragment {

    Free_Appointment_Adapter adapter;
    Bundle bundle;

    String selectedType = "";

    CheckBox checkboxAudio, checkboxVideo, checkboxChat, checkboxFace2Face;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Layout
        View v = inflater.inflate(R.layout.fragment_appointment__select_, container, false);

        bundle = new Bundle();

        checkboxAudio = v.findViewById(R.id.checkbox_audio);
        checkboxVideo = v.findViewById(R.id.checkbox_video);
        checkboxChat = v.findViewById(R.id.checkbox_chat);
        checkboxFace2Face = v.findViewById(R.id.checkbox_face2face);

        // Check box coditional:
        checkboxAudio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkboxVideo.setChecked(false);
                    checkboxChat.setChecked(false);
                    checkboxFace2Face.setChecked(false);
                    selectedType = "Audio Call";
                }
            }
        });

        checkboxVideo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkboxAudio.setChecked(false);
                    checkboxChat.setChecked(false);
                    checkboxFace2Face.setChecked(false);
                    selectedType = "Video Call";
                }
            }
        });

        checkboxChat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkboxAudio.setChecked(false);
                    checkboxVideo.setChecked(false);
                    checkboxFace2Face.setChecked(false);
                    selectedType = "Chat";
                }
            }
        });

        checkboxFace2Face.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkboxAudio.setChecked(false);
                    checkboxVideo.setChecked(false);
                    checkboxChat.setChecked(false);
                    selectedType = "Face to Face";
                }
            }
        });

        // Set Doctor Information
        doctor_information_function(v);

        // Appointment Select Fragment Function
        appointment_select_function(v);

        free_appointment_recycler_view(v);

        return v;
    }

    private void free_appointment_recycler_view(View v) {
        RecyclerView recyclerView = v.findViewById(R.id.free_time_recycler_view);

        // Sample data
        List<Free_Appointment_Items> timeList;

        timeList = new ArrayList<Free_Appointment_Items>();

        timeList.add(new Free_Appointment_Items("09:00"));
        timeList.add(new Free_Appointment_Items("10:00"));
        timeList.add(new Free_Appointment_Items("11:00"));
        timeList.add(new Free_Appointment_Items("13:00"));
        timeList.add(new Free_Appointment_Items("14:00"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        adapter = new Free_Appointment_Adapter(requireContext(), timeList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new Free_Appointment_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(String selectedTime) {
                Toast.makeText(getContext(), "Selected Time: " + selectedTime, Toast.LENGTH_SHORT).show();

                bundle.putString("Appointment Time", selectedTime);
            }
        });

    }

    private void doctor_information_function(View v) {
        ImageView imageView = v.findViewById(R.id.doctor_image_information);
        TextView nameView = v.findViewById(R.id.doctor_name_information);
        TextView specView = v.findViewById(R.id.doctor_specialization_information);
        TextView ratingView = v.findViewById(R.id.doctor_rating_information);

        Bundle bundle = getArguments();

        String doctorName = bundle.getString("Doctor Name");
        String specialization = bundle.getString("Doctor Specialization");
        String rating = bundle.getString("Doctor Rating");
        int imageResId = bundle.getInt("Doctor Image");

        nameView.setText(doctorName);
        specView.setText(specialization);
        ratingView.setText(rating);
        imageView.setImageResource(imageResId);
    }

    private void appointment_select_function(View v) {
        // Back
        ImageButton back_button = v.findViewById(R.id.back_button);
        back_button.setOnClickListener(view -> {
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        // Continue
        Button continue_button = v.findViewById(R.id.button_Contact);
        continue_button.setOnClickListener(view -> {

            if (!(checkboxVideo.isChecked() || checkboxAudio.isChecked() || checkboxChat.isChecked() || checkboxFace2Face.isChecked())) {
                Toast.makeText(requireContext(), "Please select Appointment Type", Toast.LENGTH_SHORT).show();
                return;
            }

            // Get doctor name and specialization
            TextView nameView = v.findViewById(R.id.doctor_name_information);
            TextView specView = v.findViewById(R.id.doctor_specialization_information);

            String doctorName = nameView.getText().toString();
            String specialization = specView.getText().toString();

            // Bundle the data
            bundle.putString("Doctor Name", doctorName);
            bundle.putString("Specialization", specialization);
            bundle.putString("Appointment Type", selectedType);

            // Navigate to Confirm_Fragment
            Fragment confirm_fragment = new Confirm_Fragment();
            confirm_fragment.setArguments(bundle);

            FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(android.R.id.content, confirm_fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });
    }
}