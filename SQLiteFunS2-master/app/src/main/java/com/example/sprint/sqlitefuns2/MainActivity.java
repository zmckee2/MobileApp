package com.example.sprint.sqlitefuns2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "SQLiteFunTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = new ListView(this);
        setContentView(listView);

        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        ~ TO VIEW THE DATABASE: Device File Explorer -> data ->   ~
        ~                       data -> package -> databases      ~
        ~ Then right click -> save as                             ~
        ~ Then open with DB browser                               ~
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        ContactOpenHelper openHelper = new ContactOpenHelper(this);
        Contact contact = new Contact("Spike", "509-509-5095");
        openHelper.insertContact(contact);


        //For simple debugging only, not wiring this up to the database
        //This would be inefficient compared to directly wiring the cursor
        //List<Contact> contacts = openHelper.getSelectAllContactsList();
        //Log.d(TAG, "onCreate: " + contacts);

        //Gonna wire up the list view directly to the cursor
        //SimpleCursorAdapter
        Cursor cursor = openHelper.getSelectAllContactsCursor();
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                cursor,
                //These are parallel arrays
                new String[] {ContactOpenHelper.NAME}, //Names of columns to get data from
                new int[] {android.R.id.text1}, //ids of TextViews to put the data in
                0 //Leave default
        );

        listView.setAdapter(cursorAdapter);
        //Starting that databases
        //you know what they are

        //2 classes needed for SQLite
        //1. SQLiteOpenHelper - lets you open and work with database
        //      -> Must be subclassed
        //2. SQLiteDatabase - the database, can be opened in read or write mode
    }
}
