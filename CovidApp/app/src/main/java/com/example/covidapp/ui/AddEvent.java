package com.example.covidapp.ui;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covidapp.R;

public class AddEvent extends AppCompatActivity {
  //  private Button button;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       /* button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override    
            public void onClick(View v){
                openInputEvent();
            }
        });*/
    }
    public void openInputEvent(){
      /*  Intent intent = new Intent(this, InputEvent.class);
        startActivity(Intent);*/
    }
}

