package mckee.zach.studyapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toNextScreen(View view) {
        Spinner spinner = findViewById(R.id.spinner);
        String color = spinner.getSelectedItem().toString();
        Intent intent = new Intent(this, colorScreen.class);
        intent.putExtra("color", color);
        startActivity(intent);
    }

    public void onRadioButtonClick(View view) {
        Boolean isChecked = ((RadioButton) view).isChecked();

        int id = view.getId();
        if(id == R.id.redButton && isChecked)
            findViewById(R.id.rootLayout).setBackgroundColor(Color.RED);
        else if(id == R.id.blueButton && isChecked)
            findViewById(R.id.rootLayout).setBackgroundColor(Color.BLUE);
        else if(id == R.id.greenButton && isChecked)
            findViewById(R.id.rootLayout).setBackgroundColor(Color.GREEN);
    }

    public void calcMiliage(View view) {
        EditText init = findViewById(R.id.initRead);
        EditText post = findViewById(R.id.postRead);
        double initD = Double.parseDouble(init.getText().toString());
        double postD = Double.parseDouble(post.getText().toString());
        double distance = postD - initD;
        double finalPayout = distance * .35;
        Toast.makeText(this, "Final payout: " + finalPayout, Toast.LENGTH_SHORT).show();
    }
}
