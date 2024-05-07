package com.pchailam.noteapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ArrayList<Card> list;
    ListNoteAdapter adapter;
    RecyclerView recyclerView;
    private TextView textViewCount;
    private EditText textViewTitle;
    private EditText textViewContent;
    private TextView textViewTime;
    private TextView textViewDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = getDataForRecycler();

        String sumNote = String.valueOf(list.size());
        textViewCount = findViewById(R.id.countNote);
        textViewCount.setText(sumNote);

        recyclerView = findViewById(R.id.recyclerNote);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ListNoteAdapter(this, list);
        recyclerView.setAdapter(adapter);

        ImageButton addNewNoteButton = findViewById(R.id.addNewNote);
        addNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewNote();
            }
        });
    }
    public void NewNote() {
        Intent intent = new Intent(this, InNoteActivity.class);
        startActivityForResult(intent,8000);
    }
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 8000 && resultCode == RESULT_OK) {
            Calendar calendar = Calendar.getInstance();
            String time = String.valueOf(calendar.getTimeInMillis());

            textViewTime = findViewById(R.id.tvTime);
            textViewTime.setText(time);

            String title = data.getStringExtra("title");
            String content = data.getStringExtra("content");

            Card newCard = new Card(title, content, time);

            list.add(newCard);

            adapter.notifyDataSetChanged();
        }
    }
    private ArrayList<Card> getDataForRecycler() {
        ArrayList<Card> list = new ArrayList<>();
        list.add(new Card("First Exam","May 23, 2015","12/12/2012"));
        list.add(new Card("Second Exam","June 09, 2015","12/12/2012"));
        list.add(new Card("My Test Exam","April 27, 2017","12/12/2012"));
        return list;
    }
}