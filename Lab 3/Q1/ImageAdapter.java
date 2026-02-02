package com.example.demo;


import android.content.Context;
import android.view.*;
import android.widget.*;


public class ImageAdapter extends BaseAdapter {


   Context context;
   int[] images;


   public ImageAdapter(Context c, int[] imgs) {
       context = c;
       images = imgs;
   }


   public int getCount() { return images.length; }
   public Object getItem(int pos) { return images[pos]; }
   public long getItemId(int pos) { return pos; }


   public View getView(int pos, View convertView, ViewGroup parent) {
       ImageView iv = new ImageView(context);
       iv.setImageResource(images[pos]);
       iv.setLayoutParams(new GridView.LayoutParams(300, 300));
       iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
       return iv;
   }
}
