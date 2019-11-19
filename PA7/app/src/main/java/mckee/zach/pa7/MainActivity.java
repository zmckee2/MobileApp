/**
 * This program contains the behavior for the main activity
 * CPSC 312-02, Fall 2019
 * Programming Assignment #6
 * No sources to cite
 *
 * @author Zach McKee
 * @version v1.0 11/6/2019
 */
package mckee.zach.pa7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int NEW_NOTE_REQUEST_CODE = 10;
    private static final int EDIT_NOTE_REQUEST_CODE = 11;
    static final int listViewId = View.generateViewId();
    List<Note> notes;
    ArrayAdapter<Note> noteAdapter;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //If the request was to make a new note, make a new note
        if(resultCode == RESULT_OK && requestCode == NEW_NOTE_REQUEST_CODE){
            String title = data.getStringExtra("title");
            String content = data.getStringExtra("content");
            String type = data.getStringExtra("type");
            addNewNote(title, content, type);
        }
        //If the request was to edit a note, edit a note
        else if(resultCode == RESULT_OK && requestCode == EDIT_NOTE_REQUEST_CODE){
            String title = data.getStringExtra("title");
            String content = data.getStringExtra("content");
            String type = data.getStringExtra("type");
            int i = data.getIntExtra("index", -1);
            editNote(title, content, type, i);
        }
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
        noteView.setId(listViewId);
        notes = new ArrayList<Note>();
        noteAdapter = new ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1, notes);
        noteView.setAdapter(noteAdapter);
        root.addView(noteView);
        noteView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Note selectedItem = (Note) adapterView.getItemAtPosition(i);
                String title = selectedItem.getTitle();
                String type = selectedItem.getType();
                String content = selectedItem.getContent();
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("type", type);
                intent.putExtra("content", content);
                intent.putExtra("index", i);
                startActivityForResult(intent, EDIT_NOTE_REQUEST_CODE);
            }
        });

        noteView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Note curNote = (Note) adapterView.getItemAtPosition(i);
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setTitle("Delete a Note")
                            .setMessage("Are you sure you want to delete your " + curNote.toString() + " note?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    removeNote(curNote);
                                }
                            })
                            .setNegativeButton("No", null);
                alertBuilder.show();
                return true;
            }
        });

        setContentView(root);
    }

    /**
     * editNote
     * This method is called from onActivityResult to edit a note
     * already in the lsit.
     * @param title
     * @param content
     * @param type
     * @param index
     */
    private void editNote(String title, String content, String type, int index)
    {
        notes.get(index).setTitle(title);
        notes.get(index).setContent(content);
        notes.get(index).setType(type);
        noteAdapter.notifyDataSetChanged();
    }

    /**
     * addNewNote
     * This method is called from on activity result to add a new
     * note to the list
     * @param title
     * @param content
     * @param type
     */
    private void addNewNote(String title, String content, String type)
    {
        Note newNote = new Note(title, content, type);
        notes.add(newNote);
        noteAdapter.notifyDataSetChanged();
    }

    /**
     * removeNote
     * This method is called when a note is long clicked and selected
     * to be removed from the list.
     * @param noteToRemove
     */
    private void removeNote(Note noteToRemove)
    {
        notes.remove(noteToRemove);
        noteAdapter.notifyDataSetChanged();
    }
}
