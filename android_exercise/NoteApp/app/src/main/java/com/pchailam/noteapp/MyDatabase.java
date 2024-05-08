package com.pchailam.noteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {
    private final Context context;
    private static final String DATABASE_NAME = "NoteLibrary.db";
    private static final String TABLE_NAME = "my_library";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_CONTENT = "content";
    private static final String COLUMN_DATE = "date";
//    private static final String COLUMN_ID_TYPE_foreign = "type";
//    private static final String TABLE_TYPE_NOTE = "type_note";
//    private static final String COLUMN_ID_TYPE = "id";
//    private static final String COLUMN_TYPE = "type";


    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase database;
    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String createTypeNoteTableQuery = "CREATE TABLE " + TABLE_TYPE_NOTE + " (" +
//                COLUMN_ID_TYPE + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                COLUMN_TYPE + " TEXT)";
//        db.execSQL(createTypeNoteTableQuery);

        String createNoteTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_CONTENT + " TEXT, " +
                COLUMN_DATE + " TEXT);";
//                COLUMN_ID_TYPE + " INTEGER, " +
//                "FOREIGN KEY(" + COLUMN_ID_TYPE + ") REFERENCES " + TABLE_TYPE_NOTE + "(" + COLUMN_ID_TYPE + "))";
        db.execSQL(createNoteTableQuery);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addNote(String title, String content, String dateTime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_CONTENT, content);
        cv.put(COLUMN_DATE, dateTime);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Lỗi khi thêm ghi chú", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Ghi chú đã được thêm", Toast.LENGTH_SHORT).show();
        }
    }
//    void addType(String type) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//
//        cv.put(COLUMN_TYPE, type);
//
//        long result = db.insert(TABLE_TYPE_NOTE, null, cv);
//        if (result == -1) {
//            Toast.makeText(context, "Lỗi khi thêm loại ghi chú", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(context, "Loại ghi chú đã được thêm", Toast.LENGTH_SHORT).show();
//        }
//    }
    Cursor readALlData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null)
            cursor = db.rawQuery(query, null);
        return cursor;
    }
}
