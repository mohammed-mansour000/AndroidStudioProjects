package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Sqlite extends SQLiteOpenHelper {

    public static  final String DBname = "data.db";

    public Sqlite(@Nullable Context context) {
        super(context, DBname, null, 1  );
    }

    @Override
    public void onCreate(SQLiteDatabase db) { // create the table

        db.execSQL("create table firstTable ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS firstTable"); // if table with same name exists then drop it
        onCreate(db);

    }

    public boolean insertData(String name, String email){

        SQLiteDatabase db = this.getWritableDatabase(); // let you write in the database
        ContentValues contentValues = new ContentValues();

        // get the name and email values
        contentValues.put("name",name);    // put data in database name field
        contentValues.put("email",email);  // put data in database name field

        //insert the values into table
        long result = db.insert("firstTable",null,contentValues);

        //check if insertion took place
        if(result == -1){
            return false;
        }else{
            return true;
        }

    }

    public ArrayList getAllInfo(){

        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase(); // let you read from database

        Cursor res = db.rawQuery("select * from firstTable",null);

        res.moveToFirst();

        while(res.isAfterLast() == false){

            // res.getString(res.getColumnIndex("id")); code below can be writen like this
            String t1 = res.getString(0);
            String t2 = res.getString(1);
            String t3 = res.getString(2);

            arrayList.add(t1 + "- " + t2 + " :  " + t3);
            res.moveToNext();

        }

        return arrayList;
      }

      public boolean updateData(String id, String name, String email){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);   // put data in database name field
        contentValues.put("email",email); // put data in database email field
        db.update("firstTable",contentValues,"id = ?",new String[]{ id });
            return true;

      }

    public Integer deleteData(String id){

        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("firstTable","id = ?",new String[]{ id });

    }

}
