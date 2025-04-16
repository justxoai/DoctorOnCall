package vn.edu.usth.doconcall.DoctorList;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import vn.edu.usth.doconcall.R;

public class Doctor_Information_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_doctor_information);

        // Setup Text
        put_extra_function();

        // Setup function
        doctor_information_function();
    }

    private void put_extra_function() {
        String doctor_set_name = getIntent().getStringExtra("Doctor Name");
        String doctor_set_specialization = getIntent().getStringExtra("Doctor Specialization");
        String doctor_set_rating = getIntent().getStringExtra("Doctor Rating");
        int doctor_set_image = getIntent().getIntExtra("Doctor Image", R.drawable.doctor_list);

        TextView doctor_name = findViewById(R.id.doctor_name_information);
        doctor_name.setText(doctor_set_name);

        TextView doctor_name_header = findViewById(R.id.doctor_name_header_information);
        doctor_name_header.setText(doctor_set_name);

        TextView doctor_speci = findViewById(R.id.doctor_specialization_information);
        doctor_speci.setText(doctor_set_specialization);

        TextView doctor_rating = findViewById(R.id.doctor_rating_information);
        doctor_rating.setText(doctor_set_rating);

        ImageView doctor_image = findViewById(R.id.doctor_image_information);
        doctor_image.setImageResource(doctor_set_image);


    }

    private void doctor_information_function() {
        ImageButton back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(view -> {
            onBackPressed();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}