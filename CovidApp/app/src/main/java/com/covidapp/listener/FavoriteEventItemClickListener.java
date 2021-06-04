package com.example.covidapp.listener;

import com.example.covidapp.data.local.Event;

public interface FavoriteEventItemClickListener {
    void onFavoriteItemClick(int position, Event event, boolean is_favorite);
    
}
