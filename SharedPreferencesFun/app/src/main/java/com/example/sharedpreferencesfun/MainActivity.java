package com.example.sharedpreferencesfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    static final String SHARED_PREFERENCES_FNAME = "shared_preferences";
    static final String NAME_KEY = "name"; //Key for the name key/value pair

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // task: fetch the name and set it as the EditText text
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_FNAME, 0);
        String name = sharedPreferences.getString(NAME_KEY, "");
        ((EditText)findViewById(R.id.editText)).setText(name);
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Persistent data storage
        // Default options for persistent data storage
        // 1. SharePreferences: save preferences ("settings") AND/OR simple values
        // 2. Read/Write to a file
        // 3. SQLite database
        // 4. Room persistence library: abstraction layer on top of SQLite

        // 1.
        // In onStop, we're gonna "put" the name from the edit text
        EditText editText = findViewById(R.id.editText);
        String name= editText.getText().toString();
                                                                  //File name and file access mode (0 = private)
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_FNAME, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME_KEY, name);
        editor.apply(); //This actually saves the string (commit or apply)
    }
}
