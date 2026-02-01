package com.example.demo;


import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class ResultActivity extends AppCompatActivity {


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_result);


       TextView resultText = findViewById(R.id.resultText);


       double n1 = Double.parseDouble(getIntent().getStringExtra("num1"));
       double n2 = Double.parseDouble(getIntent().getStringExtra("num2"));
       String op = getIntent().getStringExtra("operator");


       double result = 0;
       switch (op) {
           case "+": result = n1 + n2; break;
           case "-": result = n1 - n2; break;
           case "×": result = n1 * n2; break;
           case "÷": result = n2 != 0 ? n1 / n2 : 0; break;
       }


       resultText.setText(n1 + " " + op + " " + n2 + " = " + result);
   }
}
