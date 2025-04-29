package vn.edu.usth.doconcall.Patient.Schedule.Event;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import vn.edu.usth.doconcall.Patient.Schedule.Calendar.Patient_Calendar_Utils;
import vn.edu.usth.doconcall.R;

public class Patient_Event_Adapter extends ArrayAdapter<Patient_Event> {

    public Patient_Event_Adapter(@NonNull Context context, List<Patient_Event> events)
    {
        super(context, 0, events);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Patient_Event event = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.frame_event, parent, false);

        TextView eventCellTV = convertView.findViewById(R.id.eventCellTV);

        String eventTitle = event.getName() +" "+ Patient_Calendar_Utils.formattedTime(event.getTime());
        eventCellTV.setText(eventTitle);
        return convertView;
    }
}
