package com.example.ssasi.lab6_map524;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText idET, nameET, markET;

    TextView markTV;

    Button addBTN, viewBTN, findBTN, deleteBTN;

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        idET = (EditText)findViewById(R.id.idET);
        nameET = (EditText)findViewById(R.id.nameET);
        markET = (EditText)findViewById(R.id.markET);

        String idEntered = idET.getText().toString();

        addBTN = (Button) findViewById(R.id.addBTN);
        viewBTN = (Button) findViewById(R.id.viewBTN);
        findBTN = (Button) findViewById(R.id.findBTN);
        deleteBTN = (Button) findViewById(R.id.deleteBTN);


            addBTN.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String name = nameET.getText().toString();
                    String mark = markET.getText().toString();

                    if (name.trim().equals("") || name.isEmpty() || mark.trim().equals("") || mark.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Try again", Toast.LENGTH_LONG).show();
                    } else if(myDb.insertData(idET.getText().toString(), nameET.getText().toString(), markET.getText().toString())){
                        StringBuffer buffer = new StringBuffer();

                        buffer.append("ID :" + idET.getText().toString() + ' ');
                        buffer.append("Name :" + nameET.getText().toString() + ' ');
                        buffer.append("Marks :" + markET.getText().toString() + ' ');

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("The following students have been added " + '\n');
                        builder.setMessage(buffer);
                        builder.setCancelable(true);
                        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        builder.show();
                    }
                }
            });


        viewBTN.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cursor res = myDb.getAllData();
                    if(res.getCount() == 0) {

                       Toast.makeText(MainActivity.this,"Error - Nothing found",Toast.LENGTH_LONG).show();
                        return;
                    }

                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("ID :"+ res.getString(0)+ ' ');
                        buffer.append("Name :"+ res.getString(1)+ ' ');
                        buffer.append("Marks :"+ res.getString(2)+ ' ');
                        buffer.append('\n');
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("The following students have been added " + '\n');
                    builder.setMessage(buffer);
                    builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.show();
                }
            }
        );


        findBTN.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getOneData(idET.getText().toString());
                        if((res.getCount() == 0) || (idET.getText().toString().trim().length() == 0)) {
                           //  Toast.makeText(MainActivity.this,"This student does not exist",Toast.LENGTH_LONG).show();

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setCancelable(true);
                            builder.setTitle("This student does not exist");
                            builder.setMessage("\n\n");
                            builder.show();

                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("ID :"+ res.getString(0)+ ' ');
                            buffer.append("Name :"+ res.getString(1)+ ' ');
                            buffer.append("Marks :"+ res.getString(2)+ ' ');
                            buffer.append('\n');
                        }

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setCancelable(true);
                        builder.setTitle("Student details are as follows " + '\n');
                        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }

                        });
                        builder.setMessage(buffer);
                        builder.show();
                    }

                }
        );


        deleteBTN.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer deletedRows = myDb.deleteData(idET.getText().toString());
                    if(idET.getText().toString().trim().length() == 0){
                        Toast.makeText(MainActivity.this, "The student does not exist", Toast.LENGTH_LONG).show();
                    }
                    else if (deletedRows > 0){
                        Toast.makeText(MainActivity.this,"The following student has been deleted ",Toast.LENGTH_LONG).show();

                        StringBuffer buffer = new StringBuffer();

                        buffer.append("ID :" + idET.getText().toString() + ' ');
                        buffer.append("Name :" + nameET.getText().toString() + ' ');
                        buffer.append("Marks :" + markET.getText().toString() + ' ');

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("The following student has been deleted " + '\n');
                        builder.setMessage(buffer);
                        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        builder.setCancelable(true);
                        builder.show();
                    }
                }
            }
        );

// http://www.codebind.com/android-tutorials-and-examples/android-sqlite-tutorial-example/

    }
}
