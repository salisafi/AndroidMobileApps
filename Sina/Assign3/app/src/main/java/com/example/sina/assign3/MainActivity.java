package com.example.sina.assign3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] Cties_s;
    String[] names_s;
    String[] sports_s;
    String[] mvps_s;
    String[] stadiums_s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button exit = findViewById(R.id.button2);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        Button addTeam = findViewById(R.id.button);
        addTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(MainActivity.this, AddTeamActivity.class);
                startActivity(addIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DBHandler MyDD = new DBHandler(getApplicationContext());
        List<String> Cities = MyDD.getAllCity();
        Cties_s = Cities.toArray(new String[0]);

        List<String> Names = MyDD.getAllName();
        names_s = Names.toArray(new String[0]);

        List<String> Sports = MyDD.getAllSport();
        sports_s = Sports.toArray(new String[0]);

        List<String> Mvps = MyDD.getAllmvp();
        mvps_s = Mvps.toArray(new String[0]);

        List<String> Stadiums = MyDD.getAllstadium();
        stadiums_s = Stadiums.toArray(new String[0]);

        final CustomList myListAD = new CustomList(this,Cties_s, names_s, sports_s,mvps_s,stadiums_s);
        final ListView list = findViewById(R.id.MyList);
        list.setAdapter(myListAD);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//                alertDialog.setTitle(Cties_s[position]);
//                alertDialog.setMessage(stadiums_s[position]);
//                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "close",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        });
//                alertDialog.show();

                Intent details = new Intent(MainActivity.this, UpdateActivity.class);

                details.putExtra("city",Cties_s[position]);
                details.putExtra("name",names_s[position]);
                details.putExtra("sort",sports_s[position]);
                details.putExtra("mvp",mvps_s[position]);
                details.putExtra("stadium",stadiums_s[position]);
                startActivity(details);

            }
        });




    }
}
