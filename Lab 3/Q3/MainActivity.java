package com.example.demo;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);


       TabLayout tabLayout = findViewById(R.id.tabLayout);
       ViewPager viewPager = findViewById(R.id.viewPager);


       ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
       adapter.addFragment(new TopStoriesFragment(), "Top Stories");
       adapter.addFragment(new SportsFragment(), "Sports");
       adapter.addFragment(new EntertainmentFragment(), "Entertainment");


       viewPager.setAdapter(adapter);
       tabLayout.setupWithViewPager(viewPager);
   }
}
