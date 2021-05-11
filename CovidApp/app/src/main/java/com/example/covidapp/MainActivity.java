package com.example.covidapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.covidapp.ui.preferences;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button ImBored, KeepMeFit, WhatsOpen, Wellbeing;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        ImBored = findViewById(R.id.imBored);
        KeepMeFit = findViewById(R.id.keepFit);
        WhatsOpen = findViewById(R.id.whatsopen);
        Wellbeing = findViewById(R.id.wellbeing);
        ImBored.setOnClickListener(this);
        KeepMeFit.setOnClickListener(this);
        WhatsOpen.setOnClickListener(this);
        Wellbeing.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imBored:{
                navigationToAnother(new preferences());
            }break;
            case R.id.keepFit:{
                Toast.makeText(MainActivity.this, "Keep me fit!", Toast.LENGTH_SHORT).show();
                //navigationToAnother(new keepmefit());
            }break;
            case R.id.whatsopen:{
                Toast.makeText(MainActivity.this, "What is open!", Toast.LENGTH_SHORT).show();
                //navigationToAnother(new whatsopen());
            }break;
            case R.id.wellbeing:{
                Toast.makeText(MainActivity.this, "Well being!", Toast.LENGTH_SHORT).show();
                //navigationToAnother(new wellbeing());
            }break;

        }
    }


    private void  navigationToAnother(Activity activity)
    {
        Intent i = new Intent(this, activity.getClass());
        startActivity(i);
    }
}