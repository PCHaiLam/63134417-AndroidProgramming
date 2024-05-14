package com.pchailam.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class InNoteActivity extends AppCompatActivity {
    EditText editTextTitle, editTextContent;
    TextView textViewTime, textViewDateInNote;
    int position;
    private MyDatabase myDatabase;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_note);

        editTextTitle = findViewById(R.id.edtTitle);
        editTextContent = findViewById(R.id.edtContent);
        textViewTime = findViewById(R.id.tvTime);
        textViewDateInNote = findViewById(R.id.tvDateInNote);

        myDatabase = new MyDatabase(InNoteActivity.this);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", -1);

        if (position != -1) {
            String dateTime = intent.getStringExtra("date");

            String[] part = dateTime.split(" ");
            String time = part[0];
            String date = part[1];
            textViewTime.setText(time);
            textViewDateInNote.setText(date);

            editTextTitle.setText(intent.getStringExtra("title"));
            editTextContent.setText(intent.getStringExtra("content"));
        }
        else {
            createNewNote();
        }

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageButton btnMenu = findViewById(R.id.btnMenuInNote);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(InNoteActivity.this, btnMenu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();

                        if (id == R.id.deleteInNote) {
                            myDatabase.deleteNote(MainActivity.list.get(position).getId());

                            MainActivity.list.remove(position);
                            Intent intent = new Intent();
                            intent.putExtra("updateData", true);
                            setResult(RESULT_OK, intent);
                            finish();

                            return true;
                        }
                        return false;
                    }
                });
                popupMenu.inflate(R.menu.popup_menu_in_note);
                popupMenu.show();
            }
        });

        ImageButton btnCompleted = findViewById(R.id.btnComplete);
        btnCompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveNote();
            }
        });
    }
    public void SaveNote() {
        String title = editTextTitle.getText().toString();
        String content = editTextContent.getText().toString();
        String newDateTime = getCurrentDateTime();

        myDatabase = new MyDatabase(InNoteActivity.this);

        if (position != -1) {
            Note newNote= new Note(MainActivity.list.get(position).getId(),title,content,newDateTime);
            myDatabase.editNote(newNote,MainActivity.list.get(position).getId());
        }
        else {
            Note newNote= new Note(position,title,content,newDateTime);
            myDatabase.addNote(newNote);
        }

        if (!title.isEmpty()) {
            MainActivity.list.get(position).setTitle(title);
            MainActivity.list.get(position).setContent(content);

            Intent intent = new Intent();
            intent.putExtra("updateData", true);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
    public void createNewNote() {
        String dateTime = getCurrentDateTime();
        String time = dateTime.split(" ")[0];
        String date = dateTime.split(" ")[1];

        textViewTime = findViewById(R.id.tvTime);
        textViewTime.setText(time);
        textViewDateInNote = findViewById(R.id.tvDateInNote);
        textViewDateInNote.setText(date);

    }
    public String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy", Locale.getDefault());
        return sdf.format(Calendar.getInstance().getTime());
    }
}