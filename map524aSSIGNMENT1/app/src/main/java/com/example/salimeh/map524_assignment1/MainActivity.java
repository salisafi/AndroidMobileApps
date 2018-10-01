package com.example.salimeh.map524_assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

 /*   private RadioGroup radioGroup;
    private RadioButton AliceRadio, BobRadio, CarolRadio;
    private Button HiBtn; */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* first column logic */
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.HiRadios);

        final RadioButton Alice = (RadioButton)findViewById(R.id.AliceRadio);
        final RadioButton Bob = (RadioButton)findViewById(R.id.BobRadio);

        final TextView HiTextView = (TextView) findViewById(R.id.hiTextview) ;

        final Button HiBt = (Button) findViewById(R.id.HiBtn);

        /* second column logic */
        final RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.helloRadios);

        final RadioButton Dave = (RadioButton) findViewById(R.id.DaveRadio);
        final RadioButton Eve = (RadioButton) findViewById(R.id.EveRadio);

        final TextView HelloTextView = (TextView) findViewById(R.id.helloTextview) ;

        final Button HellBt = (Button) findViewById(R.id.HelloBtn);

        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if(checkedId == R.id.AliceRadio){
                    Toast.makeText(getApplicationContext(), "Alice", Toast.LENGTH_SHORT).show();
                }
                else if(checkedId == R.id.BobRadio){
                    Toast.makeText(getApplicationContext(), "Bob", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Carol", Toast.LENGTH_SHORT).show();
                }
            }
        });

        HiBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if(selectedId == Alice.getId()){
                    HiTextView.setText("Hi Alice");
                } else  if(selectedId == Bob.getId()){
                    HiTextView.setText("Hi Bob");
                } else{
                    HiTextView.setText("Hi Carol");
                }
            }
        });

        /* second column logic */

        radioGroup2.setOnCheckedChangeListener(new OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup2, int checkedId) {
                if(checkedId == R.id.DaveRadio){
                    Toast.makeText(getApplicationContext(), "Dave", Toast.LENGTH_SHORT).show();
                }
                else if(checkedId == R.id.EveRadio){
                    Toast.makeText(getApplicationContext(), "Eve", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Fred", Toast.LENGTH_SHORT).show();
                }
            }
        });

        HellBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup2.getCheckedRadioButtonId();

                if(selectedId == Dave.getId()){
                    HelloTextView.setText("Hello Dave");
                } else  if(selectedId == Eve.getId()){
                    HelloTextView.setText("Hello Eve");
                } else{
                    HelloTextView.setText("Hello Fred");
                }
            }
        });
    }
}
