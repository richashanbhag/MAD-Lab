package com.example.demo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


import com.example.demo.ResultActivity;


public class MainActivity extends AppCompatActivity {


   TextView display;
   String num1 = "", num2 = "", operator = "";
   boolean isSecondNumber = false;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);


       display = findViewById(R.id.display);
   }


   public void onDigitClick(View view) {
       Button btn = (Button) view;
       if (!isSecondNumber) {
           num1 += btn.getText().toString();
           display.setText(num1);
       } else {
           num2 += btn.getText().toString();
           display.setText(num2);
       }
   }


   public void onOperatorClick(View view) {
       Button btn = (Button) view;
       operator = btn.getText().toString();
       isSecondNumber = true;
   }


   public void onClearClick(View view) {
       num1 = num2 = operator = "";
       isSecondNumber = false;
       display.setText("0");
   }


   public void onEqualClick(View view) {
       if (num1.isEmpty() || num2.isEmpty()) return;


       Intent intent = new Intent(this, ResultActivity.class);
       intent.putExtra("num1", num1);
       intent.putExtra("num2", num2);
       intent.putExtra("operator", operator);
       startActivity(intent);
   }
}
