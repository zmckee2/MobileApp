package com.example.menufun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //startEditItemActivity();

        //Create a listview
        //set the content view for this activity to be the list view
            //No layout, root view is the listview
        //create a list of strings (items candy themed)
        //Create an array adapter
        //Run and make sure you can see it

        final ListView root = new ListView(this);
        List<String> candies = new ArrayList<String>();
        candies.add("Candy corn");
        candies.add("Twix");
        candies.add("MnMs");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, candies);
        root.setAdapter(arrayAdapter);
        setContentView(root);

        //Starting part 5 (Contextual action mode (CAM))
        //Need to enable multiple selection on the list view
        root.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL); //Modal means the user HAS to interact with whatever
        //Set the listener for entering CAM
        //When user long presses they can select multiple items
        root.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                //Called any time a user selects or deselects an item in the list view
                int numChecked = root.getCheckedItemCount();
                mode.setTitle(numChecked + " selected"); //This changes the text of the context menu
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater menuInflater = getMenuInflater();
                menuInflater.inflate(R.menu.content_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                //Not needed for PA7
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                //determine which menu item was clicked in CAM
                switch(item.getItemId())
                {
                    case R.id.trashMenuItem:
                        //root.getCheckedItemPositions to get the selected items
                        Toast.makeText(MainActivity.this, "TODO: delete an item", Toast.LENGTH_SHORT).show();
                        mode.finish(); //Exit CAM
                        return true;

                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                //Not needed for PA7
            }
        });

    }

    private void startEditItemActivity()
    {
        Intent intent = new Intent(this, EditItemActivity.class);
        startActivity(intent);
    }

    //The menu is defined in XML, but is not on the app bar at all
    //We need to inflate the menu to get it into our app

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //These next two lines are enough to get the menu on the app, but without functionality
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Setting the menu onClick actions (Overriding the callback for when a user clicks a menu item)
    //This method is called whenever a user makes an options menu selection (ANY selection)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.addMenuItem:
                startEditItemActivity();
                return true; //The event is handled
            case R.id.preferenceMenuItem:
                Toast.makeText(this, "Preferences selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.aboutMenuItem:
                Toast.makeText(this, "About selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
