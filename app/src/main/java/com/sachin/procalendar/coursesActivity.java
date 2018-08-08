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

public class coursesActivity extends AppCompatActivity {

    private ImageButton backButton;                                                                 // image button variable to go previous page and clears numOfCourses

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        backButton = (ImageButton)findViewById(R.id.backPageButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStudentActivity = new Intent(coursesActivity.this, studentActivity.class);
                startActivity(intentStudentActivity);
            }
        });
    }
}
