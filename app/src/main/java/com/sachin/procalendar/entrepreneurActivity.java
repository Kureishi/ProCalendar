package com.sachin.procalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class entrepreneurActivity extends AppCompatActivity {

    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrepreneur);

        backButton = (ImageButton)findViewById(R.id.backPageButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentOccupationActivity = new Intent(entrepreneurActivity.this, occupationActivity.class);
                startActivity(intentOccupationActivity);
            }
        });
    }
}
