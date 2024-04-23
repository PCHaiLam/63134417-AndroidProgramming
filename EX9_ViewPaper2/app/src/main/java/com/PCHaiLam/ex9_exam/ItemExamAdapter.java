package com.PCHaiLam.ex9_exam;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemExamAdapter extends RecyclerView.Adapter<ItemExamAdapter.ItemExamViewHolder> {
    Context context;
    static ArrayList<Exam> data;

    public ItemExamAdapter(Context context, ArrayList<Exam> data) {
        this.context = context;
        ItemExamAdapter.data = data;
    }

    @NonNull
    @Override
    public ItemExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card, parent, false);
        return new ItemExamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemExamAdapter.ItemExamViewHolder holder,final int position) {
        Exam ex = data.get(position);
        holder.textViewName.setText(ex.getName());
        holder.textViewDate.setText(ex.getDate());
        holder.textViewCmt.setText(ex.getCmt());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static final class ItemExamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewName;
        TextView textViewDate;
        TextView textViewCmt;
        public ItemExamViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.ExName);
            textViewDate = itemView.findViewById(R.id.ExDate);
            textViewCmt = itemView.findViewById(R.id.ExCmt);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            Exam land = data.get(clickedPosition);
            Toast.makeText(v.getContext(), "Clicked: " + land.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}