package com.example.sina.assign3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(Context cpntect_p){
        super(cpntect_p, "SpinnerDB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db1){
        db1.execSQL("CREATE TABLE teams (id INTEGER PRIMARY KEY, city TEXT,name TEXT,sport TEXT,mvp TEXT,stadium TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS teams");
    }

    public void insert(String city_p,String name_p,String sport_p,String mvp_p,String stadium_p){

        SQLiteDatabase db3 = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("city",city_p);
        values.put("name",name_p);
        values.put("sport",sport_p);
        values.put("mvp",mvp_p);
        values.put("stadium",stadium_p);
        db3.insert("teams",null,values);
        db3.close();
    }


    public List<String> getAllCity(){
        List<String> cities = new ArrayList<>();
        String select = "SELECT * FROM teams";
        SQLiteDatabase db4 = this.getReadableDatabase();
        Cursor MyCursor = db4.rawQuery(select,null);
        if(MyCursor.moveToFirst()){
            do {
                cities.add(MyCursor.getString(1));
            } while (MyCursor.moveToNext());
        }
        MyCursor.close();
        db4.close();
        return cities;
    }

    public List<String> getAllName(){
        List<String> names = new ArrayList<>();
        String select = "SELECT * FROM teams";
        SQLiteDatabase db4 = this.getReadableDatabase();
        Cursor MyCursor = db4.rawQuery(select,null);
        if(MyCursor.moveToFirst()){
            do {
                names.add(MyCursor.getString(2));
            } while (MyCursor.moveToNext());
        }
        MyCursor.close();
        db4.close();
        return names;
    }

    public List<String> getAllSport(){
        List<String> sports = new ArrayList<>();
        String select = "SELECT * FROM teams";
        SQLiteDatabase db4 = this.getReadableDatabase();
        Cursor MyCursor = db4.rawQuery(select,null);
        if(MyCursor.moveToFirst()){
            do {
                sports.add(MyCursor.getString(3));
            } while (MyCursor.moveToNext());
        }
        MyCursor.close();
        db4.close();
        return sports;
    }

    public List<String> getAllmvp(){
        List<String> mvps = new ArrayList<>();
        String select = "SELECT * FROM teams";
        SQLiteDatabase db4 = this.getReadableDatabase();
        Cursor MyCursor = db4.rawQuery(select,null);
        if(MyCursor.moveToFirst()){
            do {
                mvps.add(MyCursor.getString(4));
            } while (MyCursor.moveToNext());
        }
        MyCursor.close();
        db4.close();
        return mvps;
    }

    public List<String> getAllstadium(){
        List<String> stadiums = new ArrayList<>();
        String select = "SELECT * FROM teams";
        SQLiteDatabase db4 = this.getReadableDatabase();
        Cursor MyCursor = db4.rawQuery(select,null);
        if(MyCursor.moveToFirst()){
            do {
                stadiums.add(MyCursor.getString(5));
            } while (MyCursor.moveToNext());
        }
        MyCursor.close();
        db4.close();
        return stadiums;
    }
}
