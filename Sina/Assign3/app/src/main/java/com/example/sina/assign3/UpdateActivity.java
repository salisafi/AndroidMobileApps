package com.example.sina.assign3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent myIntent = getIntent();
        String c = myIntent.getStringExtra("city");
        String n = myIntent.getStringExtra("name");
        String s = myIntent.getStringExtra("sort");
        String m = myIntent.getStringExtra("mvp");
        String st = myIntent.getStringExtra("stadium");



        EditText city = findViewById(R.id.editText6);
        EditText name = findViewById(R.id.editText7);
        EditText sport = findViewById(R.id.editText8);
        EditText mvp = findViewById(R.id.editText9);
        EditText stadium = findViewById(R.id.editText10);

        city.setText(c);
        name.setText(n);
        sport.setText(s);
        mvp.setText(m);
        stadium.setText(st);

        Button exit = findViewById(R.id.button6);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

}
