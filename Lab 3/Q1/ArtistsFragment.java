package com.example.demo;


import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.fragment.app.Fragment;


public class ArtistsFragment extends Fragment {


   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_artists, container, false);


       String[] countries = {
               "American Samoa","El Salvador","Saint Helena",
               "Saint Kitts and Nevis","Saint Lucia","Saint Pierre and Miquelon",
               "Saint Vincent and the Grenadines","Samoa","San Marino","Saudi Arabia"
       };


       ListView listView = v.findViewById(R.id.listView);
       ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
               R.layout.list_item_white,
               R.id.itemText,
               countries);


       listView.setAdapter(adapter);


       return v;
   }
}
