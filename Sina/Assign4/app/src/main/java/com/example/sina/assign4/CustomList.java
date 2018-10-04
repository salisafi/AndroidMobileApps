package com.example.sina.assign4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {
    Activity dContext;
    String[] dCity;
    String[] dName;
    String[] dSprot;
    String[] dMVP;
    String[] dURL;

    public CustomList(Activity pContext, String[] pCity, String[] pName, String[] pSport, String[] pMVP, String[] pURL){
        super(pContext,R.layout.single_view,pName);

        dContext = pContext;
        dCity = pCity;
        dName = pName;
        dSprot = pSport;
        dMVP = pMVP;
        dURL = pURL;
    }

    public View getView(int position, View MyView, ViewGroup parent){

        LayoutInflater inflater = dContext.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.single_view,null,true);
        TextView City = rowView.findViewById(R.id.CityRow);
        City.setText(dCity[position]);

        TextView Name = rowView.findViewById(R.id.NameRow);
        Name.setText(dName[position]);

        return rowView;
    }
}
