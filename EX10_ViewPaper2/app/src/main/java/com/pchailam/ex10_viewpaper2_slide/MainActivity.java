package com.pchailam.ex10_viewpaper2_slide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //adapter
    LandscapeAdapter adapter;
    //data
    ArrayList<Landscape> viewPaperData;
    ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPaperData = getDataForViewPaper();

        viewPager2 = findViewById(R.id.vp2Land);

        adapter = new LandscapeAdapter(this, viewPaperData);

        viewPager2.setAdapter(adapter);
    }
    private ArrayList<Landscape> getDataForViewPaper() {
        ArrayList<Landscape> listData = new ArrayList<>();
        listData.add(new Landscape("Elephant","elephant"));
        listData.add(new Landscape("Fox","fox"));
        listData.add(new Landscape("Parrot","parrot"));
        listData.add(new Landscape("Wolf","wolf"));
        return listData;
    }
}