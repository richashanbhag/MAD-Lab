package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    TextView txtContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txtContent = findViewById(R.id.txtContent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.workout) {
            txtContent.setText(
                    "🏋️ Workout Plans\n\n" +
                            "• Weight Loss\n" +
                            "• Cardio\n" +
                            "• Muscle Gain"
            );

        }
        else if (id == R.id.trainers) {
            txtContent.setText(
                    "👨‍🏫 Trainers\n\n" +
                            "• John – Strength Training\n" +
                            "• Sarah – Cardio Specialist"
            );

        }
        else if (id == R.id.membership) {
            txtContent.setText("Membership:\nBasic - ₹2000/month\nPremium - ₹3500/month");
        }
        else if (id == R.id.home) {
            txtContent.setText("Welcome to XYZ Fitness Center!");
        }
        else if (id == R.id.about) {
            txtContent.setText("About Us:\nWe provide professional fitness training.");
        }
        else if (id == R.id.contact) {
            txtContent.setText("Contact Us:\nPhone: 9876543210\nEmail: xyzfitness@gmail.com");
        }

        return true;
    }

}
