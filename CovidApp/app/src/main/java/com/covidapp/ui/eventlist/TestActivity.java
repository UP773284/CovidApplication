package com.example.covidapp.ui.eventlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.covidapp.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        EventList_Fragment eventListFragment = EventList_Fragment.newInstance("1","2");
        getSupportFragmentManager().beginTransaction().add(R.id.container, eventListFragment,EventList_Fragment.TAG).commit();
    }
}