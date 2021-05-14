package com.example.covidapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.covidapp.R;

public class preferences extends AppCompatActivity {
    SeekBar seekBar_run,seekbar_social,seekbar_wellbeing;
    Integer progress1,progress2,progress3;
    Button getData;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imbored);
      /*  Button button = (Button) findViewById(R.id.Randombtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(preferences.this, Pop.class));

            }
        });*/

        seekBar_run = findViewById(R.id.seekbar_run);
        seekbar_social = findViewById(R.id.seekBar);

        seekbar_wellbeing = findViewById(R.id.seekbar_wellbeing);

        //getData = findViewById(R.id.Randombtn);

        seekBar_run.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {

                progress1 = progress;
                Log.d("Seek bar","Run "+progress1.toString());
                seekBar_run.setProgress(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekbar_social.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                progress2 = progress;
                seekbar_social.setProgress(progress);
                Log.d("Seek bar","Social "+progress2.toString());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekbar_wellbeing.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                progress3 = progress;
                seekbar_wellbeing.setProgress(progress);
                Log.d("Seek bar","Well Being "+progress1.toString());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(progress1 < progress2  && progress1 < progress3 ){

                    Toast.makeText(preferences.this, "Go for a run", Toast.LENGTH_SHORT).show();

                }
                else if(progress2 < progress1 && progress2 < progress3){

                            Toast.makeText( preferences.this, "Go to the pub kitchen", Toast.LENGTH_SHORT).show();
                }
                else{


                            Toast.makeText( preferences.this, "Go Dancing", Toast.LENGTH_SHORT).show();
                    }



            }
        });
    }
}
