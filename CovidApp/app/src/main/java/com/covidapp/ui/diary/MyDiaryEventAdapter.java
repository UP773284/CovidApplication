package com.example.covidapp.ui.diary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidapp.R;
import com.example.covidapp.data.local.Event;
import com.example.covidapp.listener.EventItemClickListener;
import com.example.covidapp.listener.FavoriteEventItemClickListener;
import com.example.covidapp.ui.eventlist.adapter.EventViewHolder;

import java.util.List;

public class MyDiaryEventAdapter extends RecyclerView.Adapter <MyDiaryEventViewHolder> {
    List<Event>eventList;
    EventItemClickListener eventItemClickListener;
    public MyDiaryEventAdapter(List<Event>eventList){
        this.eventList = eventList;
    }

    public void setEventList(    EventItemClickListener eventItemClickListener) {
        this.eventItemClickListener = eventItemClickListener;
    }

    @NonNull
    @Override
    public MyDiaryEventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemfavorite,parent,false);

        return new MyDiaryEventViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyDiaryEventViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.imagefavorite.setTag(position);
        if (eventItemClickListener != null){
            holder.imagefavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = (int )v.getTag();
                    Event selectedevent = eventList.get(index);
                    eventItemClickListener.onItemClick(index, selectedevent);
                }
            });
        }
        MyDiaryEventViewHolder eventvh = (MyDiaryEventViewHolder)holder;
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