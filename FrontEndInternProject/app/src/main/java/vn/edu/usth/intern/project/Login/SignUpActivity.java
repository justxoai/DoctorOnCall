package vn.edu.usth.intern.project.Login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import vn.edu.usth.intern.project.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);

        // Sign up function
        function();
    }

    private void function(){
        ImageButton back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(view -> {
            onBackPressed();
            finish();
        });

        Button sign_up_button = findViewById(R.id.sign_up_button);
        sign_up_button.setOnClickListener(view -> {
            onBackPressed();
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}