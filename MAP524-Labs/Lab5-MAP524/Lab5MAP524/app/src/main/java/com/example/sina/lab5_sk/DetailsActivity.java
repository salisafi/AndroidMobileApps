package com.example.sina.lab5_sk;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);

        Intent details = getIntent();

        String itemName = details.getStringExtra("itemName");

        Bundle bundle=this.getIntent().getExtras();

        int pic=bundle.getInt("imageId");

        String ds = details.getStringExtra("itemDept");

        TextView txt1 =  findViewById(R.id.textView4);
        txt1.setText(itemName);

        ImageView img =  findViewById(R.id.imageView);
        img.setImageResource(pic);

        TextView txt2 =  findViewById(R.id.textView5);
        txt2.setText(ds);


    }

}
