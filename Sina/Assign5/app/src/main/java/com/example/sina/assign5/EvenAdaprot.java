package com.example.sina.assign5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class EvenAdaprot extends ArrayAdapter<String> {
    Activity dContext;

    String TopText[];
    String DownText[];

    public EvenAdaprot(Activity pContext, String[] top, String[] down){
        super(pContext,R.layout.even_list,top);

        dContext = pContext;
        TopText = top;
        DownText = down;

    }

    public View getView(int position, View MyView, ViewGroup parent){

        LayoutInflater inflater = dContext.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.even_list,null,true);

        TextView top = rowView.findViewById(R.id.EvenTextTop);
        top.setText(TopText[position]);

        TextView down = rowView.findViewById(R.id.EvenDownText);
        down.setText(DownText[position]);


        return rowView;
    }
}
