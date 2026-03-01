package com.example.myapplication; 
 
import android.app.AlertDialog; 
import android.os.Bundle; 
import android.text.SpannableString; 
import android.text.style.BackgroundColorSpan; 
import android.view.Menu; 
import android.view.MenuItem; 
import android.widget.EditText; 
import android.widget.TextView; 
import android.widget.Toast; 
 
import androidx.appcompat.app.AppCompatActivity; 
 
import java.util.Arrays; 
import java.util.Comparator; 
 
public class MainActivity extends AppCompatActivity { 
 
    TextView textContent; 
 
    String originalText = 
            "Digital Transformation is the integration of digital technology into all areas of business. " + 
                    "It changes how organizations operate and deliver value to customers. " + 
                    "Technologies like AI, cloud computing, and big data drive innovation and efficiency."; 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main); 
 
        textContent = findViewById(R.id.textContent); 
        textContent.setText(originalText); 
    } 
 
    // Create Options Menu 
    @Override 
    public boolean onCreateOptionsMenu(Menu menu) { 
        getMenuInflater().inflate(R.menu.menu_filter, menu); 
        return true; 
    } 
 
    // Handle Menu Click 
    @Override 
    public boolean onOptionsItemSelected(MenuItem item) { 
 
        if (item.getItemId() == R.id.search) { 
            showSearchDialog(); 
            return true; 
        } 
 
        if (item.getItemId() == R.id.highlight) { 
            showHighlightDialog(); 
            return true; 
        } 
 
        if (item.getItemId() == R.id.sort_alpha) { 
            sortAlphabetically(); 
            return true; 
        } 
 
        if (item.getItemId() == R.id.sort_relevance) { 
            sortByRelevance(); 
            return true; 
        } 
 
        return super.onOptionsItemSelected(item); 
    } 
 
    // SEARCH 
    private void showSearchDialog() { 
 
        EditText input = new EditText(this); 
 
        new AlertDialog.Builder(this) 
                .setTitle("Enter Keyword") 
                .setView(input) 
                .setPositiveButton("Search", (dialog, which) -> { 
 
                    String keyword = input.getText().toString(); 
 
                    if (originalText.toLowerCase().contains(keyword.toLowerCase())) { 
                        Toast.makeText(this, "Keyword Found!", Toast.LENGTH_SHORT).show(); 
                    } else { 
                        Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show(); 
                    } 
                }) 
                .setNegativeButton("Cancel", null) 
                .show(); 
    } 
 
    // HIGHLIGHT 
    private void showHighlightDialog() { 
 
        EditText input = new EditText(this); 
 
        new AlertDialog.Builder(this) 
                .setTitle("Enter Word to Highlight") 
                .setView(input) 
                .setPositiveButton("Highlight", (dialog, which) -> { 
 
                    String word = input.getText().toString(); 
 
                    SpannableString spannable = 
                            new SpannableString(originalText); 
 
                    int start = originalText.toLowerCase() 
                            .indexOf(word.toLowerCase()); 
 
                    if (start >= 0) { 
                        spannable.setSpan( 
                                new BackgroundColorSpan(0xFFFFFF00), 
                                start, 
                                start + word.length(), 
                                0); 
 
                        textContent.setText(spannable); 
                    } 
                }) 
                .setNegativeButton("Cancel", null) 
                .show(); 
    } 
 
    // SORT ALPHABETICALLY 
    private void sortAlphabetically() { 
 
        String[] words = originalText.split(" "); 
        Arrays.sort(words); 
 
        textContent.setText(String.join(" ", words)); 
    } 
 
    // SORT BY RELEVANCE (based on word length) 
    private void sortByRelevance() { 
 
        String[] words = originalText.split(" "); 
 
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed()); 
 
        textContent.setText(String.join(" ", words)); 
    } 
} 

 
