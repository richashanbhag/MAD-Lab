package com.example.myapplication; 
 
import android.os.Bundle; 
import android.widget.ImageView; 
import android.widget.PopupMenu; 
import android.widget.Toast; 
 
import androidx.appcompat.app.AppCompatActivity; 
 
public class MainActivity extends AppCompatActivity { 
 
    ImageView menuIcon, displayImage; 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main); 
 
        menuIcon = findViewById(R.id.menuIcon); 
        displayImage = findViewById(R.id.displayImage); 
 
        // When menu icon is clicked 
        menuIcon.setOnClickListener(view -> { 
 
            // Create popup menu 
            PopupMenu popupMenu = 
                    new PopupMenu(MainActivity.this, view); 
 
            // Load menu items 
            popupMenu.getMenuInflater() 
                    .inflate(R.menu.popup_menu, 
                            popupMenu.getMenu()); 
 
            // Handle menu item click 
            popupMenu.setOnMenuItemClickListener(item -> { 
 
                if (item.getItemId() == R.id.image1) { 
 
                    // Set Image 1 
                    displayImage.setImageResource( 
                            android.R.drawable.ic_menu_camera); 
 
                    Toast.makeText(MainActivity.this, 
                            "Image - 1 Selected", 
                            Toast.LENGTH_SHORT).show(); 
 
                    return true; 
                } 
 
                else if (item.getItemId() == R.id.image2) { 
 
                    // Set Image 2 
                    displayImage.setImageResource( 
                            android.R.drawable.ic_menu_gallery); 
 
                    Toast.makeText(MainActivity.this, 
                            "Image - 2 Selected", 
                            Toast.LENGTH_SHORT).show(); 
 
                    return true; 
                } 
 
                return false; 
            }); 
 
            // Show popup 
            popupMenu.show(); 
        }); 
    } 
} 

 
