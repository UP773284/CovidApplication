package com.example.covidapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.covidapp.ui.preferences;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button ImBored, KeepMeFit, WhatsOpen, Wellbeing;
BottomNavigationView bottomNavigationView;
Context mcontext=null;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        mcontext=this;

        bottomNavigationView=findViewById(R.id.nav_view);
        ImBored = findViewById(R.id.imBored);
        KeepMeFit = findViewById(R.id.keepFit);
        WhatsOpen = findViewById(R.id.whatsopen);
        Wellbeing = findViewById(R.id.wellbeing);
        ImBored.setOnClickListener(this);
        KeepMeFit.setOnClickListener(this);
        WhatsOpen.setOnClickListener(this);
        Wellbeing.setOnClickListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.navigation_location:
                        Toast.makeText(mcontext,"Location Clicked",Toast.LENGTH_LONG).show();
                        navigationToAnother(new preferences());
                        return true;
                    case R.id.navigation_calendar:

                        Toast.makeText(mcontext,"Calndar Clicked",Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.navigation_information:
                        Toast.makeText(mcontext,"information Clicked",Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.navigation_home:
                        Toast.makeText(mcontext,"Home Clicked",Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.navigation_user:
                        Toast.makeText(mcontext,"Profile Clicked",Toast.LENGTH_LONG).show();
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imBored:{
                navigationToAnother(new preferences());
            }break;
            case R.id.keepFit:{
                Toast.makeText(MainActivity.this, "Keep me fit!", Toast.LENGTH_SHORT).show();
                navigationToAnother(new keepmefit());
            }break;
            case R.id.whatsopen:{
                Toast.makeText(MainActivity.this, "What is open!", Toast.LENGTH_SHORT).show();
                navigationToAnother(new whatsopen());
            }break;
            case R.id.wellbeing:{
                Toast.makeText(MainActivity.this, "Well being!", Toast.LENGTH_SHORT).show();
                navigationToAnother(new wellbeing());
            }break;

        }
    }


    private void  navigationToAnother(Activity activity)
    {
        Intent i = new Intent(this, activity.getClass());
        startActivity(i);
    }
}