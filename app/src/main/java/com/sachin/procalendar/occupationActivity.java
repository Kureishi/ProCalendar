package com.sachin.procalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class occupationActivity extends AppCompatActivity {

    private ImageButton entrepreneurBtn;
    private ImageButton professionalBtn;
    private ImageButton studentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_occupation);

        entrepreneurBtn = (ImageButton)findViewById(R.id.entrepreneurOptionButton);
        professionalBtn = (ImageButton)findViewById(R.id.professionalOptionButton);
        studentBtn = (ImageButton)findViewById(R.id.studentOptionButton);

        entrepreneurBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentEntrepreneurActivity = new Intent(occupationActivity.this, entrepreneurActivity.class);
                startActivity(intentEntrepreneurActivity);
            }
        });

        professionalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfessionalActivity = new Intent(occupationActivity.this, professionalActivity.class);
                startActivity(intentProfessionalActivity);
            }
        });

        studentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStudentActivity = new Intent(occupationActivity.this, studentActivity.class);
                startActivity(intentStudentActivity);
            }
        });

    }
}
