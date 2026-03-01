package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class resultActivity extends AppCompatActivity {

    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textResult = findViewById(R.id.textResult);

        String source = getIntent().getStringExtra("Source");
        String destination = getIntent().getStringExtra("Destination");
        String date = getIntent().getStringExtra("Date");
        String tripType = getIntent().getStringExtra("Type");

        textResult.setText(
                "----- Ticket Details -----\n\n" +
                        "Source: " + source + "\n" +
                        "Destination: " + destination + "\n" +
                        "Travel Date: " + date + "\n" +
                        "Trip Type: " + tripType
        );
    }
}
