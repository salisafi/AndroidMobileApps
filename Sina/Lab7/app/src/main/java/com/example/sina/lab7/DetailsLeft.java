package com.example.sina.lab7;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DetailsLeft extends AppCompatActivity {
    String nameL;
    String deptL;
    String yearL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_left);
        Intent getIntent = getIntent();
        nameL = getIntent.getStringExtra("NameL");
        deptL = getIntent.getStringExtra("DeptL");
        yearL = getIntent.getStringExtra("YearL");

        TextView name = findViewById(R.id.textView9);
        name.setText(nameL);

        TextView dept = findViewById(R.id.textView10);
        dept.setText(deptL);

        TextView year = findViewById(R.id.textView11);
        year.setText(yearL);

    }

}
