package com.example.multipleactivitiesfun;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    final static String TAG = "MultipleActivitiesFunTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        if(intent != null){
            String username = intent.getStringExtra("username");
            int pin = intent.getIntExtra("pin", 0);
            Toast.makeText(this, "username: " + username + ", pin: " + pin, Toast.LENGTH_SHORT).show();
        }

        findViewById(R.id.backFirstActivity).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //3. Sending information back to main activity
                //This intent is just used to package data back up
                Intent intent = new Intent();
                intent.putExtra("result", "success"); //example
                setResult(Activity.RESULT_OK, intent);

                //1. Go back to the SAME INSTANCE of main activity
                SecondActivity.this.finish();
            }
        });
    }
}
