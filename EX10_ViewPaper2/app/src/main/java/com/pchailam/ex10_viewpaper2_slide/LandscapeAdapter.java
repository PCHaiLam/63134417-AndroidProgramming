package com.pchailam.ex10_viewpaper2_slide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LandscapeAdapter extends RecyclerView.Adapter<LandscapeAdapter.LandscapeViewHolder> {
    Context context;
    static ArrayList<Landscape> data;
    public LandscapeAdapter(Context context, ArrayList<Landscape> data) {
        this.context = context;
        LandscapeAdapter.data = data;
    }
    @NonNull
    @Override
    public LandscapeAdapter.LandscapeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card, parent, false);
        return new LandscapeViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull LandscapeAdapter.LandscapeViewHolder holder, int position) {
        Landscape land = data.get(position);
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
    static final class LandscapeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewLandscape;
        ImageView imageViewLandscape;
        public LandscapeViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageViewLandscape = itemView.findViewById(R.id.imageLandScape);
            textViewLandscape = itemView.findViewById(R.id.textLandScape);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            Landscape land = data.get(clickedPosition);
            Toast.makeText(v.getContext(), "Clicked: " + land.getLandScapeName(), Toast.LENGTH_SHORT).show();
        }
    }
}