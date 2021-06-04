package com.example.covidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etEmail, etPassword;
    Button buttonLogin;
    TextView creataccount, gotaccount;
    TextView forgotpassword;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        creataccount = findViewById(R.id.textView_createaccount);
        forgotpassword = findViewById(R.id.tv_forgotpassword);
        etEmail = findViewById(R.id.tvEmail);
        etPassword = findViewById(R.id.tvPassword);
        buttonLogin = (Button)findViewById(R.id.buttonLogin);
        creataccount.setOnClickListener(this);
        forgotpassword.setOnClickListener(this);
        buttonLogin.setOnClickListener(this);

    }

    private void validate(String email, String password) {
        if (email.equalsIgnoreCase("test@myport.ac.uk" )&& password.equalsIgnoreCase("password")){

            navigationToAnother(new MainActivity());

        }
        else {
            Toast.makeText(LoginActivity.this, "Incorrect email or password.", Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.textView_createaccount:
            {
                navigationToAnother(new SignUp());
            }
            break;
            case R.id.buttonLogin:
                validate(etEmail.getText().toString(),etPassword.getText().toString());
                break;

            case R.id.tv_forgotpassword:
                Toast.makeText(LoginActivity.this,"A password recovery link has been sent to your email", Toast.LENGTH_LONG).show();
                break;

            case R.id.txtGotAccount: {
                navigationToAnother(new LoginActivity());
            }
            break;
        }

    }

    private void  navigationToAnother(Activity activity)
    {
        Intent i = new Intent(this, activity.getClass());
        startActivity(i);
    }
}
