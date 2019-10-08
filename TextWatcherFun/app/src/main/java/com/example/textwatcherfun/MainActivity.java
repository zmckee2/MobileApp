package com.example.textwatcherfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                TextView textV = findViewById(R.id.textView);
                EditText editT = findViewById(R.id.editText);
                String theName = editT.getText().toString();
                if(!theName.equals("")){
                    textV.setText("Hello " + theName);
                    editT.setText("");
                    textV.setVisibility(View.VISIBLE);
                } else {
                    editT.setText("");
                    textV.setVisibility(View.INVISIBLE);
                }

            }
        });
    }
}
