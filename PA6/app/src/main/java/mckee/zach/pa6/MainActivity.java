package mckee.zach.pa6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int NEW_NOTE_REQUEST_CODE = 10;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        GridLayout root = new GridLayout(this);
        root.setColumnCount(1);
        Button addNote = new Button(this);
        addNote.setText(R.string.new_note_prompt);
        addNote.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, NoteActivity.class);
               startActivityForResult(intent, NEW_NOTE_REQUEST_CODE);
            }
        });

        GridLayout.LayoutParams buttonLayout = new GridLayout.LayoutParams();
        buttonLayout.height = GridLayout.LayoutParams.WRAP_CONTENT;
        buttonLayout.width = GridLayout.LayoutParams.MATCH_PARENT;
        addNote.setLayoutParams(buttonLayout);
        root.addView(addNote);

        ListView noteView = new ListView(this);
        List<Note> notes = new ArrayList<Note>();
        ArrayAdapter<Note> noteAdapter = new ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1, notes);
        noteView.setAdapter(noteAdapter);
        root.addView(noteView);

        setContentView(root);
    }
}
