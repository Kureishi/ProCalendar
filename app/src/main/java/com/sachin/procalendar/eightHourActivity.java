package com.sachin.procalendar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class eightHourActivity extends AppCompatActivity {

    ImageButton startButton;
    ImageButton endButton;
    TextView startTime;
    TextView endTime;

    Calendar currentTime;
    int hour, minute;
    String format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighthour);

        startButton = (ImageButton)findViewById(R.id.startButton);
        endButton = (ImageButton)findViewById(R.id.endButton);
        startTime = (TextView)findViewById(R.id.startTime);
        endTime = (TextView)findViewById(R.id.endTime);

        currentTime = Calendar.getInstance();

        hour = currentTime.get(Calendar.HOUR_OF_DAY);
        minute = currentTime.get(Calendar.MINUTE);

        selectedTimeFormat(hour);

        startTime.setText(hour + " : " + minute + " " + format);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(eightHourActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        selectedTimeFormat(hour);
                        startTime.setText(hour + " : " + minute + " " + format);
                    }
                }, hour, minute, false);
                timePickerDialog.show();
            }
        });
    }

    public void selectedTimeFormat(int hour) {
        if(hour == 0) {
            hour += 12;                                                                             // if 0 -> transform to read 12
            format = "AM";
        }
        else if(hour == 12) {
            format = "PM";
        }
        else if(hour > 12){
            hour -= 12;
            format = "PM";
        }
        else {
            format = "AM";
        }
    }


}
