package com.example.ex6_recyclerview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemLandscapeAdapter extends RecyclerView.Adapter<ItemLandscapeAdapter.ItemLandscapeViewHolder> {
    Context context;
    ArrayList<LandScape> data;

    public ItemLandscapeAdapter(Context context, ArrayList<LandScape> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ItemLandscapeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.landscape_item, parent, false);
        return new ItemLandscapeViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ItemLandscapeViewHolder holder, int position) {
        LandScape land = data.get(position);
        holder.textViewLandscape.setText(land.getLandScapeName());
            String packageName = holder.itemView.getContext().getPackageName();
            String fileImageName = land.getLandScapeImage();
            int imageID = holder.itemView.getResources().getIdentifier(fileImageName,"mipmap",packageName);
            holder.imageViewLandscape.setImageResource(imageID);
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
            imageViewLandscape = itemView.findViewById(R.id.imageLandScape);
            textViewLandscape = itemView.findViewById(R.id.textLandScape);
        }
    }
}