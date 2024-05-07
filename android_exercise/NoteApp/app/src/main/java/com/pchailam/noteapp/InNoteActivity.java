package com.pchailam.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class InNoteActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextContent;
    private TextView textViewTime;
    private TextView textViewDateInNote;
    private String dateTime = getCurrentDateTime();
    int position;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_note);

        editTextTitle = findViewById(R.id.edtTitle);
        editTextContent = findViewById(R.id.edtContent);
        textViewTime = findViewById(R.id.tvTime);
        textViewDateInNote = findViewById(R.id.tvDateInNote);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", -1);
        if (position != -1) {

            dateTime = intent.getStringExtra("date");
            String[] part = dateTime.split(" ");
            String time = part[0];
            String date = part[1];

            editTextTitle.setText(intent.getStringExtra("title"));
            editTextContent.setText(intent.getStringExtra("content"));
            textViewTime.setText(time);
            textViewDateInNote.setText(date);
        } else {
            createNewNote();
        }


        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveNote();
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

        if (!title.isEmpty() && !content.isEmpty()) {
            MainActivity.list.get(position).setTitle(title);
            MainActivity.list.get(position).setContent(content);

            Intent intent = new Intent();
            intent.putExtra("updateData", true);
            setResult(RESULT_OK, intent);

            Toast.makeText(getApplicationContext(), "Đã cập nhật note", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    public void createNewNote() {
        String time = dateTime.split(" ")[0];
        String date = dateTime.split(" ")[1];

        textViewTime = findViewById(R.id.tvTime);
        textViewTime.setText(time);
        textViewDateInNote = findViewById(R.id.tvDateInNote);
        textViewDateInNote.setText(date);

        Card newCard = new Card("New Note", "Content of New Note", dateTime);
        MainActivity.list.add(newCard);

        Intent intent = new Intent();
        intent.putExtra("updateData", true);
        setResult(RESULT_OK, intent);
        finish();
    }

    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy", Locale.getDefault());
        return sdf.format(Calendar.getInstance().getTime());
    }
}