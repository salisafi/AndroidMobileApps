package com.example.sina.lab7;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DetailsRight extends AppCompatActivity {


    String nameR;
    String deptR;
    String yearR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_right);

        Intent getIntent = getIntent();
        nameR = getIntent.getStringExtra("NameR");
        deptR = getIntent.getStringExtra("DeptR");
        yearR = getIntent.getStringExtra("YearR");

        TextView name = findViewById(R.id.textView12);
        name.setText(nameR);

        TextView dept = findViewById(R.id.textView13);
        dept.setText(deptR);

        TextView year = findViewById(R.id.textView14);
        year.setText(yearR);

    }

}
