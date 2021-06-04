package com.example.covidapp.data.local;

import java.util.ArrayList;
import java.util.List;

public class EventDataSource {
    public static List<Event> data = new ArrayList<>();
    public static List<Event> favorite_data = new ArrayList<>();

    public static void  fillData(){
        data.add(new Event("19-04-2021","Salsa dancing", "Outdoors, socially distant event", "Fratton"));
        data.add(new Event("19-04-2021","Fisbee", "Outdoors, socially distant event", "Fratton"));
        data.add(new Event("19-04-2021","Football", "Outdoors, socially distant event", "Fratton"));
        data.add(new Event("19-04-2021","Rugby", "Outdoors, socially distant event", "Fratton"));
        data.add(new Event("19-04-2021","chsti", "Outdoors, socially distant event", "Fratton"));

    }
    public static void addEvent(Event event){
        data.add(event);
    }
    public static void deleteEvent(Event event){
        data.remove(event);
    }
    public static void  updateEvent(Event event, int position){
        data.set(position, event);
    }

    public static void addFavoriteEvent(Event event){
        favorite_data.add(event);
    }
    public static void deleteFavoriteEvent(Event event){ favorite_data.remove(event); }
    public static void  updateFavoriteEvent(Event event, int position){ favorite_data.set(position, event);


    }
}
