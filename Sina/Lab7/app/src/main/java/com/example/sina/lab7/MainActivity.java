package com.example.sina.lab7;

import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    String[] itemNameR = new String[50];
    String[] itemDeptR = new String[50];
    String[] itemYearR = new String[50];

    String[] itemNameL = new String[50];
    String[] itemDeptL = new String[50];
    String[] itemYearL = new String[50];
//
//    Button AddLeft, AddRight, ViewList;
//    EditText NameLeft, DeptLeft, YearLeft, NameRight, DeptRight, YearRight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SQLiteDatabase MyDB;
        MyDB = openOrCreateDatabase("LabTable", Context.MODE_PRIVATE, null);
        MyDB.execSQL(
                "CREATE TABLE IF NOT EXISTS LabTable (Name VARCHAR, Dept VARCHAR, Year VARCHAR);"
        );

        MyDB.execSQL(
                "CREATE TABLE IF NOT EXISTS LabTable2 (Name VARCHAR, Dept VARCHAR, Year VARCHAR);"
        );


        final EditText NameLeft = findViewById(R.id.editText0);
        final EditText DeptLeft = findViewById(R.id.editText2);
        final EditText YearLeft = findViewById(R.id.editText3);
        final Button AddLeft = findViewById(R.id.button);

        AddLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(NameLeft.getText().toString().isEmpty()) || !(DeptLeft.getText().toString().isEmpty()) || !(YearLeft.getText().toString().isEmpty()) ) {

                    try {
                        MyDB.execSQL("INSERT INTO LabTable VALUES ('" + NameLeft.getText().toString() + "','" + DeptLeft.getText().toString() + "','" + YearLeft.getText().toString() +"');");

                        NameLeft.setText("");
                        DeptLeft.setText("");
                        YearLeft.setText("");

                    } catch (SQLException e) {

                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Insert Error!");
                        alertDialog.setMessage("Unfortunately we could not add the user!");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "close",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();

                    }
                }else{
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Please input all the necessary information");
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


        final EditText NameRight = findViewById(R.id.editText4);
        final EditText DeptRight = findViewById(R.id.editText5);
        final EditText YearRight = findViewById(R.id.editText6);
        final Button AddRight = findViewById(R.id.button3);


        AddRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(NameRight.getText().toString().isEmpty()) || !(DeptRight.getText().toString().isEmpty()) || !(YearRight.getText().toString().isEmpty()) ) {

                    try {
                        MyDB.execSQL("INSERT INTO LabTable2 VALUES ('" + NameRight.getText().toString() + "','" + DeptRight.getText().toString() + "','" + YearRight.getText().toString() + "');");

                        NameRight.setText("");
                        DeptRight.setText("");
                        YearRight.setText("");

                    } catch (SQLException e) {

                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Insert Error!");
                        alertDialog.setMessage("Unfortunately we could not add the user!");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "close",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();

                    }
                }else{
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Please input all the necessary information");
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



        final Button ViewList = findViewById(R.id.button2);

        ViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Cursor selectAll = MyDB.rawQuery("SELECT * FROM LabTable2",null);
                int counter = 0;
                String st = "";
                while(selectAll.moveToNext()){
                        itemNameR[counter] = selectAll.getString(0);
                        itemDeptR[counter] = selectAll.getString(1);
                        itemYearR[counter] = selectAll.getString(2);
//
//                        itemNameL[counter] = selectAll.getString(0);
//                        itemDeptL[counter] = selectAll.getString(1);
//                        itemYearL[counter] = selectAll.getString(2);
                    counter +=1;
                }

                Cursor selectAll2 = MyDB.rawQuery("SELECT * FROM LabTable",null);
                int counter2 = 0;
                while(selectAll2.moveToNext()){
                        itemNameL[counter2] = selectAll2.getString(0);
                        itemDeptL[counter2] = selectAll2.getString(1);
                        itemYearL[counter2] = selectAll2.getString(2);
                    counter2 +=1;
                }

                Intent ListIntent = new Intent(MainActivity.this, NameListActivity.class);

                ListIntent.putExtra("NameR", itemNameR);
                ListIntent.putExtra("DeptR", itemDeptR);
                ListIntent.putExtra("YearR", itemYearR);

                ListIntent.putExtra("NameL", itemNameL);
                ListIntent.putExtra("DeptL", itemDeptL);
                ListIntent.putExtra("YearL", itemYearL);
                startActivity(ListIntent);


//                String message = "Nothing were found.";
//
//                if (counter != 0){
//                    message = "the following names have been added";
//                }
//
//
//                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//                alertDialog.setTitle(message);
//                alertDialog.setMessage(st);
//                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "close",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        });
//                alertDialog.show();
            }
        });



    }
}
