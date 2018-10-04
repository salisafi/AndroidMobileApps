package com.example.sina.assign6;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class Adaprot extends ArrayAdapter<Earthquake> {

    java.util.List<Earthquake> mEarthquakes;

    public Adaprot(@NonNull Context context, @NonNull List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);

        mEarthquakes = earthquakes;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        Earthquake current = mEarthquakes.get(position);

        if(view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        }

        if(current.getMagnitude() < 7.5){
            view.setBackgroundColor(Color.parseColor("#FF8000"));
        }else{
            view.setBackgroundColor(Color.parseColor("#ff0000"));
        }
        TextView tvMag = (TextView) view.findViewById(R.id.top);
        tvMag.setText("M " + formatMagnitude(current.getMagnitude())+"-"+current.getLocation());


        TextView tvPlace = (TextView) view.findViewById(R.id.down);

        Date date = new Date(current.getTimeInMilliSeconds());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        dateFormat.format(date);


        tvPlace.setText(date.toString());


//        TextView tvOffset = (TextView) view.findViewById(R.id.offset_text_view);
//        tvOffset.setText(fullLocation[0]+" of");
//
//        Date date = new Date(current.getTimeInMilliSeconds());
//
//        TextView tvDate = (TextView) view.findViewById(R.id.date_text_view);
//        tvDate.setText(formatDate(date));
//
//        TextView tvTime = (TextView) view.findViewById(R.id.time_text_view);
//        tvTime.setText(formatTime(date));


        return view;
    }

    public String formatTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh: mm a");
        return  dateFormat.format(date);
    }

    private String formatDate(Date date ) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        return dateFormat.format(date);
    }

    private String [] split(String string) {
        String [] array = {};
        if(string.contains("of")) {
            array = string.split("of");
            return array;
        } else {
            array = new String[]{"Near", string};
            return array;
        }
    }



    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
}
