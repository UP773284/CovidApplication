package com.example.covidapp.ui.eventlist;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.covidapp.R;
import com.example.covidapp.data.local.Event;
import com.example.covidapp.data.local.EventDataSource;
import com.example.covidapp.listener.EventItemClickListener;
import com.example.covidapp.listener.FavoriteEventItemClickListener;
import com.example.covidapp.ui.AddEvent;
import com.example.covidapp.ui.eventlist.adapter.EventAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EventList_Fragment extends Fragment implements FavoriteEventItemClickListener {


    public static final String TAG = "EventList_Fragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EventAdapter adapter;
    RecyclerView eventList;
    FloatingActionButton addEvent;

    public EventList_Fragment() {
        // Required empty public constructor
    }

    void displayData(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        adapter = new EventAdapter(EventDataSource.data);
        adapter.setEventList(this);
        eventList.setLayoutManager(linearLayoutManager);
        eventList.setAdapter(adapter);
    }

    public static EventList_Fragment newInstance(String param1, String param2) {
        EventList_Fragment fragment = new EventList_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eventlist, container, false);
        eventList = view.findViewById(R.id.eventlist);
        addEvent = view.findViewById(R.id.floatingActionbar);
        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAddEvent();
            }
        });
        displayData();
        EventDataSource.fillData();
        return view;
    }

    void callAddEvent(){
        Intent addevent = new Intent(getActivity(), AddEvent.class);
        // addevent.putExtra("EVENT", event);
        startActivity(addevent);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("OnResume", "Im cold");
        adapter.updateEvents(EventDataSource.data);
    }

    @Override
    public void onFavoriteItemClick(int position, Event event, boolean is_favorite) {
        if(is_favorite){
            EventDataSource.addFavoriteEvent(event);
        }
        else{
            Intent addevent = new Intent(getActivity(), AddEvent.class);
            addevent.putExtra("eventposition", position);
            startActivity(addevent);
        }
    }
}