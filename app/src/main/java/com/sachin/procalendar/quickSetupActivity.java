package com.sachin.procalendar;

import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class quickSetupActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageButton startButton;
    ImageButton endButton;
    TextView startTime;
    TextView endTime;

    Calendar currentTime;
    int currentHour, currentMinute;
    int startHourDay, endHourDay;
    String format;

    String startString, endString;
    int startNum, endNum, timeSlice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_setup_cardview);

        final LinearLayout firstLL = (LinearLayout) findViewById(R.id.first_11);
        final LinearLayout secondLL = (LinearLayout) findViewById(R.id.second_11);

        // Done like this since android.support.widget.GridLayout can't be casted to android.widget.GridLayout
        android.support.v7.widget.GridLayout mainGrid = (android.support.v7.widget.GridLayout)findViewById(R.id.mainGrid);

        startButton = (ImageButton)findViewById(R.id.startButton);
        endButton = (ImageButton)findViewById(R.id.endButton);
        startTime = (TextView)findViewById(R.id.startTime);
        endTime = (TextView)findViewById(R.id.endTime);

//        startString = startTime.getText().toString();
//        endString = endTime.getText().toString();
//
//        startNum = Integer.parseInt(startString);
//        endNum = Integer.parseInt(endString);

        daySelectColumn(mainGrid);                                                                  // Implement to select column with day

        Spinner classTypeDropDown = findViewById(R.id.classTypeDropDown);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.quick_classTypeDrop, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        classTypeDropDown.setAdapter(adapter);

        classTypeDropDown.setOnItemSelectedListener(this);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int visibility = firstLL.getVisibility();

                if(visibility==View.GONE) {
                    firstLL.setVisibility(View.VISIBLE);
                    secondLL.setVisibility(View.GONE);
                }

                currentTime = Calendar.getInstance();
                currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
                currentMinute = currentTime.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(quickSetupActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {

                        if(hourOfDay == 0) {
//                            hourOfDay = 12;
                            format = "AM";
                        }
                        else if(hourOfDay == 12) {
                            format="PM";
                        }
                        else if(hourOfDay >= 12) {
//                            hourOfDay -= 12;
                            format = "PM";
                        }
                        else {
                            format = "AM";
                        }

                        startHourDay = hourOfDay;

                        startTime.setText(String.format("%02d:%02d", startHourDay, minute) + " " + format);
                    }
                }, currentHour, currentMinute, false);
                timePickerDialog.show();
            }
        });

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int visibility = secondLL.getVisibility();

                if(visibility==View.GONE) {
                    secondLL.setVisibility(View.VISIBLE);
                    firstLL.setVisibility(View.GONE);
                }

                currentTime = Calendar.getInstance();
                currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
                currentMinute = currentTime.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(quickSetupActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {

                        if(hourOfDay == 0) {
//                            hourOfDay = 12;
                            format = "AM";
                        }
                        else if(hourOfDay == 12) {
                            format="PM";
                        }
                        else if(hourOfDay >= 12) {
//                            hourOfDay -= 12;
                            format = "PM";
                        }
                        else {
                            format = "AM";
                        }

                        endHourDay = hourOfDay;

                        endTime.setText(String.format("%02d:%02d", endHourDay, minute) + " " + format);
                    }
                }, currentHour, currentMinute, false);
                timePickerDialog.show();
            }
        });
    }

    private void daySelectColumn (final android.support.v7.widget.GridLayout mainGrid) {
        ImageButton saturdayButton = (ImageButton)findViewById(R.id.saturdayButton);
        ImageButton sundayButton = (ImageButton)findViewById(R.id.sundayButton);
        ImageButton mondayButton = (ImageButton)findViewById(R.id.mondayButton);
        ImageButton tuesdayButton = (ImageButton)findViewById(R.id.tuesdayButton);
        ImageButton wednesdayButton = (ImageButton)findViewById(R.id.wednesdayButton);
        ImageButton thursdayButton = (ImageButton)findViewById(R.id.thursdayButton);
        ImageButton fridayButton = (ImageButton)findViewById(R.id.fridayButton);

        saturdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(quickSetupActivity.this, "Start: " + startHourDay, Toast.LENGTH_SHORT).show();
                Toast.makeText(quickSetupActivity.this, "End: " + endHourDay, Toast.LENGTH_SHORT).show();
                timeSlice = endHourDay - startHourDay;
                Toast.makeText(quickSetupActivity.this, "Timeslice: " + timeSlice, Toast.LENGTH_SHORT).show();

                for (int i=startHourDay; i <= endHourDay; i++) {
                    CardView cardView = (CardView) mainGrid.getChildAt(i);
                    cardView.setCardBackgroundColor(Color.parseColor("#FFCC0000"));
                }
            }
        });

        sundayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(quickSetupActivity.this, "Start: " + startHourDay, Toast.LENGTH_SHORT).show();
                Toast.makeText(quickSetupActivity.this, "End: " + endHourDay, Toast.LENGTH_SHORT).show();
                timeSlice = endHourDay - startHourDay;
                Toast.makeText(quickSetupActivity.this, "Timeslice: " + timeSlice, Toast.LENGTH_SHORT).show();

                for (int i=(startHourDay+24); i <= (endHourDay+24); i++) {
                    CardView cardView = (CardView) mainGrid.getChildAt(i);
                    cardView.setCardBackgroundColor(Color.parseColor("#FFCC0000"));
                }
            }
        });

        mondayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(quickSetupActivity.this, "Start: " + startHourDay, Toast.LENGTH_SHORT).show();
                Toast.makeText(quickSetupActivity.this, "End: " + endHourDay, Toast.LENGTH_SHORT).show();
                timeSlice = endHourDay - startHourDay;
                Toast.makeText(quickSetupActivity.this, "Timeslice: " + timeSlice, Toast.LENGTH_SHORT).show();

                for (int i=(startHourDay+48); i <= (endHourDay+48); i++) {
                    CardView cardView = (CardView) mainGrid.getChildAt(i);
                    cardView.setCardBackgroundColor(Color.parseColor("#FFCC0000"));
                }
            }
        });

        tuesdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(quickSetupActivity.this, "Start: " + startHourDay, Toast.LENGTH_SHORT).show();
                Toast.makeText(quickSetupActivity.this, "End: " + endHourDay, Toast.LENGTH_SHORT).show();
                timeSlice = endHourDay - startHourDay;
                Toast.makeText(quickSetupActivity.this, "Timeslice: " + timeSlice, Toast.LENGTH_SHORT).show();

                for (int i=(startHourDay+72); i <= (endHourDay+72); i++) {
                    CardView cardView = (CardView) mainGrid.getChildAt(i);
                    cardView.setCardBackgroundColor(Color.parseColor("#FFCC0000"));
                }
            }
        });

        wednesdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(quickSetupActivity.this, "Start: " + startHourDay, Toast.LENGTH_SHORT).show();
                Toast.makeText(quickSetupActivity.this, "End: " + endHourDay, Toast.LENGTH_SHORT).show();
                timeSlice = endHourDay - startHourDay;
                Toast.makeText(quickSetupActivity.this, "Timeslice: " + timeSlice, Toast.LENGTH_SHORT).show();

                for (int i=(startHourDay+96); i <= (endHourDay+96); i++) {
                    CardView cardView = (CardView) mainGrid.getChildAt(i);
                    cardView.setCardBackgroundColor(Color.parseColor("#FFCC0000"));
                }
            }
        });

        thursdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(quickSetupActivity.this, "Start: " + startHourDay, Toast.LENGTH_SHORT).show();
                Toast.makeText(quickSetupActivity.this, "End: " + endHourDay, Toast.LENGTH_SHORT).show();
                timeSlice = endHourDay - startHourDay;
                Toast.makeText(quickSetupActivity.this, "Timeslice: " + timeSlice, Toast.LENGTH_SHORT).show();

                for (int i=(startHourDay+120); i <= (endHourDay+120); i++) {
                    CardView cardView = (CardView) mainGrid.getChildAt(i);
                    cardView.setCardBackgroundColor(Color.parseColor("#FFCC0000"));
                }
            }
        });

        fridayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(quickSetupActivity.this, "Start: " + startHourDay, Toast.LENGTH_SHORT).show();
                Toast.makeText(quickSetupActivity.this, "End: " + endHourDay, Toast.LENGTH_SHORT).show();
                timeSlice = endHourDay - startHourDay;
                Toast.makeText(quickSetupActivity.this, "Timeslice: " + timeSlice, Toast.LENGTH_SHORT).show();

                for (int i=(startHourDay+144); i <= (endHourDay+144); i++) {
                    CardView cardView = (CardView) mainGrid.getChildAt(i);
                    cardView.setCardBackgroundColor(Color.parseColor("#FFCC0000"));
                }
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();                                  // take item at position 'i' and save into 'text'
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
