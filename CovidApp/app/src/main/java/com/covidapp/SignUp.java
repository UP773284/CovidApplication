package com.example.covidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidapp.databinding.ContentSignUpBinding;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    ContentSignUpBinding signupbinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signupbinding = DataBindingUtil.setContentView(this, R.layout.content_sign__up);

        signupbinding.btnSignUp.setOnClickListener(this);
        signupbinding.txtGotAccount.setOnClickListener(this);
    }
    void signup()
    {
        String fname, lname, email, password, city;

        fname = signupbinding.tvfirstName.getText().toString();
        lname =  signupbinding.tvlastName.getText().toString();
        email =  signupbinding.tvEmail.getText().toString();
        password =  signupbinding.tvPassword.getText().toString();
        city =  signupbinding.tvCity.getText().toString();


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

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnSignUp:
                signup();
                break;
            case R.id.txtGotAccount:
                finish();
                break;
        }
    }
}


