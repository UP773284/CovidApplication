package com.example.covidapp.ui.diary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.covidapp.R;
import com.example.covidapp.ui.eventlist.EventList_Fragment;

public class MyDiary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_diary);
        ActionBar floatingAction = getSupportActionBar();
        floatingAction.setDisplayHomeAsUpEnabled(true);
        getSupportFragmentManager().beginTransaction().add(R.id.container, new EventList_Diary()).commit();


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);

    }
}