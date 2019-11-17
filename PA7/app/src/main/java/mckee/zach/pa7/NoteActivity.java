/**
 * This program contains the behavior for writing notes
 * CPSC 312-02, Fall 2019
 * Programming Assignment #6
 * No sources to cite
 *
 * @author Zach McKee
 * @version v1.0 11/6/19
 */
package mckee.zach.pa7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {
    static final int titleEditID = View.generateViewId();
    static final int noteTypesID = View.generateViewId();
    static final int contentEditId = View.generateViewId();
    static final int finishButtonId = View.generateViewId();
    int i = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GridLayout root = new GridLayout(this);
        root.setColumnCount(2);
        EditText titleEdit = new EditText(this);
        titleEdit.setId(titleEditID);
        titleEdit.setHint("Title");
        GridLayout.LayoutParams titleEditParams = new GridLayout.LayoutParams();
        titleEditParams.height = GridLayout.LayoutParams.WRAP_CONTENT;
        titleEditParams.width = 0;
        titleEditParams.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
        titleEditParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 2f);
        root.addView(titleEdit, titleEditParams);

        Spinner noteTypes = new Spinner(this);
        noteTypes.setId(noteTypesID);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.note_types));
        GridLayout.LayoutParams spinnerParams = new GridLayout.LayoutParams();
        titleEditParams.height = 0;
        titleEditParams.width = 0;
        titleEditParams.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
        titleEditParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
        noteTypes.setAdapter(spinnerAdapter);
        root.addView(noteTypes, spinnerParams);

        EditText contentEdit = new EditText(this);
        contentEdit.setId(contentEditId);
        contentEdit.setHint("Content");
        contentEdit.setGravity(Gravity.START);
        GridLayout.LayoutParams contentEditParams = new GridLayout.LayoutParams();
        contentEditParams.height = 0;
        contentEditParams.width = 0;
        contentEditParams.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 8f);
        contentEditParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 2, 1f);
        root.addView(contentEdit, contentEditParams);

        Button finishButton = new Button(this);
        finishButton.setId(finishButtonId);
        finishButton.setText("Done");
        GridLayout.LayoutParams finishButtonParams = new GridLayout.LayoutParams();
        finishButtonParams.height = 0;
        finishButtonParams.width = 0;
        finishButtonParams.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
        finishButtonParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 2, 1f);
        finishButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText titleEdit = findViewById(titleEditID);
                EditText contentEdit = findViewById(contentEditId);
                Spinner noteType = findViewById(noteTypesID);
                String title = titleEdit.getText().toString();
                String content = contentEdit.getText().toString();
                if(title == null || title.equals("")) {
                    Toast.makeText(NoteActivity.this, "Please enter a title", Toast.LENGTH_SHORT).show();
                    return;
                }
                String type = noteType.getSelectedItem().toString();
                Intent result = new Intent();
                result.putExtra("title", title);
                result.putExtra("content", content);
                result.putExtra("type", type);
                result.putExtra("index", i);
                setResult(RESULT_OK, result);
                finish();

            }
        });
        root.addView(finishButton, finishButtonParams);


        Intent intent = getIntent();
        if(intent != null){
            String title = intent.getStringExtra("title");
            if(!(title == null)){
                String content = intent.getStringExtra("content");
                String type = intent.getStringExtra("type");
                i = intent.getIntExtra("index", -1);
                titleEdit.setText(title);
                contentEdit.setText(content);
                noteTypes.setSelection(spinnerAdapter.getPosition(type));
            }
        }
        setContentView(root);
    }
}
