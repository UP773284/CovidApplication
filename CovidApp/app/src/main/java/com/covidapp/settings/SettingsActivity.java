package com.example.covidapp.settings;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.covidapp.R;
import com.example.covidapp.databinding.SettingsBinding;
import com.example.covidapp.ui.feedback.Feedback;

import org.w3c.dom.Text;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    SettingsBinding settingsBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingsBinding = DataBindingUtil.setContentView(this, R.layout.settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        settingsBinding.textViewFeedback.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
        }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();

        }
            return true;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SettingsActivity.this, Feedback.class);
        startActivity(intent);
    }
}