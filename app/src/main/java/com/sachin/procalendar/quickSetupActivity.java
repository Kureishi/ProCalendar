package com.sachin.procalendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class quickSetupActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_setup);

        // Done like this since android.support.widget.GridLayout can't be casted to android.widget.GridLayout
        android.support.v7.widget.GridLayout mainGrid = (android.support.v7.widget.GridLayout)findViewById(R.id.mainGrid);

        setSingleEvent(mainGrid);
    }

//    private void setToggleEvent(android.support.v7.widget.GridLayout mainGrid) {
//        for(int i=0; i < mainGrid.getChildCount(); i++) {
//            ImageView imageView = (ImageView)mainGrid.getChildAt(i);
//            imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                }
//            });
//        }
//    }

    private void setSingleEvent(android.support.v7.widget.GridLayout mainGrid) {
        for(int i=0; i < mainGrid.getChildCount(); i++) {                                           // loop all items in grid
            ImageView imageView = (ImageView)mainGrid.getChildAt(i);                                // since all items are ImageView
            final int finalI = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(quickSetupActivity.this, "Clicked at " + finalI, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
