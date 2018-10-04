package com.example.sina.assign6;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Calendar myCalendar = Calendar.getInstance();

        TextView StartDate = findViewById(R.id.textView4);
        final String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        final TextView SearchDate = findViewById(R.id.Text2);
        SearchDate.setText(date);


        final DatePickerDialog.OnDateSetListener GetDate = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "yyyy-MM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.CANADA);

                SearchDate.setText(sdf.format(myCalendar.getTime()));
            }

        };


        StartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, GetDate, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        final EditText number = findViewById(R.id.editText);
        final Spinner by = findViewById(R.id.spinner);


        Button submit = findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, by.getSelectedItem().toString(),
//                        Toast.LENGTH_LONG).show();
                if(number.getText().toString().length() != 0) {
                    Intent showPage = new Intent(MainActivity.this, List.class);


                    showPage.putExtra("number",number.getText().toString());

                    if(by.getSelectedItem().equals("date")){
                        showPage.putExtra("by","time");
                    }
                    else{
                        showPage.putExtra("by",by.getSelectedItem().toString());
                    }


                    showPage.putExtra("time", SearchDate.getText().toString());


                    startActivity(showPage);
                }
            }
        });



    }
}
