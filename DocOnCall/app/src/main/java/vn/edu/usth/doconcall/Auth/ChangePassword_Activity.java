package vn.edu.usth.doconcall.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import vn.edu.usth.doconcall.R;

public class ChangePassword_Activity extends AppCompatActivity {

    EditText phone_num, new_pass, confirm_pass;
    Button confirm_button;

    boolean valid = true;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout
        setContentView(R.layout.activity_change_password);

        // Setup Firebase
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        // Setup ID
        phone_num = findViewById(R.id.input_phone_change_pass);
        new_pass = findViewById(R.id.input_new_pass_change_pass);
        confirm_pass = findViewById(R.id.input_confirm_new_pass_change_pass);

        confirm_button = findViewById(R.id.confirm_button);

        // Setup UI for Error
        findViewById(R.id.empty_phone_change_pass).setVisibility(View.GONE);
        findViewById(R.id.error_phone_change_pass).setVisibility(View.GONE);

        findViewById(R.id.empty_password_change_pass).setVisibility(View.GONE);
        findViewById(R.id.error_pass_change_pass).setVisibility(View.GONE);

        findViewById(R.id.error_confirm_pass_change_pass).setVisibility(View.GONE);
        findViewById(R.id.confirm_password_change_pass).setVisibility(View.GONE);

        findViewById(R.id.confirm_password_change_pass_2).setVisibility(View.GONE);

        // Change Password function
        change_password_function();
    }

    private void change_password_function(){
        // Backward button
        ImageButton back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(view -> {
            Intent i = new Intent(ChangePassword_Activity.this, Login_Activity.class);
            startActivity(i);
            finish();
        });

        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkField();

                if(valid){
                    fStore.collection("Patient").whereEqualTo("PhoneNumber", phone_num.getText().toString()).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            FirebaseUser fUser = fAuth.getCurrentUser();

                            // Chưa update đc password
                            fUser.updatePassword(confirm_pass.getText().toString());

                            Intent i = new Intent(ChangePassword_Activity.this, Login_Activity.class);
                            startActivity(i);
                            finish();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ChangePassword_Activity.this, "Incorrect Phone Number", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    private boolean checkField(){
        if(phone_num.getText().toString().isEmpty()){
            findViewById(R.id.empty_phone_change_pass).setVisibility(View.VISIBLE);
            findViewById(R.id.error_phone_change_pass).setVisibility(View.VISIBLE);

            valid = false;
        }else{
            findViewById(R.id.empty_phone_change_pass).setVisibility(View.GONE);
            findViewById(R.id.error_phone_change_pass).setVisibility(View.GONE);

            valid = true;
        }

        if(new_pass.getText().toString().isEmpty()){
            findViewById(R.id.empty_password_change_pass).setVisibility(View.VISIBLE);
            findViewById(R.id.error_pass_change_pass).setVisibility(View.VISIBLE);

            valid = false;
        }else{
            findViewById(R.id.empty_password_change_pass).setVisibility(View.GONE);
            findViewById(R.id.error_pass_change_pass).setVisibility(View.GONE);

            valid = true;
        }

        // Dieu Kien cua Matkhau

        if(confirm_pass.getText().toString().isEmpty()) {
            findViewById(R.id.error_confirm_pass_change_pass).setVisibility(View.VISIBLE);
            findViewById(R.id.confirm_password_change_pass).setVisibility(View.VISIBLE);

            valid = false;
        }else{
            if(confirm_pass.getText().toString().equals(new_pass.getText().toString())){
                findViewById(R.id.error_confirm_pass_change_pass).setVisibility(View.GONE);

                valid = true;
            }else{
                findViewById(R.id.error_confirm_pass_change_pass).setVisibility(View.VISIBLE);
                findViewById(R.id.confirm_password_change_pass_2).setVisibility(View.VISIBLE);
                findViewById(R.id.confirm_password_change_pass).setVisibility(View.GONE);

                valid = false;
            }
        }

        return valid;
    }


}