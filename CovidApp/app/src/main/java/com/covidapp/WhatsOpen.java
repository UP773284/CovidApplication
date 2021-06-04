package com.example.covidapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.covidapp.databinding.OpenClosedBinding;
import com.example.covidapp.utils.AlertDialogHandler;

public class WhatsOpen extends AppCompatActivity implements View.OnClickListener {
    OpenClosedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate((savedInstanceState));
        binding = DataBindingUtil.setContentView(this,R.layout.open_closed);
        binding.imageHostpitality.setOnClickListener(this);
        binding.imageViewPersonal.setOnClickListener(this);
        binding.imageViewRetail.setOnClickListener(this);
        binding.imageViewSupermarket.setOnClickListener(this);
        binding.imageViewTravel.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        switch(v.getId()){
            case R.id.imageHostpitality:
                AlertDialogHandler.showInfoDialoge(WhatsOpen.this, "All restaurants", "Take away service only!");
                break;
            case R.id.imageViewPersonal:
                AlertDialogHandler.showInfoDialoge(WhatsOpen.this, "All restaurants", "Take away service only!");
                break;
            case R.id.imageViewRetail:
                AlertDialogHandler.showInfoDialoge(WhatsOpen.this, "All restaurants", "Take away service only!");
                break;
            case R.id.imageViewTravel:
                AlertDialogHandler.showInfoDialoge(WhatsOpen.this, "All restaurants", "Take away service only!");
                break;
            case R.id.imageViewSupermarket:
                AlertDialogHandler.showInfoDialoge(WhatsOpen.this, "All restaurants", "Take away service only!");
                break;
        }
    }
}
