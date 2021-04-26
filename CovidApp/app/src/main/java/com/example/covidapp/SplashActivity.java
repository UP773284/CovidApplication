package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        supportActionBar?.hide()

        Handler().postDelayed({
                val intent = Intent(PackageContext: this@content_sign_up::class.java)
                startActivty(Intent)
        }, delayMillis:3000)
    }
}