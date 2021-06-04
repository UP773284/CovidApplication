package com.example.covidapp.ui.feedback;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.covidapp.R;
import com.example.covidapp.databinding.FeedbackBinding;

public class Feedback extends AppCompatActivity implements View.OnClickListener {
    FeedbackBinding feedbackBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        feedbackBinding = DataBindingUtil.setContentView(this, R.layout.feedback);
        feedbackBinding.btnSendFeedback.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    void validateFeedback(){
        String feedbackform ;

        feedbackform = feedbackBinding.editTextFeedbackForm.getText().toString();

        if (TextUtils.isEmpty(feedbackform) &&  feedbackBinding.ratingBar.getRating()==0){
            Toast.makeText(this, "Feedback form is empty.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Thanks for your FeedBack", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    @Override
    public void onClick(View v) {
        validateFeedback();
    }
}
