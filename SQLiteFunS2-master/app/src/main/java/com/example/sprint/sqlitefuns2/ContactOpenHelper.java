package com.example.sprint.sqlitefuns2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ContactOpenHelper extends SQLiteOpenHelper {
    static final String TAG = "SQLiteFunTag";
    //Define some fields for the database
    static final String DATABASE_NAME = "contacts_database";
    static final int DATABASE_VERSION = 1;

    static final String TABLE_CONTACTS = "tableContacts";
    static final String ID = "_id"; //_id is used for adapter views later
    static final String NAME = "name";
    static final String PHONE_NUMBER = "phoneNumber";
    static final String IMAGE_RESOURCE = "imageResource";

    public ContactOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create the SQL statement to create the database
        //SQL: create table tableContacts(_id integer primary key autoincrement,
        //                                name text,
        //                                phoneNumber text,
        //                                imageResource integer);

        String sqlCreate = "CREATE TABLE " + TABLE_CONTACTS +
                           "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            NAME + " TEXT," +
                            PHONE_NUMBER + " TEXT, " +
                            IMAGE_RESOURCE + " INTEGER)";
        Log.d(TAG, "onCreate: " + sqlCreate);
        // execute this sql statement
        db.execSQL(sqlCreate);
        // onCreate() only executes one time
        // after the first call to getWritableDatabase()
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertContact(Contact contact)
    {
        // INSERT INTO tableContacts VALUES
        // (null, 'Spike the bulldog', '509-609-5095', -1)
        String sqlInsert = "INSERT INTO " + TABLE_CONTACTS + " VALUES" +
                           "(null, '" + contact.getName() + "', '" + contact.getPhoneNumber() + "', " + contact.getImageResourceId() + ")";
        Log.d(TAG, "insertContact: " + sqlInsert);
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sqlInsert);
        db.close(); //Good practice to close the database so you don't lock it for writing
    }

    public Cursor getSelectAllContactsCursor()
    {
        //What is a cursor?
        //A cursor is used to navigate through results from a query
        //Works similar to a file cursor

        //Query: SELECT * FROM tableContacts
        String sqlSelectAll = "SELECT * FROM " + TABLE_CONTACTS;
        Log.d(TAG, "getSelectAllContactsList: " + sqlSelectAll);

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sqlSelectAll, null);
        //Don't close the database because the cursor needs it open
        return cursor;
    }

    // for debug purposes only!!
    // for PA7, use a simple cursor adapter to wire up database to listView
    public List<Contact> getSelectAllContactsList()
    {
        List<Contact> contactList = new ArrayList<>();

        // goal: walk through each record using a cursor
        // create a contact and add it to the list
        // the cursor doesn't start at the first record
        // because there might not be a first record

        Cursor cursor = getSelectAllContactsCursor();
        while(cursor.moveToNext()) //returns false when there's no next record to process
        {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            int imageResource = cursor.getInt(3);
            Contact contact = new Contact(id, name, phone, imageResource);
            contactList.add(contact);
        }
        return contactList;
    }

    public void updateContactById(int id, Contact newContact)
    {
        String sqlUpdate = "UPDATE " + TABLE_CONTACTS +
                           " SET " + NAME + "='" + newContact.getName() + "', " +
                               PHONE_NUMBER + "='" + newContact.getPhoneNumber() + "' " +
                           "WHERE " + ID + "=" + id;
        Log.d(TAG, "updateContactById: " + sqlUpdate);
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sqlUpdate);
        db.close(); //Good practice to close the database so you don't lock it for writing
    }

    public void deleteAllContacts()
    {
        String sqlDelete = "DELETE FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sqlDelete);
        db.close(); //Good practice to close the database so you don't lock it for writing
    }
}
