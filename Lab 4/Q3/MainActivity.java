package com.example.demo;


import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


   ToggleButton toggleMode;
   ImageView modeImage;
   Button btnChange;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);


       toggleMode = findViewById(R.id.toggleMode);
       modeImage = findViewById(R.id.modeImage);
       btnChange = findViewById(R.id.btnChange);


       
       toggleMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
           if (isChecked) {
               modeImage.setImageResource(R.drawable.wifi);
               Toast.makeText(this, "Current Mode: Wi-Fi", Toast.LENGTH_SHORT).show();
           } else {
               modeImage.setImageResource(R.drawable.mobile_data);
               Toast.makeText(this, "Current Mode: Mobile Data", Toast.LENGTH_SHORT).show();
           }
       });


       
       btnChange.setOnClickListener(v -> {
           toggleMode.toggle();  
       });
   }
}
