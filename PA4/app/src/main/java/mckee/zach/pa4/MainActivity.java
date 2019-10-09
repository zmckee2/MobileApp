package mckee.zach.pa4;

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

        ((Button)findViewById(R.id.calcGradeButton)).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                EditText desiredGradeT = (EditText) findViewById(R.id.letterEditText);
                EditText minAvgGradeT = (EditText) findViewById(R.id.minAvgEditText);
                EditText curAvgGradeT = (EditText) findViewById(R.id.curAgvEditText);
                EditText finalWeightT = (EditText) findViewById(R.id.finalEditText);

                String desiredGrade = desiredGradeT.getText().toString();
                float minAvgGrade = Float.parseFloat(minAvgGradeT.getText().toString());
                float curAvgGrade = Float.parseFloat(curAvgGradeT.getText().toString());
                float finalWeight = Float.parseFloat(finalWeightT.getText().toString());

                TextView resultPercent = (TextView) findViewById(R.id.resultPercent);
                TextView finalPercent = (TextView) findViewById(R.id.resultGrade);

                GradeCalculator calculator = new GradeCalculator(minAvgGrade, curAvgGrade, finalWeight);
                float requiredGrade = calculator.calculateFinalGrade();
                String outputString;
                if(requiredGrade > 100)
                    outputString = "There is no way for you to earn a";
                resultPercent.setText(String.format("You need a score of %.2f on the final exam to earn a", requiredGrade));
                finalPercent.setText(desiredGrade);
            }
        });
    }
}
