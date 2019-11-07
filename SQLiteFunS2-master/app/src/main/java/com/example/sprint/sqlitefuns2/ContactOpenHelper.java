package com.example.sprint.sqlitefuns2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactOpenHelper extends SQLiteOpenHelper {
    //Define some fields for the database
    static final String DATABASE_NAME = "contacts_database";
    static final int DATABASE_VERSION = 1;

    public ContactOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
