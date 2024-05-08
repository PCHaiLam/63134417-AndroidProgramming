package com.pchailam.noteapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListNoteAdapter extends RecyclerView.Adapter<ListNoteAdapter.ListNoteViewHolder> {
    @SuppressLint("StaticFieldLeak")
    static Context context;
    static ArrayList<Note> data;
    private static OnItemClickListener mListener;

    public ListNoteAdapter(Context context, ArrayList<Note> data) {
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
        Note card =data.get(position);
        holder.textViewTitle.setText(card.getTitle());
        holder.textViewContent.setText(card.getContent());
        holder.textViewDate.setText(card.getDate());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    static final class ListNoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewTitle, textViewContent, textViewDate;

        @SuppressLint("WrongViewCast")
        public ListNoteViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.tvTitle);
            textViewContent = itemView.findViewById(R.id.tvContent);
            textViewDate = itemView.findViewById(R.id.tvDate);

            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(position);
                }
            }
        }
    }
}