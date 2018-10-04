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
import android.widget.ListAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        String[] alphabetArray = {"A","B","C","D","E","F","G","H", "I","J","K",
                "L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

         Integer [] mult7Array = new Integer[99];

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ArrayAdapter<String> arrayAdapterCarol = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alphabetArray){

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                    text.setBackgroundColor(getResources().getColor(R.color.YellowColor));
                    text.setTextColor(getResources().getColor(R.color.RedColor));
                    text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40f);
                    text.setGravity(Gravity.CENTER);
                    return view;
                }
            };

            ListView leftleListView = findViewById(R.id.leftListView);
            leftleListView.setAdapter(arrayAdapterCarol);

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
                    text.setBackgroundColor(getResources().getColor(R.color.RedColor));
                    text.setPadding(20, 20, 20, 20);
                    text.setTextColor(getResources().getColor(R.color.YellowColor));
                    text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f);
                    text.setGravity(Gravity.CENTER);
                    return view;
                }
            };
            GridView rightGidview = findViewById(R.id.rightGidview);
            rightGidview.setAdapter(arrayAdapterSecond);

    }
}
