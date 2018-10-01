package com.example.salimeh.saliandroidappdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log; // logging messages to the console
import android.widget.Button;
import android.widget.EditText;
import android.view.*;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MY_TAG = "the_custom_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(MY_TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(MY_TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(MY_TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(MY_TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(MY_TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(MY_TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(MY_TAG, "onDestroy");
    }

    public void CalculateResult(View view){

    TextView result = (TextView) findViewById(R.id.result);

    EditText num1 = (EditText) findViewById(R.id.Number1);
    EditText num2 = (EditText) findViewById(R.id.Number2);

    int n1 = Integer.parseInt(num1.getText().toString());
    int n2 = Integer.parseInt(num2.getText().toString());

    int sum = n1 + n2;

    result.setText(Integer.toString(sum));
    }
}
