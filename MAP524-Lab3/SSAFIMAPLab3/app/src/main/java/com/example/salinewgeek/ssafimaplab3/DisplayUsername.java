package com.example.salinewgeek.ssafimaplab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.TextView;

public class DisplayUsername extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_username);

        String enterdUser = getIntent().getExtras().getString("Username");

        TextView disUsernameTV = findViewById(R.id.displayUsernameTV);

        disUsernameTV.setText("Username is : " + enterdUser);
    } // end of onCreate(Bundle savedInstanceState)

    public void GoHome(View v){
        Intent goBackHome = new Intent(DisplayUsername.this, MainActivity.class);
        startActivity(goBackHome);
    }

} // end of DisplayUsername class
