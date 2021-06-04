package com.example.covidapp.listener;

import com.example.covidapp.data.local.Event;

public interface EventItemClickListener {
    void onItemClick(int position, Event event);
}
