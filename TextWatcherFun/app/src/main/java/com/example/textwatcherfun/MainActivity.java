package com.example.textwatcherfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                    Toast toast = Toast.makeText(MainActivity.this, "Please enter a name", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        ((EditText) findViewById(R.id.editText)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                TextView textV = findViewById(R.id.textView);
                String theName = s.toString();
                if(!theName.equals("")){
                    textV.setText("Hello " + theName);
                    textV.setVisibility(View.VISIBLE);
                } else {
                    textV.setVisibility(View.INVISIBLE);
                    Toast toast = Toast.makeText(MainActivity.this, "Please enter a name", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
