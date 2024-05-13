package com.pchailam.noteapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListNoteAdapter extends RecyclerView.Adapter<ListNoteAdapter.ListNoteViewHolder> {
    @SuppressLint("StaticFieldLeak")
    static Context context;
    static ArrayList<Note> data;
    static MyDatabase myDatabase;
    private static OnItemClickListener mListener;

    public ListNoteAdapter(Context context, ArrayList<Note> data) {
        ListNoteAdapter.context = context;
        ListNoteAdapter.data = data;
    }

    @NonNull
    @Override
    public ListNoteAdapter.ListNoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.grid_style_note, parent, false);
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
    public void deleteNote(int pos) {
        int noteId = data.get(pos).getId();

        myDatabase = new MyDatabase(context);
        data = myDatabase.readData();

        SQLiteDatabase database = context.openOrCreateDatabase("NoteLibrary.db",Context.MODE_PRIVATE,null);
        database.delete("my_library","id = ?", new String[]{String.valueOf(noteId)});
        database.close();

        data.remove(pos);
        notifyItemRemoved(pos);
        Toast.makeText(context, "Ghi chú đã được xóa " + pos, Toast.LENGTH_SHORT).show();
    }
    final class ListNoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
        TextView textViewTitle, textViewContent, textViewDate;
        ImageButton btnMenu;

        @SuppressLint("WrongViewCast")
        public ListNoteViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.tvTitle);
            textViewContent = itemView.findViewById(R.id.tvContent);
            textViewDate = itemView.findViewById(R.id.tvDate);
            btnMenu = itemView.findViewById(R.id.btnMenu);

            itemView.setOnClickListener(this);
            btnMenu.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btnMenu) {
                //click vào popupmenu trên card note
                showPopupMenu();
            } else {
                //click vào card note
                if (mListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(position);
                    }
                }
            }
        }
        private void showPopupMenu() {
            // https://www.geeksforgeeks.org/popup-menu-in-android-with-example/?ref=header_search
            PopupMenu popupMenu = new PopupMenu(context, btnMenu);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.inflate(R.menu.popup_menu);
            popupMenu.show();
        }
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.typing) {
                return true;
            } else if (id == R.id.delete) {
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
                    deleteNote(position);
                    return true;
                }
            }
            return false;
        }
    }
}