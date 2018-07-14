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
    int cuurentHour, currentMinute;
    String format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighthour);

        startButton = (ImageButton)findViewById(R.id.startButton);
        endButton = (ImageButton)findViewById(R.id.endButton);
        startTime = (TextView)findViewById(R.id.startTime);
        endTime = (TextView)findViewById(R.id.endTime);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentTime = Calendar.getInstance();
                cuurentHour = currentTime.get(Calendar.HOUR_OF_DAY);
                currentMinute = currentTime.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(eightHourActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {

                        if(hourOfDay == 0) {
                            hourOfDay = 12;
                            format = "AM";
                        }
                        else if(hourOfDay == 12) {
                            format="PM";
                        }
                        else if(hourOfDay >= 12) {
                            hourOfDay -= 12;
                            format = "PM";
                        }
                        else {
                            format = "AM";
                        }

                        startTime.setText(String.format("%02d:%02d", hourOfDay, minute) + " " + format);
                    }
                }, cuurentHour, currentMinute, false);
                timePickerDialog.show();
            }
        });

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentTime = Calendar.getInstance();
                cuurentHour = currentTime.get(Calendar.HOUR_OF_DAY);
                currentMinute = currentTime.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(eightHourActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {

                        if(hourOfDay == 0) {
                            hourOfDay = 12;
                            format = "AM";
                        }
                        else if(hourOfDay == 12) {
                            format="PM";
                        }
                        else if(hourOfDay >= 12) {
                            hourOfDay -= 12;
                            format = "PM";
                        }
                        else {
                            format = "AM";
                        }

                        endTime.setText(String.format("%02d:%02d", hourOfDay, minute) + " " + format);
                    }
                }, cuurentHour, currentMinute, false);
                timePickerDialog.show();
            }
        });
    }
}
