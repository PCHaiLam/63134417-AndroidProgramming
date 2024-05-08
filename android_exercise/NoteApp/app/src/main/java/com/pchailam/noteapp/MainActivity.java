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
    ListNoteAdapter adapter;
    RecyclerView recyclerView;
    TextView textViewCount;
    MyDatabase myDatabase;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
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
    public ArrayList<Note> getDataForRecycler() {
        ArrayList<Note> list = new ArrayList<>();
        list.add(new Note("Kho Hà Quang","a b c d e f g h i j k l m n o p q r s","12:00 12/12/2012"));
        list.add(new Note("Kho Vinpearl"," q ư e r t y u i o a s d f g","13:00 13/12/2012"));
        list.add(new Note("Kho","ư ê â ă ô ơ","14:00 14/12/2012"));
        return list;
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