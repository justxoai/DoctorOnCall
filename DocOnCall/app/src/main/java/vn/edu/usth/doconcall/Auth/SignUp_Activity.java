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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import vn.edu.usth.doconcall.Patient.Dashboard.Patient_Dashboard;
import vn.edu.usth.doconcall.R;

public class SignUp_Activity extends AppCompatActivity {

    EditText phone_num, password, confirm_password;
    Button sign_up_button;

    boolean valid = true;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout
        setContentView(R.layout.activity_sign_up);

        // Setup Firebase
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        // Setup ID
        phone_num = findViewById(R.id.input_phone_sign_up);
        password = findViewById(R.id.input_password_sign_up);
        confirm_password = findViewById(R.id.input_confirm_pass_sign_up);

        sign_up_button = findViewById(R.id.sign_up_button);

        // Setup UI for Error
        findViewById(R.id.empty_phone_email).setVisibility(View.GONE);
        findViewById(R.id.error_phone_sign_up).setVisibility(View.GONE);

        findViewById(R.id.empty_password).setVisibility(View.GONE);
        findViewById(R.id.error_pass_sign_up).setVisibility(View.GONE);

        findViewById(R.id.error_confirm_pass_sign_up).setVisibility(View.GONE);
        findViewById(R.id.confirm_password_1).setVisibility(View.GONE);
        findViewById(R.id.confirm_password_2).setVisibility(View.GONE);

        // Sign up function
        sign_up_function();
    }

    private void sign_up_function(){
        // Sign up
        ImageButton back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(view -> {
            Intent i = new Intent(SignUp_Activity.this, Login_Activity.class);
            startActivity(i);
            finish();
        });

        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkField();

                if(valid){
                    fAuth.createUserWithEmailAndPassword(phone_num.getText().toString().trim()+"@gmail.com", password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            FirebaseUser fUser =fAuth.getCurrentUser();

                            DocumentReference df =fStore.collection("Patient").document(fUser.getUid());

                            // Store data
                            Map<String, Object> userInformation= new HashMap<>();
                            userInformation.put("PhoneNumber", phone_num.getText().toString());
                            userInformation.put("Password", password.getText().toString());
                            userInformation.put("isPatient", "1");

                            df.set(userInformation);

                            Toast.makeText(SignUp_Activity.this, "Success create Account", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(SignUp_Activity.this, Patient_Dashboard.class);
                            startActivity(i);
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SignUp_Activity.this, "Failed to Create Account", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    private boolean checkField(){
        if(phone_num.getText().toString().isEmpty()){
            findViewById(R.id.empty_phone_email).setVisibility(View.VISIBLE);
            findViewById(R.id.error_phone_sign_up).setVisibility(View.VISIBLE);

            valid = false;
        }else{
            findViewById(R.id.empty_phone_email).setVisibility(View.GONE);
            findViewById(R.id.error_phone_sign_up).setVisibility(View.GONE);

            valid = true;
        }

        if(password.getText().toString().isEmpty()){
            findViewById(R.id.empty_password).setVisibility(View.VISIBLE);
            findViewById(R.id.error_pass_sign_up).setVisibility(View.VISIBLE);

            valid = false;
        }else{
            findViewById(R.id.empty_password).setVisibility(View.GONE);
            findViewById(R.id.error_pass_sign_up).setVisibility(View.GONE);

            valid = true;
        }

        // Dieu Kien cua Matkhau

        if(confirm_password.getText().toString().isEmpty()) {
            findViewById(R.id.error_confirm_pass_sign_up).setVisibility(View.VISIBLE);
            findViewById(R.id.confirm_password_1).setVisibility(View.VISIBLE);

            valid = false;
        }else{
            if(confirm_password.getText().toString().equals(password.getText().toString())){
                findViewById(R.id.error_confirm_pass_sign_up).setVisibility(View.GONE);

                valid = true;
            }else{
                findViewById(R.id.error_confirm_pass_sign_up).setVisibility(View.VISIBLE);
                findViewById(R.id.confirm_password_2).setVisibility(View.VISIBLE);
                findViewById(R.id.confirm_password_1).setVisibility(View.GONE);

                valid = false;
            }
        }

        return valid;
    }
}