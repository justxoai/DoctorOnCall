package vn.edu.usth.doconcall.DoctorList.Doctor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import vn.edu.usth.doconcall.R;

public class Doctor_ViewHolder extends RecyclerView.ViewHolder {

    TextView doctor_name, doctor_specialization, doctor_rating;

    ImageView doctor_image;

    public  Doctor_ViewHolder(@NonNull View view){
        super(view);
        doctor_name = view.findViewById(R.id.doctor_name);
        doctor_specialization = view.findViewById(R.id.doctor_specialization);
        doctor_rating = view.findViewById(R.id.doctor_rating);
        doctor_image = view.findViewById(R.id.doctor_image);
    }
}
