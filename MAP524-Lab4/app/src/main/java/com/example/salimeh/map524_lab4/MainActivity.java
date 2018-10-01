package com.example.salimeh.map524_lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] arrayLetter = new String[26];

    private GridView horizontalGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        arrayLetter[0] = "A";
        arrayLetter[1] = "B";
        arrayLetter[2] = "C";
        arrayLetter[3] = "D";
        arrayLetter[4] = "E";
        arrayLetter[5] = "F";
        arrayLetter[6] = "G";
        arrayLetter[7] = "H";
        arrayLetter[8] = "I";
        arrayLetter[9] = "J";
        arrayLetter[10] = "K";
        arrayLetter[11] = "L";
        arrayLetter[12] = "M";
        arrayLetter[13] = "N";
        arrayLetter[14] = "O";
        arrayLetter[15] = "P";
        arrayLetter[16] = "Q";
        arrayLetter[17] = "R";
        arrayLetter[18] = "S";
        arrayLetter[19] = "T";
        arrayLetter[20] = "U";
        arrayLetter[21] = "V";
        arrayLetter[22] = "W";
        arrayLetter[23] = "X";
        arrayLetter[24] = "Y";
        arrayLetter[25] = "Z";

        for(int i = 0; i < arrayLetter.length; i++){

            arrayLetter[i] =
        }
        horizontalGridView = (GridView)findViewById(R.id.horizontal_gridView);

    }
}
