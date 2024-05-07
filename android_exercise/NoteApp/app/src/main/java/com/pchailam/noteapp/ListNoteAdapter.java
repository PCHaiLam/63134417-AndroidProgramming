package com.pchailam.noteapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Date;

public class ListNoteAdapter extends RecyclerView.Adapter<ListNoteAdapter.ListNoteViewHolder> {
    @SuppressLint("StaticFieldLeak")
    static Context context;
    static ArrayList<Card> data;

    public ListNoteAdapter(Context context, ArrayList<Card> data) {
        ListNoteAdapter.context = context;
        ListNoteAdapter.data = data;
    }

    @NonNull
    @Override
    public ListNoteAdapter.ListNoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card_layout, parent, false);
        return new ListNoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListNoteAdapter.ListNoteViewHolder holder, int position) {
        Card card =data.get(position);
        holder.textViewTitle.setText(card.getTitle());
        holder.textViewContent.setText(card.getContent());
        holder.textViewDate.setText(card.getDate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static final class ListNoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewTitle;
        TextView textViewContent;
        TextView textViewDate;
        @SuppressLint("WrongViewCast")
        public ListNoteViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.tvTitle);
            textViewContent = itemView.findViewById(R.id.tvContent);
            textViewDate = itemView.findViewById(R.id.tvDate);

        }
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Intent intent = new Intent(context, InNoteActivity.class);
                context.startActivity(intent);
            }

        }
    }
}