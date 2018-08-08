package com.sachin.procalendar;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class studentActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText commuteTime;
    TimePickerDialog timePickerDialog;

    CheckBox eightHourCheckBox;

    ImageButton quickSetupButton;
    private ImageButton backButton;                                                                 // image button variable to go previous page

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Spinner eduLevelSpinner = findViewById(R.id.educationLevelDropDown);

        commuteTime = (EditText)findViewById(R.id.commuteTime);

        eightHourCheckBox = (CheckBox)findViewById(R.id.checkBox);

        quickSetupButton = (ImageButton)findViewById(R.id.quickSetupButton);

        backButton = (ImageButton)findViewById(R.id.backPageButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentOccupationActivity = new Intent(studentActivity.this, occupationActivity.class);
                startActivity(intentOccupationActivity);
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,           // reference spinner/drop-down with array created
                R.array.student_eduLevel, android.R.layout.simple_spinner_item);                    // layout file for single item
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);             // layout for drop-down item
        eduLevelSpinner.setAdapter(adapter);

        eduLevelSpinner.setOnItemSelectedListener(this);

        commuteTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                                                        // when commuteTime clicked

                timePickerDialog = new TimePickerDialog(studentActivity.this, new TimePickerDialog.OnTimeSetListener() {   // initialize TimerPicker Dialog
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {      // allows user to choose time

                        commuteTime.setText(hourOfDay + " hour(s) " + minutes + " minute(s)");          // how display in EditText after
                    }
                }, 0, 0, false);
                timePickerDialog.show();
            }
        });

        eightHourCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                                                        // view is checkbox which user interracts with
                CheckBox temp = (CheckBox)view;
                if(temp.isChecked()) {
                    Intent intentSecondActivity = new Intent(studentActivity.this, eightHourActivity.class);
                    startActivity(intentSecondActivity);
                }
//                else {
//
//                }
            }
        });

        quickSetupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentQuickSetupPopup = new Intent(studentActivity.this, quickSetupPopupActivity.class);
                startActivity(intentQuickSetupPopup);
            }
        });
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
