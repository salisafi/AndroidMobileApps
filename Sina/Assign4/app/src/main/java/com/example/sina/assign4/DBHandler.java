package com.example.sina.assign4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(Context cpntect_p){

        super(cpntect_p, "SpinnerDB2",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db1){
        db1.execSQL("CREATE TABLE teams2 (id INTEGER PRIMARY KEY AUTOINCREMENT, city TEXT,name TEXT,sport TEXT,mvp TEXT,URL TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS teams2");
    }

    public void insert(String city_p,String name_p,String sport_p,String mvp_p,String URL_p){

        SQLiteDatabase db3 = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("city",city_p);
        values.put("name",name_p);
        values.put("sport",sport_p);
        values.put("mvp",mvp_p);
        values.put("URL",URL_p);
        db3.insert("teams2",null,values);
        db3.close();
    }


    public List<String> getAllIDs(){
        List<String> ids = new ArrayList<>();
        String select = "SELECT * FROM teams2";
        SQLiteDatabase db4 = this.getReadableDatabase();
        Cursor MyCursor = db4.rawQuery(select,null);
        if(MyCursor.moveToFirst()){
            do {
                ids.add(MyCursor.getString(0));
            } while (MyCursor.moveToNext());
        }
        MyCursor.close();
        db4.close();
        return ids;
    }

    public List<String> getAllCity(){
        List<String> cities = new ArrayList<>();
        String select = "SELECT * FROM teams2";
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
        String select = "SELECT * FROM teams2";
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
        String select = "SELECT * FROM teams2";
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
        String select = "SELECT * FROM teams2";
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

    public List<String> getAllURL(){
        List<String> stadiums = new ArrayList<>();
        String select = "SELECT * FROM teams2";
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

    // id INTEGER PRIMARY KEY AUTOINCREMENT, city TEXT,name TEXT,sport TEXT,mvp TEXT,URL TEXT
    public long update(String id,String city,String name,String sport, String mvp, String image) {
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("city",city);
        contentValues.put("name",name);
        contentValues.put("sport",sport);
        contentValues.put("mvp",mvp);
        contentValues.put("URL",image);
        return db2.update("teams2", contentValues,"id=?",new String[] {id});
    }


    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("teams2", "id = ?",new String[] {id});
    }
}
