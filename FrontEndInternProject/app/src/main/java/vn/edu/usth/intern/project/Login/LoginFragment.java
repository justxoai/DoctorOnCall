package vn.edu.usth.intern.project.Login;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import vn.edu.usth.intern.project.Dashboard;
import vn.edu.usth.intern.project.R;

public class LoginFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        // Visible and Gone
        v.findViewById(R.id.loading_layout).setVisibility(v.VISIBLE);
        v.findViewById(R.id.header_login).setVisibility(v.GONE);
        v.findViewById(R.id.login_layout).setVisibility(v.GONE);

        // Setup Delay Loading
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.findViewById(R.id.loading_layout).setVisibility(v.GONE);
                v.findViewById(R.id.header_login).setVisibility(v.VISIBLE);
                v.findViewById(R.id.login_layout).setVisibility(v.VISIBLE);
            }
        }, 5000);

        // Share Preference

        // Login Function
        function(v);

        return v;
    }

    private void function(View v){
        TextView forgot_pass = v.findViewById(R.id.forgot_password);
        forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), ChangePasswordActivity.class);
                startActivity(i);
            }
        });

        TextView sign_up = v.findViewById(R.id.sign_up);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), SignUpActivity.class);
                startActivity(i);
            }
        });

        Button login_button = v.findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), Dashboard.class);
                startActivity(i);
            }
        });
    }
}