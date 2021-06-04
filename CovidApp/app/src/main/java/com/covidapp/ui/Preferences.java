package com.example.covidapp.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.covidapp.R;
import com.example.covidapp.settings.SettingsActivity;
import com.example.covidapp.utils.AlertDialogHandler;

import static com.example.covidapp.utils.AlertDialogHandler.showInfoDialoge;

public class Preferences extends Fragment {
    SeekBar seekBar_run,seekbar_social,seekbar_wellbeing;
    Integer progress1,progress2,progress3;
    Button getData;
    ImageView settings;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.im_bored, container, false);


        return view;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        seekBar_run = view.findViewById(R.id.seekbar_run);
        settings = view.findViewById(R.id.imgsettings);
        getData = view.findViewById(R.id.buttonRandom);
        seekbar_social = view.findViewById(R.id.seekBar_group_size);
        seekbar_wellbeing = view.findViewById(R.id.seekbar_wellbeing);



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
                progress1= progress;
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

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), new SettingsActivity().getClass());
                startActivity(intent);
            }
        });
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialoge(getContext(), "Our algorithm shows that you should head out for a light run!", "hello");

//                if(progress1 < progress2  && progress1 < progress3 ){
//
//                    Toast.makeText(getActivity(), "Go for a run", Toast.LENGTH_SHORT).show();
//
//                }
//                else if(progress2 < progress1 && progress2 < progress3){
//
//                    Toast.makeText(getActivity(), "Go to the pub kitchen", Toast.LENGTH_SHORT).show();
//                }
//                else{
//
//
//                    Toast.makeText(getActivity(), "Go Dancing", Toast.LENGTH_SHORT).show();
//                }



            }
        });
    }
    }

