package com.example.sina.lab5_sk;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Details2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);

        Intent details = getIntent();
        String itemName = details.getStringExtra("itemName");
        Bundle bundle=this.getIntent().getExtras();
        int pic = bundle.getInt("imageId");
        String alpha = details.getStringExtra("alpha");

        String ds = details.getStringExtra("itemDept");
        TextView txt1 =  findViewById(R.id.textView7);
        txt1.setText(itemName);

        ImageView img =  findViewById(R.id.imageView);
        img.setImageResource(pic);

        TextView txt2 =  findViewById(R.id.textView8);
        txt2.setText(ds);

        TextView txt3 =  findViewById(R.id.textView9);
        txt3.setText(alpha);

    }

}
