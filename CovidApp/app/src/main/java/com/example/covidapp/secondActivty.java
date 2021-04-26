package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class secondActivty extends AppCompatActivity {
    TextView example; // rename
    Button example; //rename as

    private String activities = [] = ("one", "Two", "Three", "Four", "Five");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activty);

        tv1 = (TextView) findViewbyId(R.id.);b1 = (Button) findViewById(R.id)
        button1 = (Button) findViewById(R.id.tv);
        b1 = setOnClickListener(new View.onClickListener(){
            Random.random=new Random();
            int num = Random.nextInt(event.length);
            tv1.setText(jokes[num]);
        });
    }
}