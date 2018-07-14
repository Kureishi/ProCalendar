package com.sachin.procalendar;

import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class quickSetupActivity extends AppCompatActivity{

    ImageButton startButton;
    ImageButton endButton;
    TextView startTime;
    TextView endTime;

    Calendar currentTime;
    int currentHour, currentMinute;
    String format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_setup_cardview);

        // Done like this since android.support.widget.GridLayout can't be casted to android.widget.GridLayout
        android.support.v7.widget.GridLayout mainGrid = (android.support.v7.widget.GridLayout)findViewById(R.id.mainGrid);

        startButton = (ImageButton)findViewById(R.id.startButton);
        endButton = (ImageButton)findViewById(R.id.endButton);
        startTime = (TextView)findViewById(R.id.startTime);
        endTime = (TextView)findViewById(R.id.endTime);

        //setSingleEvent(mainGrid);
        setToggleEvent(mainGrid);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentTime = Calendar.getInstance();
                currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
                currentMinute = currentTime.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(quickSetupActivity.this, new TimePickerDialog.OnTimeSetListener() {
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
                }, currentHour, currentMinute, false);
                timePickerDialog.show();
            }
        });

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentTime = Calendar.getInstance();
                currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
                currentMinute = currentTime.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(quickSetupActivity.this, new TimePickerDialog.OnTimeSetListener() {
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
                }, currentHour, currentMinute, false);
                timePickerDialog.show();
            }
        });
    }

    private void setToggleEvent(android.support.v7.widget.GridLayout mainGrid) {
        for(int i=0; i < mainGrid.getChildCount(); i++) {
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(quickSetupActivity.this, "State True", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(quickSetupActivity.this, "State False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(android.support.v7.widget.GridLayout mainGrid) {
        for(int i=0; i < mainGrid.getChildCount(); i++) {                                           // loop all items in grid
            CardView cardView = (CardView) mainGrid.getChildAt(i);                                 // since all items are CardView
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(quickSetupActivity.this, "Clicked at " + finalI, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
