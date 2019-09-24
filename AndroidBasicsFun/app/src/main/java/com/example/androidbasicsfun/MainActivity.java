package com.example.androidbasicsfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//App compat activity makes our app backwards compatable
//Activity - a screen in your app
public class MainActivity extends AppCompatActivity {

    //Main is gonzo, but there's now multiple entry points to a android app
    // onCreate() our activity has been created
    //and the xml layout is inflated??
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
