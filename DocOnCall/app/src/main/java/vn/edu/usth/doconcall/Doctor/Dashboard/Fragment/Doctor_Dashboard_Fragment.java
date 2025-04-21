package vn.edu.usth.doconcall.Doctor.Dashboard.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import vn.edu.usth.doconcall.R;

public class Doctor_Dashboard_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Layout
        View v = inflater.inflate(R.layout.fragment_doctor__dashboard_, container, false);

        // Dashboard Fragment Function
        dash_board_function(v);

        return v;
    }

    private void dash_board_function(View v) {

    }
}