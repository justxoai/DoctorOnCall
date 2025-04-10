package vn.edu.usth.intern.project.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.usth.intern.project.R;

public class Dashboard_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Dashboard Fragment
        View v = inflater.inflate(R.layout.fragment_dashboard_, container, false);

        return v;
    }
}