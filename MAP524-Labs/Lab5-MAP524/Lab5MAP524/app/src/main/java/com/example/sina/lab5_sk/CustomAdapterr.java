package com.example.sina.lab5_sk;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapterr extends ArrayAdapter<String> {
    private Activity context;
    private String[] name1;
    private Integer[] image1;
    private String[] Dept1;
    private  String[] al;

    CustomAdapterr(Activity Lcontext, String[] name2, Integer[] image2, String[] dept2, String[] al2) {
        super(Lcontext, R.layout.listrowright,name2);
        this.context = Lcontext;
        this.name1 = name2;
        this.image1 = image2;
        this.Dept1 = dept2;
        this.al = al2;

    }

    public @NonNull
    View getView(int position, View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        if(view == null){
            View rowView = inflater.inflate(R.layout.listrowright,null,true);
            TextView txt1 = rowView.findViewById(R.id.textView1r);
            ImageView img1 = rowView.findViewById(R.id.imgIconr);
            TextView txt2 = rowView.findViewById(R.id.textView2r);
            TextView txt3 = rowView.findViewById(R.id.textView3r);
            txt1.setText(name1[position]);
            img1.setImageResource(image1[position]);
            txt2.setText(Dept1[position]);
            txt3.setText(al[position]);
            return rowView;
        }

        return view;
    }

}

