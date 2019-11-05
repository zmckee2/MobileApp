package mckee.zach.studyapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

public class colorScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_screen);
        Intent intent = getIntent();
        if(intent != null) {
            LinearLayout root = findViewById(R.id.root);
            String color = intent.getStringExtra("color");
            switch (color) {
                case "Red":
                    root.setBackgroundColor(Color.RED);
                    break;
                case "Blue":
                    root.setBackgroundColor(Color.BLUE);
                    break;
                case "Green":
                    root.setBackgroundColor(Color.GREEN);
                    break;
                default:
                    root.setBackgroundColor(Color.MAGENTA);

            }
        }

    }
}
