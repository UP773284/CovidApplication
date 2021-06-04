package com.example.covidapp.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.covidapp.R;
import com.example.covidapp.data.local.Event;
import com.example.covidapp.data.local.EventDataSource;

public class AddEvent extends AppCompatActivity implements View.OnClickListener {
    private Button buttonAdd;
    ImageView buttonDelete, buttonClose;
    EditText editeventname, editdate, editlocation, editdescription;
    Event event;
int index=-1;
    public Event getEventFromBundle() {
        if(getIntent().getExtras()!= null){
            //event = (Event)getIntent().getParcelableExtra("EVENT");

            index = getIntent().getIntExtra("eventposition",-1);
                event = EventDataSource.data.get(index);

            }

        return event;
    }

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_event);
        editeventname = findViewById(R.id.edit_eventname);
        editdate = findViewById(R.id.editdate);
        editlocation = findViewById(R.id.editlocation);
        editdescription = findViewById(R.id.editdecription);
        buttonAdd = findViewById(R.id.button_add);
        buttonClose = findViewById(R.id.button_close);
        buttonDelete = findViewById(R.id.button_delete);
        ActionBar floatingAction = getSupportActionBar();
        floatingAction.setDisplayHomeAsUpEnabled(true);
        buttonAdd.setOnClickListener(this);
        buttonClose.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);

        if(getEventFromBundle() != null){

            showData();
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);

    }

    public void openInputEvent(){

    }
    void showData(){
        setTitle("Update Event");
        buttonAdd.setText("Update");
        editeventname.setText(event.getName());
        editdate.setText(event.getDate());
        editlocation.setText(event.getLocation());
        editdescription.setText(event.getDescription());

    }
    boolean isValidEvent(){
        if (TextUtils.isEmpty(editeventname.getText())){
            editeventname.setError("Enter event name");
            return false;
        }
        else if (TextUtils.isEmpty(editdate.getText())){
            editdate.setError("Enter date");
            return false;
        }
        else if (TextUtils.isEmpty(editlocation.getText())){
            editlocation.setError("Enter location");
            return false;
        }
        else if (TextUtils.isEmpty(editdescription.getText())){
            editdescription.setError("Enter event description");
            return false;
        }
        return true;
    }

    Event getEventFromFields(){
        Event newevent = new Event();
        if (isValidEvent()){
            String eventname = editeventname.getText().toString();
            String eventdate = editdate.getText().toString();
            String eventdescription = editdescription.getText().toString();
            String eventlocation = editlocation.getText().toString();

            newevent.setName(eventname);
            newevent.setDate(eventdate);
            newevent.setLocation(eventlocation);
            newevent.setDescription(eventdescription);

        }
        return newevent;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_add:
            {
                if (buttonAdd.getText().equals("Update")){
                    Event event = getEventFromFields();
                    if(event.getName()!= null){

                        EventDataSource.updateEvent(event, index);
                        finish();
                    }
                }
                else{
                    Event event = getEventFromFields();
                    if(event.getName()!= null){

                        EventDataSource.addEvent(event);
                        finish();
                    }
                }

            }
                break;
            case R.id.button_delete:
                {
                    EventDataSource.deleteEvent(event);
                    finish();
            }
                break;
            case R.id.button_close:
                finish();
                break;
        }
    }
}

