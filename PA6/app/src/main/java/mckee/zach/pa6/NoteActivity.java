package mckee.zach.pa6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Spinner;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_note);

        GridLayout root = new GridLayout(this);
        root.setColumnCount(2);
        EditText titleEdit = new EditText(this);
        titleEdit.setHint("Title");
        GridLayout.LayoutParams titleEditParams = new GridLayout.LayoutParams();
        titleEditParams.height = GridLayout.LayoutParams.WRAP_CONTENT;
        titleEditParams.width = 0;
        titleEditParams.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
        titleEditParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 2f);
        titleEdit.setLayoutParams(titleEditParams);
        root.addView(titleEdit);

        Spinner noteTypes = new Spinner(this);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.note_types));
        GridLayout.LayoutParams spinnerParams = new GridLayout.LayoutParams();
        titleEditParams.height = GridLayout.LayoutParams.WRAP_CONTENT;
        titleEditParams.width = 0;
        titleEditParams.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
        titleEditParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
        noteTypes.setAdapter(spinnerAdapter);
        noteTypes.setLayoutParams(spinnerParams);
        root.addView(noteTypes);

        setContentView(root);


    }
}
