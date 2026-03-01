package com.example.lab5_q1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public  class ConfirmationActivity extends AppCompatActivity {
    TextView vehicleDetails;
    Button Submit,edit;
    public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
    vehicleDetails=findViewById(R.id.VehicleDetails);
    Submit=findViewById(R.id.buttonConfirm);
    edit=findViewById(R.id.editText);
    String VehicleNo=getIntent().getStringExtra("VehicleNo");
    String RC=getIntent().getStringExtra("RC");
    String VehicleType=getIntent().getStringExtra("VehicleType");
vehicleDetails.setText("Vehicle No: "+VehicleNo+"\n"+"RC: "+RC+"\n"+"Vehicle Type: "+VehicleType);
Submit.setOnClickListener(v->{
    int serial=new Random().nextInt(1000)+1;
    Toast.makeText(this, "Parking done with serial no:"+serial, Toast.LENGTH_SHORT).show();
});
edit.setOnClickListener(v->finish());
    }
}
