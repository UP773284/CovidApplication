package com.example.covidapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.covidapp.MainActivity;
import com.example.covidapp.R;

public class preferences extends AppCompatActivity {
    SeekBar seekBar_run,seekbar_social,seekbar_wellbeing;
    Integer progress1,progress2,progress3;
    Button getData;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_preferences);
        Button button = (Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(preferences.this, Pop.class));

            }
        });

        seekBar_run = findViewById(R.id.seekbar_run);
        seekbar_social = findViewById(R.id.seekBar);

        seekbar_wellbeing = findViewById(R.id.seekbar_wellbeing);

        getData = findViewById(R.id.button);

        seekBar_run.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
//                Toast.makeText(getApplicationContext(),"seekbar progress: "+progress, Toast.LENGTH_SHORT).show();
                progress1 = progress;
                seekBar_run.setProgress(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });

        seekbar_social.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
//                Toast.makeText(getApplicationContext(),"seekbar progress: "+progress, Toast.LENGTH_SHORT).show();
                progress2 = progress;
                seekbar_social.setProgress(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });

        seekbar_wellbeing.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
//                Toast.makeText(getApplicationContext(),"seekbar progress: "+progress, Toast.LENGTH_SHORT).show();
                progress3 = progress;
                seekbar_wellbeing.setProgress(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(progress1 > progress2 ){
                    Toast.makeText(preferences.this, "Go for a run", Toast.LENGTH_SHORT).show();

                }
                else if(progress2 > progress1){
                    Toast.makeText( preferences.this, "Go to the pub kitchen", Toast.LENGTH_SHORT).show();
                }
                else if(progress3  > progress1){
                    Toast.makeText( preferences.this, "Go Dancing", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
