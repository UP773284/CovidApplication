package com.example.covidapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.covidapp.listener.IBoredListener;
import com.example.covidapp.ui.Preferences;
import com.example.covidapp.ui.diary.MyDiary;
import com.example.covidapp.ui.eventlist.EventList_Fragment;
import com.example.covidapp.ui.homeFragment.HomeFragment;
import com.example.covidapp.ui.information.InformationFragment;
import com.example.covidapp.ui.usernavigation.NavigationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements IBoredListener {

    BottomNavigationView bottomNavigationView;
    Context mcontext=null;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcontext=this;
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentcontainer, new HomeFragment()).commit();
        bottomNavigationView=findViewById(R.id.nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.navigation_location:
                        setTitle("Location");
                        Toast.makeText(mcontext,"Location Clicked",Toast.LENGTH_LONG).show();
                        //navigationToAnother(new map());
                        return true;
                    case R.id.navigation_calendar:
                        setTitle("Activities");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new EventList_Fragment()).commit();
                        return true;
                    case R.id.navigation_information:
                        setTitle("Information");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new InformationFragment()).commit();
                        return true;
                    case R.id.navigation_home:
                        setTitle("Home");
                        getSupportFragmentManager().beginTransaction().add(R.id.fragmentcontainer, new HomeFragment()).commit();
                        return true;
                    case R.id.navigation_user:
                        setTitle("Profile");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new Preferences()).commit();

                        return true;
                        
                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.favorite){
            navigationToAnother(new MyDiary());
        }
        return super.onOptionsItemSelected(item);

    }
    private void  navigationToAnother(Activity activity)
    {
        Intent i = new Intent(this, activity.getClass());
        startActivity(i);
    }

    @Override
    public void onIamBoredClick() {
        setTitle("Profile");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new Preferences()).commit();
    }
}