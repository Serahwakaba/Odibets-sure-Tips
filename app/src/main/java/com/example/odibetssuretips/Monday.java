package com.example.odibetssuretips;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Monday extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);
        Button mMondayButton = (Button) findViewById(R.id.monbutton);
        mMondayButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

             Toast.makeText(Monday.this, "Hello World!", Toast.LENGTH_LONG).show();
            }
        });
        }



    }
