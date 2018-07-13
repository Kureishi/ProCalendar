package com.sachin.procalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class quickSetupPopupActivity extends AppCompatActivity{

    ImageButton beginButton;

    ImageButton closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_setup_popup);

        beginButton = (ImageButton)findViewById(R.id.beginButton);
        closeButton = (ImageButton)findViewById(R.id.closeButton);

        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quickSetupPopupActivity.this, quickSetupActivity.class);
                startActivity(intent);
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(quickSetupPopupActivity.this, studentActivity.class);
                startActivity(intent2);
            }
        });
    }
}
