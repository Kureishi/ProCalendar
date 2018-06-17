package com.sachin.procalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class studentActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Spinner eduLevelSpinner = findViewById(R.id.educationLevelDropDown);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,           // reference spinner/drop-down with array created
                R.array.student_eduLevel, android.R.layout.simple_spinner_item);                    // layout file for single item
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);             // layout for drop-down item
        eduLevelSpinner.setAdapter(adapter);

        eduLevelSpinner.setOnItemSelectedListener(this);
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
