package com.example.covidapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.covidapp.ui.AddEvent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class Schedule extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_schedule);

        button = (Button) findViewById(R.id.BtnAddEvent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemevent();
            }
        });
    }

    public void itemevent(){
        Intent intent = new Intent(this, AddEvent.class);
        startActivity(intent);
    }
}