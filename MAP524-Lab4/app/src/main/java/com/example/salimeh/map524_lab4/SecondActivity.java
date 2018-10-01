package com.example.salimeh.map524_lab4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.GridView;

public class SecondActivity extends AppCompatActivity {

    private GridView horizontalGridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_second);

        horizontalGridView = (GridView)findViewById(R.id.horizontal_gridView);

    }


}
