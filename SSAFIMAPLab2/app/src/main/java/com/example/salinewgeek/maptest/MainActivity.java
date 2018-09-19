package com.example.salinewgeek.maptest;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


        // private EditText usrname;
        EditText usr;
        EditText psw;

        Button btn_usr;
        Button btn_psw;
        Button btn_up;

        String username;
        String password;
       //  String userpass;

        TextView tview;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            usr = (EditText)findViewById(R.id.username);
            psw = (EditText)findViewById(R.id.password);


            btn_usr = (Button)this.findViewById(R.id.usernameBtn);
            btn_psw = (Button)this.findViewById(R.id.passwordBtn);
            // btn_up = (Button)this.findViewById(R.id.userPassBtn);

            username = usr.getText().toString();
            password = psw.getText().toString();
            //  userpass = name.getText().toString();


            // Log.d("TAG",username);

         /*   TextView tview = (TextView)findViewById(R.id.printHere);
            tview.setText(username); */

/*
            btn_usr.setOnClickListener(btn_usrListener);

            OnClickListener btn_usrListener = new OnClickListener()
            {
                public void onClick(View v)
                {
                    System.out.println ("name is"+username);


                }
                */

        /*    Toast.makeText(getActivity(), "This is my Toast message!",
                    Toast.LENGTH_LONG).show();

            }; */


        }
}
