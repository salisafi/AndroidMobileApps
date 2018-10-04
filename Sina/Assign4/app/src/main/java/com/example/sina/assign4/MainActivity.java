package com.example.sina.assign4;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] Cties_s;
    String[] names_s;
    String[] sports_s;
    String[] mvps_s;
    String[] Base64String_s;
    String[] Ids_s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView AddButton = findViewById(R.id.textView);
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddTeam = new Intent(MainActivity.this, AddNewTeamActivity.class);
                startActivity(AddTeam);
            }
        });

        TextView ExitButton = findViewById(R.id.textView3);
        ExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
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

        List<String> IMG = MyDD.getAllURL();
        Base64String_s = IMG.toArray(new String[0]);

        List<String> ids = MyDD.getAllIDs();
        Ids_s = ids.toArray(new String[0]);

        final CustomList myListAD = new CustomList(this,Cties_s, names_s, sports_s,mvps_s,Base64String_s);
        final ListView list = findViewById(R.id.TeamList);
        list.setAdapter(myListAD);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                String test = Ids_s[position] +"-" + Cties_s[position] +"-"+ names_s[position] +"-"+sports_s[position] + "-"+
//                        mvps_s[position]+"-"+Base64String_s[position];
//                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//                alertDialog.setMessage(test);
//                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "close",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        });
//                alertDialog.show();

                Intent details = new Intent(MainActivity.this, UpdateActivity.class);

                details.putExtra("ID",Ids_s[position]);
                details.putExtra("city",Cties_s[position]);
                details.putExtra("name",names_s[position]);
                details.putExtra("sort",sports_s[position]);
                details.putExtra("mvp",mvps_s[position]);
                details.putExtra("IMG",Base64String_s[position]);
                startActivity(details);

            }
        });



    }
}
