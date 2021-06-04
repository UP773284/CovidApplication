package com.example.covidapp.ui.diary;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidapp.R;
import com.example.covidapp.data.local.Event;

public class MyDiaryEventViewHolder extends RecyclerView.ViewHolder {
    TextView date, name, location, description;
    ImageView imagefavorite;

    public MyDiaryEventViewHolder(@NonNull View itemView) {
        super(itemView);
        date = itemView.findViewById(R.id.textdate);
        name = itemView.findViewById(R.id.textname);
        location = itemView.findViewById(R.id.textlocation);
        description = itemView.findViewById(R.id.textdescription);
        imagefavorite = itemView.findViewById(R.id.imagefavorite);
       
    }
    void bindEvent(Event event){
        date.setText(event.getDate());
        name.setText(event.getName());
        location.setText(event.getLocation());
        description.setText(event.getDescription());

    }
}
