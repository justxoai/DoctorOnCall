package vn.edu.usth.doconcall.Patient.Dashboard.News_Recycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import vn.edu.usth.doconcall.R;

public class Patient_Newsfeed_ViewHolder extends RecyclerView.ViewHolder{

    TextView title, content;
    ImageView feed_image;

    public Patient_Newsfeed_ViewHolder(@NonNull View view){
        super(view);

        title = view.findViewById(R.id.news_feed_title);
        content = view.findViewById(R.id.news_feed_content);
        feed_image = view.findViewById(R.id.newsfeed_image);
    }
}
