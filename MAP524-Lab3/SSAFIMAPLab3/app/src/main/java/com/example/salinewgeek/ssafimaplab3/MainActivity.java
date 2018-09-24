package com.example.salinewgeek.ssafimaplab3;
import android.view.*;
import android.widget.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    } // end of onCreate(Bundle savedInstanceState)

    public void GoDisplayUsrname(View v){

        EditText usrname = findViewById(R.id.usernameId);
        String enterdUser = usrname.getText().toString();

        Intent goDispUsr = new Intent(this, DisplayUsername.class);
        goDispUsr.putExtra("Username",enterdUser);
        startActivity(goDispUsr);
    }

    public void GoDisplayPsw(View v){

        EditText psw = findViewById(R.id.passwordId);
        String enterdPsw = psw.getText().toString();

        Intent goDispPsw = new Intent(this, DisplayPassword.class);
        goDispPsw.putExtra("Password",enterdPsw);
        startActivity(goDispPsw);
    }

    public void GoDispUsrPsw(View v){

        EditText usr = findViewById(R.id.usernameId);
        String enterdUser = usr.getText().toString();

        EditText psw = findViewById(R.id.passwordId);
        String enterdPsw = psw.getText().toString();

        Intent goDispUsrPsw = new Intent(this, DIsplayUsrPsw.class);
        goDispUsrPsw.putExtra("Username",enterdUser);
        goDispUsrPsw.putExtra("Password",enterdPsw);
        startActivity(goDispUsrPsw);
    }
} // end of MainActivity class
