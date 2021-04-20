package com.example.covidapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail, etPassword;
    Button buttonLogin;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.tvEmail);
        etPassword = findViewById(R.id.tvPassword);
        buttonLogin = (Button)findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                validate(etEmail.getText().toString(),etPassword.getText().toString());

            }
        });

    }

    private void validate(String email, String password) {
        if (email.equalsIgnoreCase("test@myport.ac.uk" )&& password.equalsIgnoreCase("Smellyjelly123")){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

        }


    }
}
