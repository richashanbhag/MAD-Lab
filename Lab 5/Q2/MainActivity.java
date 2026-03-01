package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

Spinner spinnersrc,spinnerdst;
Button date,btnsubmit,btnreset;
ToggleButton toggleButton;
String selectedDate="";
Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        spinnersrc=findViewById(R.id.spinnersrc);
        spinnerdst=findViewById(R.id.spinnerdst);
        date=findViewById(R.id.buttonDate);
        toggleButton=findViewById(R.id.toggleButton);
        btnsubmit=findViewById(R.id.btnSubmit);
        btnreset=findViewById(R.id.btnReset);
calendar=Calendar.getInstance();
    String[] cities={"Pune","Mumbai","delhi"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                cities
        );

        spinnersrc.setAdapter(adapter);
        spinnerdst.setAdapter(adapter);
        // Date Picker
        date.setOnClickListener(v -> {

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog =
                    new DatePickerDialog(this,
                            (view, y, m, d) -> {
                                selectedDate = d + "/" + (m + 1) + "/" + y;
                                date.setText(selectedDate);
                            },
                            year, month, day);

            datePickerDialog.show();
        });
        btnsubmit.setOnClickListener(v->{
            String source=spinnersrc.getSelectedItem().toString();
            String destination=spinnerdst.getSelectedItem().toString();
            String type=toggleButton.getText().toString();
            Intent intent=new Intent(this,resultActivity.class);
            intent.putExtra("Source",source);
            intent.putExtra("Destination",destination);
            intent.putExtra("Date",selectedDate);
            intent.putExtra("Type",type);
            startActivity(intent);

        });

        // Date Picker
        date.setOnClickListener(v -> {

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog =
                    new DatePickerDialog(this,
                            (view, y, m, d) -> {
                                selectedDate = d + "/" + (m + 1) + "/" + y;
                                date.setText(selectedDate);
                            },
                            year, month, day);

            datePickerDialog.show();
        });

    }
}
