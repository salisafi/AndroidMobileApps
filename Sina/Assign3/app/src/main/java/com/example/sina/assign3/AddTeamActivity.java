package com.example.sina.assign3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTeamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_team);

        final EditText cityText = findViewById(R.id.editText);
        final EditText nameText = findViewById(R.id.editText2);
        final EditText sportText = findViewById(R.id.editText3);
        final EditText mvpText = findViewById(R.id.editText4);
        final EditText stadiumText = findViewById(R.id.editText5);





        Button addTeam = findViewById(R.id.button3);
        addTeam.setOnClickListener(new View.OnClickListener() {


//            final String city = cityText.getText().toString();
//            final String name = nameText.getText().toString();
//            final String sport = sportText.getText().toString();
//            final String mvp = mvpText.getText().toString();
//            final String stadium = sportText.getText().toString();
            @Override
            public void onClick(View v) {
                DBHandler myDB2 = new DBHandler(getApplicationContext());
                if(nameText.getText().toString().length() !=0){
                    myDB2.insert(cityText.getText().toString(),nameText.getText().toString(),sportText.getText().toString(),mvpText.getText().toString(),stadiumText.getText().toString());
                    cityText.setText("");
                    nameText.setText("");
                    sportText.setText("");
                    mvpText.setText("");
                    stadiumText.setText("");
                }
                else{
                AlertDialog alertDialog = new AlertDialog.Builder(AddTeamActivity.this).create();

                alertDialog.setMessage(nameText.getText().toString());
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "close",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                }
            }
        });

        Button Exit = findViewById(R.id.button4);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

}
