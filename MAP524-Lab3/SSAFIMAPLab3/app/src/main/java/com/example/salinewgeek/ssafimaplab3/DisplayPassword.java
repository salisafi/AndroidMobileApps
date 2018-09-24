package com.example.salinewgeek.ssafimaplab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.TextView;

public class DisplayPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_password);


        String enterdPsw = getIntent().getExtras().getString("Password");


        TextView entPsw = findViewById(R.id.displayPasswordTV);

        entPsw.setText("Password that you typed is : " + enterdPsw);
    }

    public void GoHome(View v){
        Intent goBackHome = new Intent(DisplayPassword.this, MainActivity.class);
        startActivity(goBackHome);
    }
} // end of DisplayPassword class

