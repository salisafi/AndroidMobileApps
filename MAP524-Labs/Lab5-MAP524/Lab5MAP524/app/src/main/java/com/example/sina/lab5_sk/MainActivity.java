package com.example.sina.lab5_sk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String [] itemName = { "Bam","Pause","carpenter","CDs","Cleaning","confetti","corrosion","Cute Termite","Bam","Pause","carpenter","CDs","Cleaning"};

    Integer[] imageId = {R.drawable.bam,R.drawable.button,R.drawable.carpenter,R.drawable.cd,R.drawable.cleaning,R.drawable.confetti,
            R.drawable.corrosion,R.drawable.cutetermite,R.drawable.dallas,R.drawable.disappointed,R.drawable.eating,R.drawable.education,R.drawable.effort,
            R.drawable.embarrassed,R.drawable.falling,R.drawable.fencing};

    String [] itemDept = { "Boom!!! 0","Play 1","Repair 2","PCs 3","Washing 4","Generic 5","Special 6","Ants 7", "PCs 3", "Washing 4","Generic 5","Special 6","Ants 7"};

    String [] itemName2 = { "Dallas","disappointed","eating","education","push","Embarrassed","falling","overwatch", "education","push","Embarrassed","falling","overwatch"}; //,"dallas","disappointed","eating","education","effort","embarrassed","falling","fencing"

    Integer[] imageId2 = {R.drawable.dallas,R.drawable.disappointed,R.drawable.eating,R.drawable.education,R.drawable.effort,
            R.drawable.embarrassed,R.drawable.falling,R.drawable.overwatch, R.drawable.effort,};

    String [] itemDept2 = { "Index 8","Index 9","Index 10","Index 11","Index 12","Index 13","Index 14","Index 15", "Index 8","Index 9","Index 10","Index 11","Index 12"};

    String [] aplha = { "A","B","C","D","E","F","G","H", "I", "J", "K", "L"};
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomAdapter my = new CustomAdapter(this,itemName,imageId,itemDept);
        ListView left = findViewById(R.id.LeftList);
        left.setAdapter(my);
        left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent details = new Intent(MainActivity.this, DetailsActivity.class);
                details.putExtra("itemName",itemName[position]);
                details.putExtra("itemDept",itemDept[position]);
                details.putExtra("imageId",imageId[position]);
                startActivity(details);
            }
        });

        CustomAdapterr myR = new CustomAdapterr(this,itemName2,imageId2,itemDept2,aplha);
        ListView right = findViewById(R.id.RightList);
        right.setAdapter(myR);
        right.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent details2 = new Intent(MainActivity.this, Details2Activity.class);
                details2.putExtra("itemName",itemName2[position]);
                details2.putExtra("itemDept",itemDept2[position]);
                details2.putExtra("imageId",imageId2[position]);
                details2.putExtra("alpha",aplha[position]);
                startActivity(details2);
            }
        });

    }
}
