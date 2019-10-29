package com.example.menufun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        //enable the "up" (back) button to go "home"
            //home could be
            //1)a parent activity (set in android manifest), parent activities are not always the previous ones in the call stack
            //2)Pop the current activity off the activity call stack and return to the previous activity (What we're doing)
        //All we need to get the up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //Override the same menu item selected method to get back button to work
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch(id){
            case android.R.id.home: //android.R for anything android defines, vs R for our stuff
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
