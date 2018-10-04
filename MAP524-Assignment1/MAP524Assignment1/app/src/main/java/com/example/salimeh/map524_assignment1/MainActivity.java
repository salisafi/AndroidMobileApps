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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* first column logic */
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.HiRadios);

        final RadioButton Alice = (RadioButton)findViewById(R.id.AliceRadio);
        final RadioButton Bob = (RadioButton)findViewById(R.id.BobRadio);
        final RadioButton Carol = (RadioButton)findViewById(R.id.CarolRadio);

        final TextView HiTextView = (TextView) findViewById(R.id.hiTextview) ;

        final Button HiBt = (Button) findViewById(R.id.HiBtn);

        /* second column logic */
        final RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);

        final RadioButton Dave = (RadioButton) findViewById(R.id.DaveRadio);
        final RadioButton Eve = (RadioButton) findViewById(R.id.EveRadio);
        final RadioButton Fred = (RadioButton) findViewById(R.id.FredRadio);

        final TextView HelloTextView = (TextView) findViewById(R.id.helloTextview) ;

        final Button HellBt = (Button) findViewById(R.id.HelloBtn);


        // third row - checkboxes
        final CheckBox red = (CheckBox) findViewById(R.id.redCheckBox);

        final CheckBox yellow = (CheckBox) findViewById(R.id.YellowCheckBox);

        final CheckBox green = (CheckBox) findViewById(R.id.GreenCheckBox);

        final Button CollorBt = (Button) findViewById(R.id.ColorBtn);

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
                } else if(selectedId == Bob.getId()){
                    HiTextView.setText("Hi Bob");
                } else {
                    HiTextView.setText("Hi Carol");
                }
            }
        });


        HellBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup2.getCheckedRadioButtonId();

                if(selectedId == R.id.DaveRadio){
                    HelloTextView.setText("Hello Dave");
                }else if(selectedId == R.id.EveRadio){
                    HelloTextView.setText("Hello Eve");
                } else {
                    HelloTextView.setText("Hello Fred");
                }
            }
        });

        // second column logic
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

 /*      HellBt.setOnClickListener(new View.OnClickListener() {
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
        }); */

    // third row - checkboxes
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (red.isChecked())
                    Toast.makeText(getApplicationContext(), "Red", Toast.LENGTH_LONG).show();
            }
        });

        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yellow.isChecked())
                    Toast.makeText(getApplicationContext(), "Yellow", Toast.LENGTH_LONG).show();
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (green.isChecked())
                    Toast.makeText(getApplicationContext(), "Green", Toast.LENGTH_LONG).show();
            }
        });


        CollorBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuffer checkBoxesText = new StringBuffer();

                if (red.isChecked()){checkBoxesText.append("Red ");};
                if (yellow.isChecked()){checkBoxesText.append(" Yellow ");};
                if (green.isChecked()){checkBoxesText.append(" Green");};

                Toast.makeText(getApplicationContext(), checkBoxesText, Toast.LENGTH_LONG).show();
            }
        });


    } /*  end of onCreate() */
}  /* end of MainActivity class */
