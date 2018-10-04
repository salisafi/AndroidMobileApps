package com.example.sina.lab7;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SingleListAdapter extends ArrayAdapter<String> {

    private Activity MyActivity;
    private String[] dName;

    SingleListAdapter(Activity context, String[] lName){
        super(context, R.layout.single, lName);

        this.MyActivity = context;
        this.dName = lName;
    }

    public View getView(int position, View view, ViewGroup parent){


        LayoutInflater inflater = MyActivity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.single,null,true);
        TextView nameTextView = rowView.findViewById(R.id.textView7);

        nameTextView.setText(dName[position]);

        return rowView;

    }

}
