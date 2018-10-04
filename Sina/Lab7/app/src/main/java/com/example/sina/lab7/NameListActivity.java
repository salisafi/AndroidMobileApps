package com.example.sina.lab7;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class NameListActivity extends AppCompatActivity {
    String[] nameL;
    String[] deptL;
    String[] yearL;

    String[] nameR;
    String[] deptR;
    String[] yearR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_list);



        Intent getIntent = getIntent();
        nameL = getIntent.getStringArrayExtra("NameL");
        deptL = getIntent.getStringArrayExtra("DeptL");
        yearL = getIntent.getStringArrayExtra("YearL");

        SingleListAdapter SingleViewL = new SingleListAdapter(this,nameL);

        ListView LeftList = findViewById(R.id.LeftList);
        LeftList.setAdapter(SingleViewL);

        LeftList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (nameL[position] !=null && nameL[position]!=null && nameL[position]!=null) {
                    Intent ListIntentLeft = new Intent(NameListActivity.this, DetailsLeft.class);


                    ListIntentLeft.putExtra("NameL", nameL[position]);
                    ListIntentLeft.putExtra("DeptL", deptL[position]);
                    ListIntentLeft.putExtra("YearL", yearL[position]);
                    startActivity(ListIntentLeft);
                }
            }
        });



        nameR = getIntent.getStringArrayExtra("NameR");
        deptR = getIntent.getStringArrayExtra("DeptR");
        yearR = getIntent.getStringArrayExtra("YearR");

        SingleRightListAdapter RightList = new SingleRightListAdapter(this,nameR);
        ListView RightListAd = findViewById(R.id.RightList);
        RightListAd.setAdapter(RightList);

        RightListAd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (nameR[position] !=null && deptR[position]!=null && yearR[position]!=null) {
                    Intent ListIntentRight = new Intent(NameListActivity.this, DetailsRight.class);


                    ListIntentRight.putExtra("NameR", nameR[position]);
                    ListIntentRight.putExtra("DeptR", deptR[position]);
                    ListIntentRight.putExtra("YearR", yearR[position]);
                    startActivity(ListIntentRight);
                }
            }
        });





    }

}
