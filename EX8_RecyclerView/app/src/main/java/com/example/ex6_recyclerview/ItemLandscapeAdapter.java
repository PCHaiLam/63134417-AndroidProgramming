package com.example.ex6_recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemLandscapeAdapter extends RecyclerView.Adapter<ItemLandscapeAdapter.ItemLandscapeViewHolder> {

    @NonNull
    @Override
    public ItemLandscapeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }
    @Override
    public void onBindViewHolder(@NonNull ItemLandscapeViewHolder holder, int position) {

    }
    @Override
    public int getItemCount() {
        return 0;
    }
    static final class ItemLandscapeViewHolder extends RecyclerView.ViewHolder {
        TextView textViewLandscape;
        ImageView imageViewLandscape;
        public ItemLandscapeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}