package com.example.sina.lab7;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SingleRightListAdapter extends ArrayAdapter<String> {

    private Activity MyActivity;
    private String[] dName;

    SingleRightListAdapter(Activity context, String[] RName){
        super(context,R.layout.single_r,RName);

        this.MyActivity = context;
        this.dName = RName;
    }

    public View getView(int position, View view, ViewGroup parent){

        LayoutInflater inflater = MyActivity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.single_r,null,true);
        TextView nameTextView = rowView.findViewById(R.id.textView8);

        nameTextView.setText(dName[position]);
        return rowView;
    }
}
