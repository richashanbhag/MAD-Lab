package com.example.demo;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


   ListView sportsListView;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);


       sportsListView = findViewById(R.id.sportsListView);


       
       String[] sports = {
               "Cricket",
               "Football",
               "Tennis",
               "Basketball",
               "Hockey",
               "Badminton",
               "Volleyball"
       };


       
       ArrayAdapter<String> adapter = new ArrayAdapter<>(
               this,
               android.R.layout.simple_list_item_1,
               sports
       );


       sportsListView.setAdapter(adapter);


       
       sportsListView.setOnItemClickListener((parent, view, position, id) -> {
           String selectedSport = sports[position];
           Toast.makeText(MainActivity.this,
                   "Selected Sport: " + selectedSport,
                   Toast.LENGTH_SHORT).show();
       });
   }
}


