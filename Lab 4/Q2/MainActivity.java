package com.example.demo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);


       findViewById(R.id.btnCupcake).setOnClickListener(v ->
               showToast("Android Cupcake", R.drawable.cupcake));


       findViewById(R.id.btnKitKat).setOnClickListener(v ->
               showToast("Android KitKat", R.drawable.kitkat));


       findViewById(R.id.btnLollipop).setOnClickListener(v ->
               showToast("Android Lollipop", R.drawable.lollipop));


       findViewById(R.id.btnPie).setOnClickListener(v ->
               showToast("Android Pie", R.drawable.pie));
   }


   private void showToast(String message, int imageRes) {
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


