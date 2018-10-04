package com.example.sina.assign4;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;

public class UpdateActivity extends AppCompatActivity {
    String sportText;
    String imgDecodableString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent myIntent = getIntent();
        String c = myIntent.getStringExtra("city");
        String n = myIntent.getStringExtra("name");
        String s = myIntent.getStringExtra("sort");
        sportText = s;
        String m = myIntent.getStringExtra("mvp");
        String URL = myIntent.getStringExtra("IMG");
        imgDecodableString = URL;
        final String id = myIntent.getStringExtra("ID");


        final EditText city = findViewById(R.id.editTextCity);
        final EditText name = findViewById(R.id.editTextName);
        final Spinner sport = findViewById(R.id.UpdateSportSpinner);
        final EditText mvp = findViewById(R.id.editText);
        final ImageView imageUrl = findViewById(R.id.UpdateImage);



        List<String> listItem = Arrays.asList(" ", "Baseball", "Basketball", "Football" , "Hockey");
        ArrayAdapter<String> data = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listItem);
        sport.setAdapter(data);

        sport.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sportText = parent.getItemAtPosition(position).toString();
//                if (test != null) {
//                    Toast.makeText(AddNewTeamActivity.this, test,
//                            Toast.LENGTH_SHORT).show();
//                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        city.setText(c);
        name.setText(n);
        mvp.setText(m);


        if(!(imageUrl.equals(" "))){
            imageUrl.setImageBitmap(base64ToBitmap(URL));
        }

        if(!(s.equals(" "))){
            if(s.equals("Baseball")){
                sport.setSelection(1);
            }
            if(s.equals("Basketball")){
                sport.setSelection(2);
            }
            if(s.equals("Football")){
                sport.setSelection(3);
            }
            if(s.equals("Hockey")){
                sport.setSelection(4);
            }

        }

        TextView UpdateData = findViewById(R.id.textViewUpdate);

        UpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHandler myDB2 = new DBHandler(getApplicationContext());

                if(city.getText().toString().length() !=0){
                   if(myDB2.update(id,city.getText().toString(),name.getText().toString(),
                            sportText ,mvp.getText().toString(),imgDecodableString) == 1){
                       onBackPressed();
                    }

                }

            }
        });


        TextView uploadButton = findViewById(R.id.textViewUpload);
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Gallary = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Gallary, 100);
            }
        });


        TextView Delete = findViewById(R.id.textViewDelete);
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHandler myDB3 = new DBHandler(getApplicationContext());
                if(myDB3.deleteData(id) == 1){
                    onBackPressed();
                }
            }
        });

        TextView Exit = findViewById(R.id.textViewExit);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        try {
            Uri selectedImage = data.getData();
            String[] filepathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage,filepathColumn,null,null,null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filepathColumn[0]);
            imgDecodableString = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageUrl = findViewById(R.id.UpdateImage);
            imageUrl.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
            imgDecodableString = bitmapToBase64(BitmapFactory.decodeFile(imgDecodableString));

        } catch (Exception e){

        }
    }

    private String bitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream .toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    private Bitmap base64ToBitmap(String b64) {
        byte[] imageAsBytes = Base64.decode(b64.getBytes(), Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
    }

}
