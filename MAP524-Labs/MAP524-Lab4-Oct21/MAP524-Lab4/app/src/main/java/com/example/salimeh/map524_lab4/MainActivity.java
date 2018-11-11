package com.example.salimeh.map524_lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

        String[] itemName = { "confetti","corrosion","Cute Termite", "confetti","corrosion", "Bam","Pause","carpenter","CDs","Cleaning","confetti","corrosion","Cute Termite", "confetti","corrosion"};

        Integer[] imageId = {R.drawable.bam,R.drawable.button,R.drawable.carpenter,R.drawable.cd,R.drawable.cleaning,R.drawable.confetti,
            R.drawable.corrosion,R.drawable.cutetermite,R.drawable.dallas,R.drawable.disappointed,R.drawable.eating,R.drawable.education,R.drawable.effort,
            R.drawable.embarrassed,R.drawable.falling,R.drawable.fencing};

        String [] itemDesc = { "Generic 5","Special 6","Ants 7", "Boom!!! 8","Play 9","Repair 2","PCs 10", "Boom!!! 0","Play 1","Repair 2","PCs 3","Washing 4","Generic 5","Special 6","Ants 7", "Boom!!! 8","Play 9","Repair 2","PCs 10"};

         Integer [] mult7Array = new Integer[99];

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // CustomAdapter arrayAdapterLeft = new CustomAdapter(this, itemName, imageId, itemDesc){
            CustomAdapter arrayAdapter = new CustomAdapter(this, itemDesc){

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);

                    TextView text = (TextView) view.findViewById(android.R.id.text1);

                    text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f);
                    // text.setGravity(Gravity.CENTER);
                    return view;
                }
            };

            ListView leftleListView = findViewById(R.id.leftListView);
            leftleListView.setAdapter(arrayAdapter);

            int total = 0;
            for (int i = 0; i < 99; i++){
                total += 7;
                mult7Array[i] = total;
            }

            ArrayAdapter<Integer> arrayAdapterSecond = new ArrayAdapter<Integer>(this, android.R.layout.simple_gallery_item, mult7Array){

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                    text.setPadding(20, 20, 20, 20);
                    text.setGravity(Gravity.CENTER);
                    return view;
                }
            };
            GridView rightGidview = findViewById(R.id.rightGidview);
            rightGidview.setAdapter(arrayAdapterSecond);

    }
}
