package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerMovie, spinnerTheatre;
    Button btnDate, btnTime, btnBook, btnReset;
    ToggleButton toggleTicket;

    String selectedDate = "";
    String selectedTime = "";

    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerMovie = findViewById(R.id.spinnerMovie);
        spinnerTheatre = findViewById(R.id.spinnerTheatre);
        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);
        btnBook = findViewById(R.id.btnBook);
        btnReset = findViewById(R.id.btnReset);
        toggleTicket = findViewById(R.id.toggleTicket);

        calendar = Calendar.getInstance();

        String[] movies = {"Avengers", "Inception", "Interstellar"};
        String[] theatres = {"PVR", "INOX", "Cinepolis"};

        ArrayAdapter<String> movieAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, movies);
        spinnerMovie.setAdapter(movieAdapter);

        ArrayAdapter<String> theatreAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, theatres);
        spinnerTheatre.setAdapter(theatreAdapter);

        // Date Picker
        btnDate.setOnClickListener(v -> {
            DatePickerDialog dp = new DatePickerDialog(this,
                    (view, year, month, day) -> {
                        selectedDate = day + "/" + (month + 1) + "/" + year;
                        btnDate.setText(selectedDate);
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
            dp.show();
        });

        // Time Picker
        btnTime.setOnClickListener(v -> {
            TimePickerDialog tp = new TimePickerDialog(this,
                    (view, hour, minute) -> {
                        selectedTime = hour + ":" + minute;
                        btnTime.setText(selectedTime);
                    },
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    true);
            tp.show();
        });

        // Premium rule
        toggleTicket.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                if (currentHour < 12) {
                    btnBook.setEnabled(false);
                    Toast.makeText(this,
                            "Premium booking allowed only after 12 PM",
                            Toast.LENGTH_LONG).show();
                } else {
                    btnBook.setEnabled(true);
                }
            } else {
                btnBook.setEnabled(true);
            }
        });

        // Book Now
        btnBook.setOnClickListener(v -> {

            if (selectedDate.isEmpty() || selectedTime.isEmpty()) {
                Toast.makeText(this,
                        "Please select date and time",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            String movie = spinnerMovie.getSelectedItem().toString();
            String theatre = spinnerTheatre.getSelectedItem().toString();
            String ticketType = toggleTicket.isChecked() ? "Premium" : "Standard";

            int seats = new Random().nextInt(50) + 1;

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("movie", movie);
            intent.putExtra("theatre", theatre);
            intent.putExtra("date", selectedDate);
            intent.putExtra("time", selectedTime);
            intent.putExtra("ticketType", ticketType);
            intent.putExtra("seats", seats);

            startActivity(intent);
        });

        // Reset
        btnReset.setOnClickListener(v -> {

            spinnerMovie.setSelection(0);
            spinnerTheatre.setSelection(0);
            toggleTicket.setChecked(false);

            selectedDate = "";
            selectedTime = "";

            btnDate.setText("Select Show Date");
            btnTime.setText("Select Showtime");
        });
    }
}

