package com.example.demo;


import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class ResultActivity extends AppCompatActivity {


   TextView tvOrder, tvTotal;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_result);


       tvOrder = findViewById(R.id.tvOrder);
       tvTotal = findViewById(R.id.tvTotal);


       String order = getIntent().getStringExtra("order");
       int total = getIntent().getIntExtra("total", 0);


       tvOrder.setText(order);
       tvTotal.setText("Total Cost: ₹" + total);
   }
}


