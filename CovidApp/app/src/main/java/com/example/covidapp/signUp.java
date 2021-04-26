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

public class signUp extends AppCompatActivity {
    EditText firstName, lastName, Email, Password, City;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_sign__up);
        firstName = findViewById(R.id.tvfirstName);
        lastName = findViewById(R.id.tvlastName);
        Email = findViewById(R.id.tvEmail);
        Password = findViewById(R.id.tvPassword);
        City = findViewById(R.id.tvPassword);
        signUp = findViewById(R.id.btnSignUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @override
            public void onClick(View v)
            {
                string firstName, lastName, Email, Password, City;

                firstName = firstName.getText().toString();
                lastName = lastName.getText().toString();
                Email = Email.getText().toString();
                Password = Password.getText().toString();
                City = City.getText().toString();

                if (firstName.equals(""));{
                    Toast.makeText(context: Register.this, text "First name cannot be empty", Toast.LENGTH_SHORT).show();
                }
                if (lastName.equals(""));{
                    Toast.makeText(context: Register.this, text "Last name cannot be empty", Toast.LENGTH_SHORT).show();
                }
                if (Email.equals(""));{
                    Toast.makeText(context: Register.this, text "Email cannot be empty", Toast.LENGTH_SHORT).show();
                }
                if (Password.equals(""));{
                    Toast.makeText(context: Register.this, text "Password cannot be empty", Toast.LENGTH_SHORT).show();
                }
                if (City.equals(""));{
                    Toast.makeText(context: Register.this, text "City cannot be empty", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}