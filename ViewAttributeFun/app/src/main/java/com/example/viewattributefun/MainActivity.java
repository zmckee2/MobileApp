package com.example.viewattributefun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.toggleButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                String curButtonText = b.getText().toString();
                if(curButtonText.equals("On"))
                    b.setText(R.string.off);
                else
                    b.setText(R.string.on);
            }
        });
    }
}
