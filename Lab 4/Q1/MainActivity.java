package com.example.demo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


   Button btnShow;
   ToggleButton toggleShow;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);


       btnShow = findViewById(R.id.btnShow);
       toggleShow = findViewById(R.id.toggleShow);


       btnShow.setOnClickListener(v -> showCustomToast("Button Clicked!", R.drawable.button_image));


       toggleShow.setOnCheckedChangeListener((buttonView, isChecked) -> {
           if (isChecked) {
               showCustomToast("Toggle ON", R.drawable.toggle_on);
           } else {
               showCustomToast("Toggle OFF", R.drawable.toggle_off);
           }
       });
   }


   private void showCustomToast(String message, int imageRes) {
       LayoutInflater inflater = getLayoutInflater();
       View layout = inflater.inflate(R.layout.custom_toast, null);


       ImageView image = layout.findViewById(R.id.toastImage);
       TextView text = layout.findViewById(R.id.toastText);


       image.setImageResource(imageRes);
       text.setText(message);


       Toast toast = new Toast(getApplicationContext());
       toast.setDuration(Toast.LENGTH_SHORT);
       toast.setView(layout);
       toast.show();
   }
}


