package com.mehmetcanyildiz.artbook;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

        SQLiteDatabase myDatabase = this.openOrCreateDatabase("Singer",MODE_PRIVATE,null);
        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS singer (name VARCHAR, age INT(2)");
        myDatabase.execSQL("INSERT INTO singer (name,age) VALUES ('James',50)");

        Cursor cursor = myDatabase.rawQuery("SELECT * FROM singer",null);
        int nameIx = cursor.getColumnIndex("name");
        int ageIx = cursor.getColumnIndex("age");
        cursor.moveToFirst();

        while (cursor !=null) {
        System.out.print("Name :" + cursor.getString(nameIx));
        System.out.print("Age :" + cursor.getString(ageIx));
        cursor.moveToNext();
        }
        } catch(Exception e) {
        e.printStackTrace();
        }
        }
        }
