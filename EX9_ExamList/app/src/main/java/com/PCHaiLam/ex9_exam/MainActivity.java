package com.PCHaiLam.ex9_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.PCHaiLam.ex9_viewpaper2.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ItemExamAdapter adapter;
    //data
    ArrayList<Exam> list;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = getDataForRecycler();

        recyclerView = findViewById(R.id.recyclerExam);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ItemExamAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Exam> getDataForRecycler() {
        ArrayList<Exam> list = new ArrayList<>();
        list.add(new Exam("First Exam","May 23, 2015","Best Of Luck "));
        list.add(new Exam("Second Exam","June 09, 2015","b of l"));
        list.add(new Exam("My Test Exam","April 27, 2017","This is testing exam .."));
        return list;
    }
}