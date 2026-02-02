package com.example.demo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import androidx.fragment.app.Fragment;


public class SportsFragment extends Fragment {


   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_list, container, false);
       ListView listView = v.findViewById(R.id.listView);


       String[] sportsNews = {
               "Football World Cup Updates",
               "Cricket Series Highlights",
               "Olympics Preparation",
               "Tennis Grand Slam News"
       };


       ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
               android.R.layout.simple_list_item_1, sportsNews);


       listView.setAdapter(adapter);
       return v;
   }
}


