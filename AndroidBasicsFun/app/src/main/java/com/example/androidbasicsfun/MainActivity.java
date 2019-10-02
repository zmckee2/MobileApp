package com.example.androidbasicsfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

//App compat activity makes our app backwards compatable
//Activity - a screen in your app
public class MainActivity extends AppCompatActivity {
    //Defining a tag, standard convention for logging
    static final String TAG="MainActivityTag";

    //<div>Icons made by <a href="https://www.flaticon.com/authors/smashicons" title="Smashicons">Smashicons</a> from <a href="https://www.flaticon.com/"             title="Flaticon">www.flaticon.com</a></div>
    //Main is gonzo, but there's now multiple entry points to a android app
    // onCreate() our activity has been created
    //and the xml layout is inflated??
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("hello from main activity");
        //Use the log class do debug the android way
        //Use the search to see your specific tag in the log
        Log.d(TAG, "Hello from main activity log");


        //Layout: An invisible container that organizes GUI components (views)
        //ViewGroup is the layout's superclass
        //we're gonna start with a linear layout (the most simple)
        //Linear layouts have:
        //  An orientation: Horizontal or vertical

        //To refer to the actual view object that's inflated (turned into java)
        // for each of our views in xml, each of our views need an id

        View view = findViewById(R.id.textView);
        TextView tV = (TextView) view;
        String tvText = tV.getText().toString();
        Log.d(TAG, tvText);
        tV.setText(tvText.toUpperCase());
    }
}
