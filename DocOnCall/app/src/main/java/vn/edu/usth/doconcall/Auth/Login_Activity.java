package vn.edu.usth.doconcall.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import vn.edu.usth.doconcall.Doctor.Dashboard.Doctor_Dashboard;
import vn.edu.usth.doconcall.Patient.Dashboard.Patient_Dashboard;
import vn.edu.usth.doconcall.R;

public class Login_Activity extends AppCompatActivity {

    EditText phone_num, password;
    Button login_button;

    boolean valid = true;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout
        setContentView(R.layout.activity_login);

        // Setup Firebase
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        // Setup ID
        phone_num = findViewById(R.id.input_phone_num_log_in);
        password = findViewById(R.id.input_pass_log_in);

        login_button = findViewById(R.id.login_button);

        // Setup UI for Error
        findViewById(R.id.loading_layout).setVisibility(View.VISIBLE);
        findViewById(R.id.header_login).setVisibility(View.GONE);
        findViewById(R.id.login_layout).setVisibility(View.GONE);

        findViewById(R.id.empty_phone_email).setVisibility(View.GONE);
        findViewById(R.id.error_phone_log_in).setVisibility(View.GONE);

        findViewById(R.id.empty_password).setVisibility(View.GONE);
        findViewById(R.id.error_pass_log_in).setVisibility(View.GONE);

        // Setup Delay Loading
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.loading_layout).setVisibility(View.GONE);
                findViewById(R.id.header_login).setVisibility(View.VISIBLE);
                findViewById(R.id.login_layout).setVisibility(View.VISIBLE);
            }
        }, 3000);

        // Login Function
        login_function();
    }

    private void login_function(){
        // Change password
        TextView forgot_pass = findViewById(R.id.forgot_password);
        forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login_Activity.this, ChangePassword_Activity.class);
                startActivity(i);
                finish();
            }
        });

        // Sign up
        TextView sign_up = findViewById(R.id.sign_up);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login_Activity.this, SignUp_Activity.class);
                startActivity(i);
                finish();
            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkField();

                if(valid){
                    fAuth.signInWithEmailAndPassword(phone_num.getText().toString().trim() + "@gmail.com", password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(Login_Activity.this, "Login Success", Toast.LENGTH_SHORT).show();
                            checkIfAdmin(authResult.getUser().getUid());
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Login_Activity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    private boolean checkField(){
        if(phone_num.getText().toString().isEmpty()){
            findViewById(R.id.empty_phone_email).setVisibility(View.VISIBLE);
            findViewById(R.id.error_phone_log_in).setVisibility(View.VISIBLE);

            valid = false;
        }else{
            findViewById(R.id.empty_phone_email).setVisibility(View.GONE);
            findViewById(R.id.error_phone_log_in).setVisibility(View.GONE);

            valid = true;
        }

        if(password.getText().toString().isEmpty()){
            findViewById(R.id.empty_password).setVisibility(View.VISIBLE);
            findViewById(R.id.error_pass_log_in).setVisibility(View.VISIBLE);

            valid = false;
        }else{
            findViewById(R.id.empty_password).setVisibility(View.GONE);
            findViewById(R.id.error_pass_log_in).setVisibility(View.GONE);

            valid = true;
        }

        return valid;
    }

    // Check if Doctor or Patient
    private void checkIfAdmin(String uid) {
        DocumentReference df = fStore.collection("Patient").document(uid);
        // Extract data from document
        df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Log.d("TAG", "onSuccess" + documentSnapshot.getData());
                // Identify user
                if(documentSnapshot.getString("isDoctor") != null){
                    // User is admin
                    startActivity(new Intent(getApplicationContext(), Doctor_Dashboard.class));
                    finish();
                }
                if (documentSnapshot.getString("isPatient") != null){
                    startActivity(new Intent(getApplicationContext(), Patient_Dashboard.class));
                    finish();
                }
            }
        });
    }

}