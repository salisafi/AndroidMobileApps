package com.example.sina.assign4;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class AddNewTeamActivity extends AppCompatActivity {
    private static final String TAG = "";
    String imgDecodableString;
    String sportText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_team);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActivityCompat.requestPermissions(AddNewTeamActivity.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                1);




        final EditText cityText = findViewById(R.id.CityText);
        final EditText nameText = findViewById(R.id.NameTex);
        final Spinner sportSpinner = findViewById(R.id.SportSpinner);
        final EditText mvpText = findViewById(R.id.MvpText);

        final TextView uploadButton = findViewById(R.id.UploadImage);
        final TextView submitButon = findViewById(R.id.SubmitTeam);
        final TextView exitButton = findViewById(R.id.ExitPage);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Gallary = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Gallary, 100);
            }
        });

        List<String> listItem = Arrays.asList(" ", "Baseball", "Basketball", "Football" , "Hockey");
        ArrayAdapter<String> data = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listItem);
        sportSpinner.setAdapter(data);

        sportSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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



        submitButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Base46String = bitmapToBase64(BitmapFactory.decodeFile(imgDecodableString));
                DBHandler myDB2 = new DBHandler(getApplicationContext());
                if(cityText.getText().toString().length() !=0){
                    myDB2.insert(cityText.getText().toString(),nameText.getText().toString(),sportText ,mvpText.getText().toString(),Base46String);
                    cityText.setText("");
                    nameText.setText("");
                    sportSpinner.setSelection(0);
                    sportText = "";
                    mvpText.setText("");
                    ImageView teamImage = findViewById(R.id.DefaultImage);
                    teamImage.setImageResource(R.drawable.default_image);
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(AddNewTeamActivity.this).create();

                    alertDialog.setMessage("City Can not be empty!");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "close",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
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
            ImageView teamImage = findViewById(R.id.DefaultImage);
            teamImage.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));

        } catch (Exception e){

        }
    }

    public Bitmap getResizedBitmap(Bitmap image, int maxSize){
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if(bitmapRatio > 1){
            width = maxSize;
            height = (int) (height / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image,width,height,true);
    }

    private String bitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream .toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(AddNewTeamActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

}
