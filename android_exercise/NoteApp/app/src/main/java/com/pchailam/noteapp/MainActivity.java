package com.pchailam.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListNoteAdapter.OnItemClickListener{
    static ArrayList<Note> list;
    private ListNoteAdapter adapter;
    private RecyclerView recyclerView;
    TextView textViewCount;
    private MyDatabase myDatabase;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        myDatabase = new MyDatabase(MainActivity.this);
        list = myDatabase.readData();

        textViewCount = findViewById(R.id.countNote);
        textViewCount.setText(String.valueOf(list.size()));

        recyclerView = findViewById(R.id.recyclerNote);

        adapter = new ListNoteAdapter(MainActivity.this, list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton btnAddNewNode = findViewById(R.id.btnAddNote);
        btnAddNewNode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewNote();
            }
        });
//        btnMenu = findViewById(R.id.btnMenu);
//        btnMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnMenu);
//            }
//        });

    }
    public void createNewNote() {
        Intent intent = new Intent(this, InNoteActivity.class);
        startActivityForResult(intent,8000);
    }
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == 8000 && resultCode == RESULT_OK) {
            if (intent.getBooleanExtra("updateData", false)) {
                adapter.notifyDataSetChanged();
                String sumNote = String.valueOf(list.size());
                textViewCount.setText(sumNote);
            }
        }
    }
    @Override
    public void onItemClick(int position) {
        Note clickedItem = list.get(position);

        Intent intent = new Intent(this, InNoteActivity.class);
        intent.putExtra("position", position);
        intent.putExtra("title", clickedItem.getTitle());
        intent.putExtra("content", clickedItem.getContent());
        intent.putExtra("date", clickedItem.getDate());

        startActivityForResult(intent, 8000);
    }
}