package com.example.covidapp.ui.home;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.covidapp.MapFragment;
import com.example.covidapp.R;
import com.example.covidapp.ui.schedule.SceduleFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NewAct extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.bottom_nav_menu);
//
//        BottomNavigationView bottom_nav_menu = findViewById(R.id.nav_view);
//        BottomNavigationView.OnNavigationItemSelectedListener navListener = null;
//        bottom_nav_menu.setOnNavigationItemSelectedListener(navListener);
//
//        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container);
//    }
//
//    private BottomNavigationView.OnNavigationItemReselectedListener navListener =
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    Fragment selectedFragment = null;
//
//                    switch (item.getItemId()) {
//                        case R.id.navigation_home:
//                            selectedFragment = new HomeFragment();
//                            break;
//                        case R.id.navigation_calendar:
//                            selectedFragment = new SceduleFragment();
//                            break;
//                        case R.id.navigation_location:
//                            selectedFragment = new MapFragment();
//                            break;
//
//                    }
//                    //getSupportFragmentManager().beginTransaction().replace((R.id.fragment_container,
//                            selectedFragment).commit());
//
//                    return true;
//                }
//
//            };
}