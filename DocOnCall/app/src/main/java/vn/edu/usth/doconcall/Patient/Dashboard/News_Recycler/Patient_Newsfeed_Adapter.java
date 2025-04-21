package vn.edu.usth.doconcall.Patient.Dashboard.News_Recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.usth.doconcall.R;

public class Patient_Newsfeed_Adapter extends RecyclerView.Adapter<Patient_Newsfeed_ViewHolder> {

    Context context;
    List<Patient_Newsfeed_Item> items;

    public Patient_Newsfeed_Adapter(Context context, List<Patient_Newsfeed_Item> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public Patient_Newsfeed_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Patient_Newsfeed_ViewHolder(LayoutInflater.from(context).inflate(R.layout.frame_news_feed,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Patient_Newsfeed_ViewHolder holder, int position) {
        Patient_Newsfeed_Item item = items.get(position);

        holder.title.setText(items.get(position).getTitle());
        holder.content.setText(items.get(position).getContent());
        holder.feed_image.setImageResource(items.get(position).getFeed_image());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Patient_Newsfeed.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
