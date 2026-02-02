package com.example.demo;


import android.os.Bundle;
import android.view.*;
import android.widget.GridView;
import androidx.fragment.app.Fragment;


public class AlbumsFragment extends Fragment {


   int[] images = {
           R.drawable.dog1, R.drawable.dog2, R.drawable.dog3,
           R.drawable.dog4, R.drawable.dog5, R.drawable.dog6
   };


   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_albums, container, false);
       GridView gridView = v.findViewById(R.id.gridView);
       gridView.setAdapter(new ImageAdapter(getContext(), images));
       return v;
   }
}
