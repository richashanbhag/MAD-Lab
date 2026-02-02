package com.example.demo;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


   CheckBox cbBurger, cbPizza, cbPasta, cbSandwich, cbCoffee;
   Button btnSubmit;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);


       cbBurger = findViewById(R.id.cbBurger);
       cbPizza = findViewById(R.id.cbPizza);
       cbPasta = findViewById(R.id.cbPasta);
       cbSandwich = findViewById(R.id.cbSandwich);
       cbCoffee = findViewById(R.id.cbCoffee);
       btnSubmit = findViewById(R.id.btnSubmit);


       btnSubmit.setOnClickListener(v -> {


           StringBuilder orderDetails = new StringBuilder();
           int total = 0;


           if (cbBurger.isChecked()) {
               orderDetails.append("Burger - ₹120\n");
               total += 120;
           }
           if (cbPizza.isChecked()) {
               orderDetails.append("Pizza - ₹250\n");
               total += 250;
           }
           if (cbPasta.isChecked()) {
               orderDetails.append("Pasta - ₹180\n");
               total += 180;
           }
           if (cbSandwich.isChecked()) {
               orderDetails.append("Sandwich - ₹100\n");
               total += 100;
           }
           if (cbCoffee.isChecked()) {
               orderDetails.append("Coffee - ₹80\n");
               total += 80;
           }


           Intent intent = new Intent(MainActivity.this, ResultActivity.class);
           intent.putExtra("order", orderDetails.toString());
           intent.putExtra("total", total);
           startActivity(intent);


           
           cbBurger.setEnabled(false);
           cbPizza.setEnabled(false);
           cbPasta.setEnabled(false);
           cbSandwich.setEnabled(false);
           cbCoffee.setEnabled(false);
           btnSubmit.setEnabled(false);
       });
   }
}
