package com.example.covidapp.ui.eventlist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidapp.R;
import com.example.covidapp.data.local.Event;
import com.example.covidapp.listener.EventItemClickListener;
import com.example.covidapp.listener.FavoriteEventItemClickListener;
import com.example.covidapp.ui.diary.MyDiaryEventViewHolder;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter <EventViewHolder> {

    List<Event>eventList;
    FavoriteEventItemClickListener eventItemClickListener;
    public EventAdapter(List<Event>eventList){
        this.eventList = eventList;
    }

    public void setEventList(FavoriteEventItemClickListener eventItemClickListener) {
        this.eventItemClickListener = eventItemClickListener;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemevent,parent,false);

        return new EventViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.imagefavorite.setTag(position);
        holder.imageEdit.setTag(position);
        if (eventItemClickListener != null){
            holder.imagefavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = (int )v.getTag();
                    Event selectedevent = eventList.get(index);
                    eventItemClickListener.onFavoriteItemClick(index, selectedevent, true);
                }
            });
            holder.imageEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = (int )v.getTag();
                    Event selectedevent = eventList.get(index);
                    eventItemClickListener.onFavoriteItemClick(index, selectedevent, false);
                }
            });
        }
       EventViewHolder  eventvh = (EventViewHolder) holder;
        eventvh.bindEvent(event);
    }
    public void updateEvents(List<Event>eventList){
        //this.eventList.clear();
        this.eventList = eventList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}







  
