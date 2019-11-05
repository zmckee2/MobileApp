package com.example.customarrayadapterfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("Me", "25"));
        contacts.add(new Contact("You", "2067889898"));
        contacts.add(new Contact("Walter", "50000"));

        //Moving past simple list item 1. Simple list item 2 has two text views to deal with
        //We need to make a new array adapter, which can be done by using an anonymous subclass
        ArrayAdapter<Contact> contactAdapter = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1, contacts){
            //Subclassing here.
            //Need to override getView
            //getView returns a view for each item in the data source
            //to be displayed in the list view
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return super.getView(position, convertView, parent);
            }
        };
        ListView root = new ListView(this);
        root.setAdapter(contactAdapter);
        setContentView(root);
    }
}
