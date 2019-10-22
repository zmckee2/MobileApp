package com.example.adapterviewfun;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adapterView example 1: spinner with static data source
        //string defined in strings.xml
        //set the entries attribute of the spinner in xml
        Spinner spinner = findViewById(R.id.spinner);
        String curMonth = spinner.getSelectedItem().toString();
        Log.d(TAG, "onCreate: " + curMonth);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                //adapterView is the spinner
                //view is the view for the selected row (not as important for spinners, but very important for list views)
                //i is the index into the spinner's item source
                //id is the id for the row that was clicked corresponding to the data source (databases)
                String selection = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, selection, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Executes when the currently selected item is removed from
                //the data source
            }
        });

        //adapterview example #2: ListView with dynamic data source
        //List of custom objects (List<Book>)
        ListView listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selection = parent.getItemAtPosition(position).toString();
                //Toast.makeText(MainActivity.this, "book: " + selection, Toast.LENGTH_SHORT).show();
                //Alert Dialogs
                //Using AlertDialog.Builder and using method changing
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setTitle("Item Clicked")
                        .setMessage(selection)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "OK Clicked", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Nuh Uh", null);
                alertBuilder.show(); //Like toast, you need show to display the alert
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false; //Returns false if the event was not consumed.
                              //Will pass event off to click listener to handle the click
            }
        });


        List<Book> books = new ArrayList<>();
        books.add(new Book(20, "me book", "me"));
        books.add(new Book(30, "ur book", "u"));
        books.add(new Book(40, "our book", "us"));
        //Now that we have a custom data source, we need to make or use an adapter to get this data onto our UI
        //In our case, we're using an array adapter

        ArrayAdapter<Book> arrayAdapter = new ArrayAdapter<Book>(
            this, //Reference to current activity
            android.R.layout.simple_list_item_1, //The layout for each row in the list view/item in data source
            books //Data source
        );
        listView.setAdapter(arrayAdapter);

        //Dynamic data source
        books.remove(1); //The adapter automatically notifies the UI
        //Forcing an adapter view refresh
        arrayAdapter.notifyDataSetChanged();

    }
}
