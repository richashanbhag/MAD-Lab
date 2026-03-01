package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textResult = findViewById(R.id.textResult);

        String movie = getIntent().getStringExtra("movie");
        String theatre = getIntent().getStringExtra("theatre");
        String date = getIntent().getStringExtra("date");
        String time = getIntent().getStringExtra("time");
        String ticketType = getIntent().getStringExtra("ticketType");
        int seats = getIntent().getIntExtra("seats", 0);

        textResult.setText(
                "----- Booking Details -----\n\n" +
                        "Movie: " + movie + "\n" +
                        "Theatre: " + theatre + "\n" +
                        "Date: " + date + "\n" +
                        "Time: " + time + "\n" +
                        "Ticket Type: " + ticketType + "\n" +
                        "Available Seats: " + seats
        );
    }
}
