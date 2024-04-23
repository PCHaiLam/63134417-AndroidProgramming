package com.example.ex6_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //adapter
    ItemLandscapeAdapter adapter;
    //data
    ArrayList<LandScape> list;
    RecyclerView recyclerViewLand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = getDataForRecycler();

        recyclerViewLand = findViewById(R.id.recyclerLand);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewLand.setLayoutManager(layoutManager);

        adapter = new ItemLandscapeAdapter(this, list);
        recyclerViewLand.setAdapter(adapter);
    }
    private ArrayList<LandScape> getDataForRecycler() {
        ArrayList<LandScape> listData = new ArrayList<>();
        listData.add(new LandScape("Elephant","elephant"));
        listData.add(new LandScape("Fox","fox"));
        listData.add(new LandScape("Parrot","parrot"));
        listData.add(new LandScape("Wolf","wolf"));
        return listData;
    }
}