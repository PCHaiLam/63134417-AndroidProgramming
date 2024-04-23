package com.example.ex6_recyclerview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemLandscapeAdapter extends RecyclerView.Adapter<ItemLandscapeAdapter.ItemLandscapeViewHolder> {
    Context context;
    static ArrayList<LandScape> data;

    public ItemLandscapeAdapter(Context context, ArrayList<LandScape> data) {
        this.context = context;
        ItemLandscapeAdapter.data = data;
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
        return data.size();
    }
    static final class ItemLandscapeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewLandscape;
        ImageView imageViewLandscape;
        public ItemLandscapeViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageViewLandscape = itemView.findViewById(R.id.imageLandScape);
            textViewLandscape = itemView.findViewById(R.id.textLandScape);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            LandScape land = data.get(clickedPosition);
            Toast.makeText(v.getContext(), "Clicked: " + land.getLandScapeName(), Toast.LENGTH_SHORT).show();
        }
    }
}