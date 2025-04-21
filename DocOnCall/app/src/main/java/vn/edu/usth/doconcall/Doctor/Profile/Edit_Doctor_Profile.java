package vn.edu.usth.doconcall.Doctor.Profile;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import vn.edu.usth.doconcall.R;

public class Edit_Doctor_Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout
        setContentView(R.layout.activity_edit_doctor);

        // Edit Profile Function
        edit_profile_function();
    }

    private void edit_profile_function() {

    }
}