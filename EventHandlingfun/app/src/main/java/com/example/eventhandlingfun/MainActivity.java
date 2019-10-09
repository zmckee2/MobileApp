package com.example.eventhandlingfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "MainActivityTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.textView);
        TextView tV = (TextView) view;

        //2 ways to set a button event listener
        //1: set the android:onClick attribute in xml
        //2: define a class that implements View.OnClickListener
        // register an object of the class as an onClick listener
        //  3 ways to do 2:
        //      A: MainActivity implement View.OnClickListener
        //      B: some other class implement it (outer or inner)
        //      C: Anonymous class that implements OnClickListener

        View button = findViewById(R.id.loginButton);
        Button b = (Button) button;
        //b.setOnClickListener(this); //<--- MainActivity has the onCreate. It can be called upon to do onClick
        //Anonymous class
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText usernameT = (EditText) findViewById(R.id.usernameEditText);
                EditText passwordT = (EditText) findViewById(R.id.passwordExitText);
                String username = usernameT.getText().toString();
                String password = passwordT.getText().toString();
                Log.d(TAG, "onClick: " + username + " " + password);
                usernameT.setText("");
                passwordT.setText("");
            }
        });

        //Task:
        // When user hits login, get username and password
    }

//    @Override
//    public void onClick(View v) {
//        Log.d(TAG, "onButtonClick: mainactiviy");
//    }
//    Option 1, Goodbye chump
//    public void onButtonClick(View view)
//    {
//        Log.d(TAG, "onButtonClick: ");
//    }
}
