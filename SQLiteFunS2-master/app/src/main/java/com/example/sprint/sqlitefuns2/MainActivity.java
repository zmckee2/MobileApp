package com.example.sprint.sqlitefuns2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Starting that databases
        //you know what they are

        //2 classes needed for SQLite
        //1. SQLiteOpenHelper - lets you open and work with database
        //      -> Must be subclassed
        //2. SQLiteDatabase - the database, can be opened in read or write mode
    }
}
