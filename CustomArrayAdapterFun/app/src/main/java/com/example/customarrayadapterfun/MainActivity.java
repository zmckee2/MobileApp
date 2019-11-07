package com.example.customarrayadapterfun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        final List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("Me", "25"));
        contacts.add(new Contact("You", "2067889898"));
        contacts.add(new Contact("Walter", "50000"));

        //Moving past simple list item 1. Simple list item 2 has two text views to deal with
        //We need to make a new array adapter, which can be done by using an anonymous subclass
        ArrayAdapter<Contact> contactAdapter = new ArrayAdapter<Contact>(this,
                android.R.layout.simple_list_item_2,
                android.R.id.text1, //The "main" text view
                contacts){
            //Subclassing here.
            //Need to override getView
            //getView returns a view for each item in the data source
            //to be displayed in the list view
            @Override
            @NonNull
            public View getView(int position, View convertView, ViewGroup parent) {
                //Inflates simple list item 1 for this position contact
                View view = super.getView(position, convertView, parent);

                //Set values for the view and it's subviews
                //Look at AOSP for id values
                TextView tv1 = (TextView) view.findViewById(android.R.id.text1); //Find the view within another view
                Contact contact = contacts.get(position);
                tv1.setText(contact.getName());

                TextView tv2 = (TextView) view.findViewById(android.R.id.text2);
                tv2.setText(contact.getPhone());
                return view;
            }
        };
        ListView root = new ListView(this);
        root.setAdapter(contactAdapter);
        setContentView(root);
    }
}
