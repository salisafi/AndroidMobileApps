package com.example.salimeh.map524_lab4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    private Activity context;
    private String[] name1;
    private Integer[] image1;
    private String[] Dept1;


    CustomAdapter(Activity Lcontext, String[] name2, Integer[] image2, String[] dept2) {
        super(Lcontext, R.layout.activity_custom_adapter,name2);
        this.context = Lcontext;
        this.name1 = name2;
        this.image1 = image2;
        this.Dept1 = dept2;

    }

    public @NonNull
    View getView(int position, View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        if(view == null){
            View rowView = inflater.inflate(R.layout.content_custom_adapter,null,true);
            TextView txt1 = rowView.findViewById(R.id.textView2);
            ImageView img1 = rowView.findViewById(R.id.imgIcon);
            TextView txt2 = rowView.findViewById(R.id.textView3);
            txt1.setText(name1[position]);
            img1.setImageResource(image1[position]);
            txt2.setText(Dept1[position]);
            return rowView;
        }

        return view;
    }

}
