package com.pchailam.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class InNoteActivity extends AppCompatActivity {
    private EditText textViewTitle;
    private EditText textViewContent;
    private TextView textViewTime;
    private TextView textViewDateInNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_note);
        createNewNote();
    }
    public void createNewNote() {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String time = sdf1.format(calendar.getTime());
        String date = sdf2.format(calendar.getTime());

        
        textViewTime = findViewById(R.id.tvTime);
        textViewTime.setText(time);
        textViewDateInNote = findViewById(R.id.tvDateInNote);
        textViewDateInNote.setText(date);
    }
}