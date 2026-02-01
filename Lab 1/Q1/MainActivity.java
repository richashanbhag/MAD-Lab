package com.example.demo;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


   TextView textView;
   float currentSize = 18f;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);


       textView = findViewById(R.id.textView);
   }


   public void makeRed(View view) {
       textView.setTextColor(Color.RED);
   }


   public void makeBlue(View view) {
       textView.setTextColor(Color.BLUE);
   }


   public void makeBold(View view) {
       textView.setTypeface(null, Typeface.BOLD);
   }


   public void makeItalic(View view) {
       textView.setTypeface(null, Typeface.ITALIC);
   }


   public void increaseSize(View view) {
       currentSize += 2;
       textView.setTextSize(currentSize);
   }
}
