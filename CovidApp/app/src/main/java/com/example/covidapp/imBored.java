package com.example.covidapp;
import android.app.Activity;
import android.view.View;
import android.widget.SeekBar;

import java.util.Random;

public class imBored extends Activity implements View.OnClickListener{
    String[] activity = {"basketball", "football", "run", "push ups", "squats"};
    String selectedActivity;
    Random r = new Random();
    int i =r.nextInt(1-(activity.length) - 0);
    selectedActivity = activity[i];

    Button  = (Button)findViewById(R.id.button);
    button.setText("Click Me !");
}
