package com.abhimangalms.digital.simplesqlitestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBName = "student.db";
    public static final String Table_Name = "register";
    public static final String COL_1 = "id";
    public static final String COL_2 = "name";
    public static final String COL_3 = "email";
    public static final String COL_4 = "uname";
    public static final String COL_5 = "pwd";


    public DatabaseHelper(Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_Name + "(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR,email VARCHAR,uname VARCHAR,pwd VARCHAR);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public boolean insertData(String name, String email, String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, username);
        contentValues.put(COL_5, password);
        long result = db.insert(Table_Name, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(String s11, String s22) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COL_2};
        String selection = COL_4 + " = ?" + " and " + COL_5 + " = ?";
        String[] selectionArgs = {s11,s22};
        Cursor res = db.query(Table_Name, columns, selection, selectionArgs, null,null,null);
        return res;

    }
}