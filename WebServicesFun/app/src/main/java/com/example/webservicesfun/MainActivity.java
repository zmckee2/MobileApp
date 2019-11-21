package com.example.webservicesfun;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<InterestingPhoto> photos;
    int curIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadNextPhoto();
            }
        });

        FlickrApi flickrApi = new FlickrApi(this);
        flickrApi.fetchInterestingPhotos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void recieveInteresingPhoto(List<InterestingPhoto> interestingPhotos) {
        photos = interestingPhotos;
        curIndex = 0;
        loadNextPhoto();
    }

    private void loadNextPhoto() {
        if (photos != null && photos.size() > 0){
            TextView titleText = findViewById(R.id.titleTextView);
            TextView dateText = findViewById(R.id.dateTextView);
            InterestingPhoto curPhoto = photos.get(curIndex);
            titleText.setText(curPhoto.getTitle());
            dateText.setText(curPhoto.getDateTaken());

            curIndex++;
            curIndex %= photos.size();
        } else {
            Toast.makeText(this, "Please wait for the images to load", Toast.LENGTH_SHORT).show();
        }
    }
}
