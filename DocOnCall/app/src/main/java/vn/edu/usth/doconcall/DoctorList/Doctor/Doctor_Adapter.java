package vn.edu.usth.doconcall.DoctorList.Doctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.usth.doconcall.R;

public class Doctor_Adapter extends RecyclerView.Adapter<Doctor_ViewHolder> {

    Context context;
    List<Doctor_Items> items;

    public Doctor_Adapter(Context context, List<Doctor_Items> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public Doctor_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Doctor_ViewHolder(LayoutInflater.from(context).inflate(R.layout.frame_list_doctor,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Doctor_ViewHolder holder, int position) {
        holder.doctor_name.setText(items.get(position).getName());
        holder.doctor_specialization.setText(items.get(position).getSpecialization());
        holder.doctor_rating.setText(items.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
