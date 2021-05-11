package com.example.covidapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
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
            public void onClick(View v) {
                String fname, lname, email, password, city;

                fname = firstName.getText().toString();
                lname = lastName.getText().toString();
                email = Email.getText().toString();
                password = Password.getText().toString();
                city = City.getText().toString();


                if (fname.equals(""))
                {
                    Toast.makeText(SignUp.this, "First name cannot be empty", Toast.LENGTH_SHORT).show();
                }
               else if (lname.equals(""))
                {
                    Toast.makeText(SignUp.this, "Last name cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if (email.equals(""))
                {
                    Toast.makeText(SignUp.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if (password.equals(""))
                {
                    Toast.makeText(SignUp.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if (city.equals(""))
                {
                    Toast.makeText(SignUp.this, "City cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SignUp.this, "Sign up successful!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}