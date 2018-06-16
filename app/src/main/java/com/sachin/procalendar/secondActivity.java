package com.sachin.procalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        test = (TextView)findViewById(R.id.test);
        test.setText(MainActivity.uName);
    }
}
