package com.example.multipleactivitiesfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        Intent intent = getIntent();
        if(intent != null)//good practice
        {
            //Validate the data. Not required but good practice
            String action = intent.getAction();
            String type = intent.getType();
            if(action.equals(Intent.ACTION_SEND) && type.equals("text/plain"))
            {
                ((TextView) findViewById(R.id.shareActivityText)).setText(intent.getStringExtra(Intent.EXTRA_TEXT));
            }
        }
    }
}
