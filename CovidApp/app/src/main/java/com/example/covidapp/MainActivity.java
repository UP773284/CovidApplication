package com.example.covidapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        //BottomNavigationView navView = findViewById(R.id.nav_view);



 //       AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                //R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                //.build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imBored:{
                Toast.makeText(MainActivity.this, "I am bored!", Toast.LENGTH_SHORT).show();
            }break;
            case R.id.keepFit:{
                Toast.makeText(MainActivity.this, "Keep me fit!", Toast.LENGTH_SHORT).show();

            }break;
            case R.id.whatsopen:{
                Toast.makeText(MainActivity.this, "What is open!", Toast.LENGTH_SHORT).show();

            }break;
            case R.id.wellbeing:{
                Toast.makeText(MainActivity.this, "Well being!", Toast.LENGTH_SHORT).show();
            }break;
        }
    }
}
