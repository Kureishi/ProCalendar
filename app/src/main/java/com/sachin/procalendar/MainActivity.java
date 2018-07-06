package com.sachin.procalendar;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

//public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//
//    public void datePicker(View view){
//
//        DatePickerFragment fragment = new DatePickerFragment();
//        fragment.show(getSupportFragmentManager(), "date");
//    }
//
//    private void setDate(final Calendar calendar) {
//        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
//        ((TextView) findViewById(R.id.showDate)).setText(dateFormat.format(calendar.getTime()));
//
//
//    }
//
//    public void onDateSet(DatePicker view, int year, int month, int day) {
//        Calendar cal = new GregorianCalendar(year, month, day);
//        setDate(cal);
//    }
//
//    public static class DatePickerFragment extends DialogFragment {
//
//        @Override
//        public Dialog onCreateDialog(Bundle savedInstanceState){
//            final Calendar c = Calendar.getInstance();
//            int year = c.get(Calendar.YEAR);
//            int month = c.get(Calendar.MONTH);
//            int day = c.get(Calendar.DAY_OF_MONTH);
//
//            return new DatePickerDialog(getActivity(),
//                    (DatePickerDialog.OnDateSetListener)
//                            getActivity(),year, month, day);
//        }
//    }
//}

public class MainActivity extends AppCompatActivity {

    public static String uName;
    public static String uEmail;
    public static String uDate;

    private EditText name, email;
    private TextView dOB;                                                                           // text view to select DoB

    private DatePickerDialog.OnDateSetListener dateSetListener;

    private ImageButton nextButton;                                                                 // image button variable to go next page

    private final int STORAGE_PERMISSION_CODE = 1;                                                  // identify request
    private final int LOCATION_REQUEST_CODE = 2;
    private final int AUDIO_REQUEST_CODE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.nameInput);
        email = (EditText)findViewById(R.id.emailInput);
        dOB = (TextView)findViewById(R.id.dateOfBirth);

        nextButton = (ImageButton)findViewById(R.id.nextPageButton);
        nextButton.setEnabled(false);                                                               // disabled at beginning


        dOB.setOnClickListener(new View.OnClickListener() {                                         // when click on the TextView
            @Override
            public void onClick(View view) {                                                        // once clicked, by default go to current date
                Calendar cal = Calendar.getInstance();                                              // create a Calendar object
                int year = cal.get(Calendar.YEAR);                                                  // get current year
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);                                           // since different number of days in month

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_DeviceDefault_Dialog,                           // style of calendar
                        dateSetListener,
                        year, month, day);                                                          // set to current date

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));     // background transparent
                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;                                                                  // since January start at 0

                String date = day + "/" + month + "/" + year;                                       // set format to display it in
                dOB.setText(date);                                                                  // set the text to date (becomes content)
            }
        };

        name.addTextChangedListener(signUpTextWatcher);                                             // when the text in field changes/added
        email.addTextChangedListener(signUpTextWatcher);
        dOB.addTextChangedListener(signUpTextWatcher);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (ContextCompat.checkSelfPermission(MainActivity.this,                     // check if specified permission already granted
//                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(MainActivity.this, "Permission Already Granted", Toast.LENGTH_SHORT).show();
//                } else {
//                    requestStoragePermission();
//                }

                uName = name.getText().toString();
                uEmail = email.getText().toString();
                uDate = dOB.getText().toString();

                askPermission(Manifest.permission.READ_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE);
                askPermission(Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_REQUEST_CODE);
                askPermission(Manifest.permission.RECORD_AUDIO, AUDIO_REQUEST_CODE);

                Intent intentSecondActivity = new Intent(MainActivity.this, secondActivity.class);  // from Main to second screen
                startActivity(intentSecondActivity);
            }
        });
    }

//    private void requestStoragePermission() {
//        if(ActivityCompat.shouldShowRequestPermissionRationale(this,                         // show why need permission. if user denied before, but accesses it again
//                Manifest.permission.READ_EXTERNAL_STORAGE)) {
//            new AlertDialog.Builder(this)
//                    .setTitle("Permission Needed")
//                    .setMessage("Permission needed to access storage")                              // NOT FINALIZED (can be edited)
//                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {               // request permission only if click Ok
//                            ActivityCompat.requestPermissions(MainActivity.this, new String[]
//                                    {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
//                        }
//                    })
//
//                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            dialogInterface.dismiss();                                              // if cancel, dismiss the dialog (not alert user)
//                        }
//                    })
//
//                    .create().show();                                                               // create dialog and show it
//
//        } else {                                                                                    // just want to request permission (with Storage Permission code)
//            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
//        }
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == STORAGE_PERMISSION_CODE) {                                               // check result of permission
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {  // check if the permission was granted
//                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

    private void askPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {     // not have permission
            ActivityCompat.requestPermissions(this, new String[] {permission}, requestCode); // ask user for specific permission
        } else {
            Toast.makeText(this, "Permission Already Granted", Toast.LENGTH_SHORT).show();  // already have the permission
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case STORAGE_PERMISSION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case LOCATION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Location Permission Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Location Permission Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case AUDIO_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Record Audio Permission Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Record Audio Permission Denied", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private TextWatcher signUpTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {    // when type in or remove character
            String uNameInput = name.getText().toString();
            String uEmailInput = email.getText().toString();
            String uDateInput = dOB.getText().toString();

            nextButton.setEnabled(!uNameInput.isEmpty() && !uEmailInput.isEmpty() && !uDateInput.isEmpty());    // set to enable click
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
