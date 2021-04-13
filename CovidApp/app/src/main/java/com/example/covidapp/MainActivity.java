package com.example.covidapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    private EditText Email;
    private EditText Password;
    private Button Login;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        Email = (EditText)findViewById(R.id.etEmail);
        Password = (EditText)findViewById(R.id.tvPassword);
        Login = (Button)findViewById(R.id.buttonLogin);

        Login.setOnClickListener(new View.onClickListener() {
            public void onClick(View view) {
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
    private void validate(String userName, String userPassword){
        if ((userName == "test@myport.ac.uk") && (userPassword == "smellyjelly")) {
            Intent intent = new Intent(MainActivity.this, secondActivty.class);
            startActivity(intent);
        }else{
            System.out.println("Incorrect email or password! Please Try again");
        }
    }
}