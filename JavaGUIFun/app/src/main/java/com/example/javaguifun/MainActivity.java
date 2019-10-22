package com.example.javaguifun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main); dont inflate layout from xml

        //Setting up the layout in java instead of XML
        //Why to do this? XML is defined statically at compile time,
        //Java layouts are dynamic
        MyGridLayout myGrid = new MyGridLayout(this);
        setContentView(myGrid);
    }
}
