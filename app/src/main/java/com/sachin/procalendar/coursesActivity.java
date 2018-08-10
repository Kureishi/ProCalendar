package com.sachin.procalendar;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class coursesActivity extends AppCompatActivity{

    private ScrollView sCourseList;
    private ImageButton nextButton;
    private TextView mNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        sCourseList = findViewById(R.id.courseList);
        nextButton = (ImageButton)findViewById(R.id.nextPageButton);

        mNum = findViewById(R.id.num);

        //Getting number of courses from activity_student
        Intent i = getIntent();
        String text = i.getStringExtra ( "TextBox");
        mNum.setText(text);

        //Creating EditTexts, need to add loop
        EditText myEditText = new EditText(coursesActivity.this);
        myEditText.setLayoutParams(new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT, ScrollView.LayoutParams.WRAP_CONTENT));
        sCourseList.addView(myEditText);
        myEditText.setHint("Course name");

        //Need to grab course names
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStudentActivity = new Intent(coursesActivity.this, studentActivity.class);
                intentStudentActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intentStudentActivity);
            }
        });
    }
}
