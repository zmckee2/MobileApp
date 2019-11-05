/**
 * This program contains the backend logic for the start screen
 * of PA5
 * CPSC 312-02, Fall 2019
 * Programming assignment #5
 * No sources to cite
 *
 * @author Zach McKee
 * @version 1.0 10/22/2019
 */
package com.example.pa5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.playButton).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, GameActivity.class);
                intent.putExtra("player1", ((EditText) findViewById(R.id.player1NameText)).getText().toString());
                intent.putExtra("player2", ((EditText) findViewById(R.id.player2NameText)).getText().toString());
                startActivity(intent);
            }
        });
    }
}
