package vn.edu.usth.doconcall.Patient.HealthCheck.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import vn.edu.usth.doconcall.R;

public class Appointment_Select_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Layout
        View v = inflater.inflate(R.layout.fragment_appointment__select_, container, false);

        // Set Doctor Information
        doctor_information_function(v);

        // Appointment Select Fragment Function
        appointment_select_function(v);

        return v;
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
            // Get selected checkbox
            CheckBox checkboxAudio = v.findViewById(R.id.checkbox_audio);
            CheckBox checkboxVideo = v.findViewById(R.id.checkbox_video);
            CheckBox checkboxChat = v.findViewById(R.id.checkbox_chat);
            CheckBox checkboxFace2Face = v.findViewById(R.id.checkbox_face2face);

            // Set listener to ensure only one checkbox can be selected at a time
            CompoundButton.OnCheckedChangeListener singleSelectListener = new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        // Uncheck all other checkboxes when one is checked
                        if (buttonView != checkboxAudio) checkboxAudio.setChecked(false);
                        if (buttonView != checkboxVideo) checkboxVideo.setChecked(false);
                        if (buttonView != checkboxChat) checkboxChat.setChecked(false);
                        if (buttonView != checkboxFace2Face) checkboxFace2Face.setChecked(false);
                    }
                }
            };

            // Set listeners for all checkboxes
            checkboxAudio.setOnCheckedChangeListener(singleSelectListener);
            checkboxVideo.setOnCheckedChangeListener(singleSelectListener);
            checkboxChat.setOnCheckedChangeListener(singleSelectListener);
            checkboxFace2Face.setOnCheckedChangeListener(singleSelectListener);

            // String variable to hold the selected type
            String selectedType = "";

            // Check which checkbox is selected
            if (checkboxAudio.isChecked()) {
                selectedType = "Audio Call";
            } else if (checkboxVideo.isChecked()) {
                selectedType = "Video Call";
            } else if (checkboxChat.isChecked()) {
                selectedType = "Chatting";
            } else if (checkboxFace2Face.isChecked()) {
                selectedType = "Face to Face";
            }

            // Get doctor name and specialization
            TextView nameView = v.findViewById(R.id.doctor_name_information);
            TextView specView = v.findViewById(R.id.doctor_specialization_information);

            String doctorName = nameView.getText().toString();
            String specialization = specView.getText().toString();

            // Bundle the data
            Bundle bundle = new Bundle();
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