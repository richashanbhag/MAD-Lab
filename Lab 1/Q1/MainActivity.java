package com.example.demo;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Spinner fontSpinner;
    SeekBar sizeSeekBar;
    Button redBtn, blueBtn, greenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        fontSpinner = findViewById(R.id.fontSpinner);
        sizeSeekBar = findViewById(R.id.sizeSeekBar);
        redBtn = findViewById(R.id.redBtn);
        blueBtn = findViewById(R.id.blueBtn);
        greenBtn = findViewById(R.id.greenBtn);


        String[] fonts = {"Normal", "Bold", "Italic", "Bold Italic"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, fonts);
        fontSpinner.setAdapter(adapter);

        fontSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, android.view.View view, int position, long id) {
                switch (position) {
                    case 0: textView.setTypeface(null, Typeface.NORMAL); break;
                    case 1: textView.setTypeface(null, Typeface.BOLD); break;
                    case 2: textView.setTypeface(null, Typeface.ITALIC); break;
                    case 3: textView.setTypeface(null, Typeface.BOLD_ITALIC); break;
                }
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });


        sizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setTextSize(progress);
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });


        redBtn.setOnClickListener(v -> textView.setTextColor(Color.RED));
        blueBtn.setOnClickListener(v -> textView.setTextColor(Color.BLUE));
        greenBtn.setOnClickListener(v -> textView.setTextColor(Color.GREEN));
    }
}
