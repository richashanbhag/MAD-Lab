package com.example.demo;


import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       Toast.makeText(this, "onCreate() called", Toast.LENGTH_SHORT).show();
   }


   @Override
   protected void onStart() {
       super.onStart();
       Toast.makeText(this, "onStart() called", Toast.LENGTH_SHORT).show();
   }


   @Override
   protected void onResume() {
       super.onResume();
       Toast.makeText(this, "onResume() called", Toast.LENGTH_SHORT).show();
   }
}
