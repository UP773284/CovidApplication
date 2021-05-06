package com.example.covidapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signUp extends AppCompatActivity {
    EditText firstName, lastName, Email, Password, City;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_sign__up);

        firstName = (EditText) findViewById(R.id.tvfirstName);
        lastName = findViewById(R.id.tvlastName);
        Email = findViewById(R.id.tvEmail);
        Password = findViewById(R.id.tvPassword);
        City = findViewById(R.id.tvCity);
        signUp = findViewById(R.id.btnSignUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String firstName, lastName, Email, Password, City;

                firstName = firstName.getText().toString();
                lastName = lastName.getText().toString();
                Email = Email.getText().toString();
                Password = Password.getText().toString();
                City = City.getText().toString();

                if (firstName.equals(""));{
                    Toast.makeText(signUp.this, "First name cannot be empty", Toast.LENGTH_SHORT).show();
                }
                if (lastName.equals(""));{
                    Toast.makeText(signUp.this, "Last name cannot be empty", Toast.LENGTH_SHORT).show();
                }
                if (Email.equals(""));{
                    Toast.makeText(signUp.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                }
                if (Password.equals(""));{
                    Toast.makeText(signUp.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                }
                if (City.equals(""));{
                    Toast.makeText(signUp.this, "City cannot be empty", Toast.LENGTH_SHORT).show();
                }

            }
        });
//        signUp.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent R = new Intent(signUp.this, MainActivity.class);
//                startActivity(R);
//                finish();
//            }
//        }
//    }
//}