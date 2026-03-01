package com.example.lab5_q1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerVehicle;
    EditText vehicleNo;
    EditText rc;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        spinnerVehicle = findViewById(R.id.spinnervehicle);
        vehicleNo = findViewById(R.id.vehicleNo);
        rc = findViewById(R.id.rc);
        buttonSubmit = findViewById(R.id.buttonSubmit);
String[] vehicles={"car","bike","truck"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                vehicles
        );
        spinnerVehicle.setAdapter(adapter);
        buttonSubmit.setOnClickListener(v->{
            String VehicleNo=vehicleNo.getText().toString();
            String RC=rc.getText().toString();
            String VehicleType=spinnerVehicle.getSelectedItem().toString();
            Intent intent= new Intent(MainActivity.this, ConfirmationActivity.class);
            intent.putExtra("VehicleNo",VehicleNo);
            intent.putExtra("RC",RC);
            intent.putExtra("VehicleType",VehicleType);
            startActivity(intent);
        });



    }
}
