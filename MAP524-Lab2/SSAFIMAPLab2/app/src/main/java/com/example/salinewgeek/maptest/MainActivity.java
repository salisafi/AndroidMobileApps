package com.example.salinewgeek.maptest;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_usr = findViewById(R.id.usernameBtn);
        Button btn_psw = findViewById(R.id.passwordBtn);
        Button btn_up  = findViewById(R.id.userPassBtn);

        btn_usr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText usr = findViewById(R.id.usernameId);

                Toast.makeText(getApplicationContext(), "Username:" + usr.getText().toString(),
                        Toast.LENGTH_SHORT).show();
                // System.out.println("name is" + usernameStr);
             }
        });

        btn_psw.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText psw = findViewById(R.id.passwordId);

                Toast.makeText(getApplicationContext(), "Password:" + psw.getText().toString(),
                Toast.LENGTH_SHORT).show();
            }
        });

        btn_up.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText usr = findViewById(R.id.usernameId);
                 EditText psw = findViewById(R.id.passwordId);

                Toast.makeText(getApplicationContext(), "Username:" + usr.getText().toString() + " Password :" +psw.getText().toString(),
                Toast.LENGTH_SHORT).show();
            }
        });
    }
}