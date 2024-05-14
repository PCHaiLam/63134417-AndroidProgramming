package com.pchailam.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
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

        LinearLayoutManager listLayoutManager = new LinearLayoutManager(MainActivity.this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton btnAddNewNode, btnMenu;
        btnAddNewNode = findViewById(R.id.btnAddNote);
        btnAddNewNode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewNote();
            }
        });
        btnMenu = findViewById(R.id.btnMenuNote);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnMenu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.grid_view) {
                            recyclerView.setLayoutManager(gridLayoutManager);
                            return true;
                        } else if (id == R.id.list_view) {
                            recyclerView.setLayoutManager(listLayoutManager);
                            return true;
                        }
                        return false;
                    }
                });
                popupMenu.inflate(R.menu.popup_menu_app);
                popupMenu.show();
            }
        });

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