package com.example.salinewgeek.ssafimaplab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.TextView;

public class DIsplayUsrPsw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_usr_psw);

        String usrInt = getIntent().getExtras().getString("Username");
        String passInt = getIntent().getExtras().getString("Password");

        TextView userEnt = findViewById(R.id.displayUsernameTV);
        TextView passEnt = findViewById(R.id.displayPasswordTV);

        userEnt.setText("Username is : "+ usrInt);
        passEnt.setText("Password is : "+ passInt);
    }
    public void GoHome(View v){
        Intent goBackHome = new Intent(DIsplayUsrPsw.this, MainActivity.class);
        startActivity(goBackHome);
    }
}
