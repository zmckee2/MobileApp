package com.example.multipleactivitiesfun;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "MultipleActivitiesFunTag";
    static final int LOGIN_REQUEST_CODE = 1;
    //These codes are defined here and need to be unique
    //for each of our requests for activity results
    //Our activity might have multiple requests for activity results
    //the same callback onActivityResult is called for all requests


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //This is a callback
        //executes when a result from an activity is available
        //Good practice is to check the request code for specific activity results
        if(requestCode == LOGIN_REQUEST_CODE && resultCode == Activity.RESULT_OK)
        {
            String result = data.getStringExtra("result");
            Toast.makeText(this, "result: " + result, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.secondActivity).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Intent is a message to the Android OS
                //specifying our "intent" to start another activity
                //if the intent looks good, the OS will start the activity
                //Explicit intent: You know the activity you want to start by name
                //                      Doesn't need to be in the same app
                //Implicit intent: You don't know the name of the activity,
                //                  but you know the action that you want started
                //Intent.ACTION_VIEW
                //Intent.ACTION_SEND
                //Intent.ACTION_WEB_SEARCH
                //Intent.ACTION_DIAL

                //1. Explicit intent example
                //                         Source            Destination
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                //2. Sending data
                // We can send data to an intent using key-value pairs
                // lets say we want to pass a username and pin to second activity
                String username = "spike";
                int pin = 1234;

                intent.putExtra("username", username);
                intent.putExtra("pin", pin);

                //1. 2.
                //startActivity(intent);
                startActivityForResult(intent, LOGIN_REQUEST_CODE);
            }
        });
    }
}
