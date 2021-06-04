package com.example.covidapp.ui.diary;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidapp.R;
import com.example.covidapp.data.local.Event;
import com.example.covidapp.data.local.EventDataSource;
import com.example.covidapp.listener.EventItemClickListener;
import com.example.covidapp.ui.AddEvent;
import com.example.covidapp.ui.eventlist.adapter.EventAdapter;

import javax.sql.DataSource;

public class EventList_Diary extends Fragment implements EventItemClickListener {


    public static final String TAG = "EventList_Fragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    MyDiaryEventAdapter adapter;
    RecyclerView eventList;
    public EventList_Diary() {
        // Required empty public constructor
    }

    void displayData(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        adapter = new MyDiaryEventAdapter(EventDataSource.favorite_data);
        adapter.setEventList(this);
        eventList.setLayoutManager(linearLayoutManager);
        eventList.setAdapter(adapter);
    }

    public static EventList_Diary newInstance(String param1, String param2) {
        EventList_Diary fragment = new EventList_Diary();
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
        View view = inflater.inflate(R.layout.fragment_mydiary, container, false);
        eventList = view.findViewById(R.id.eventlist);
        displayData();
        EventDataSource.fillData();
        return view;
    }

    @Override
    public void onItemClick(int position, Event event) {
        EventDataSource.deleteFavoriteEvent(event);
        adapter.updateEvents(EventDataSource.favorite_data);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("OnResume", "Im cold");
    }
}