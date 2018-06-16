package com.sachin.procalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    private ImageButton entrepreneurBtn;
    private ImageButton professionalBtn;
    private ImageButton studentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        entrepreneurBtn = (ImageButton)findViewById(R.id.entrepreneurOptionButton);
        professionalBtn = (ImageButton)findViewById(R.id.professionalOptionButton);
        studentBtn = (ImageButton)findViewById(R.id.studentOptionButton);

        entrepreneurBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentEntrepreneurActivity = new Intent(secondActivity.this, entrepreneurActivity.class);
                startActivity(intentEntrepreneurActivity);
            }
        });

        professionalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfessionalActivity = new Intent(secondActivity.this, professionalActivity.class);
                startActivity(intentProfessionalActivity);
            }
        });

        studentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStudentActivity = new Intent(secondActivity.this, studentActivity.class);
                startActivity(intentStudentActivity);
            }
        });

    }
}
