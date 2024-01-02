package com.example.suarabersama;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandlerComment extends SQLiteOpenHelper {
    private static final String DB_NAME = "CommentDB";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Komentar";
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String UNTUK_COL = "pasangan_calon";
    private static final String ACTOR_COL = "nama_komentator";
    private static final String KOTA_COL = "kota_komentator";
    private static final String HEADLINE_COL = "judul_komentar";
    private static final String ISI_COL ="isi_komentar";


    public DBHandlerComment(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + UNTUK_COL + " INTEGER,"
                + KOTA_COL + " TEXT,"
                + ACTOR_COL + " TEXT,"
                + ISI_COL + " TEXT,"
                + HEADLINE_COL + " TEXT)";
        db.execSQL(query);
    }

    public void addData(String paslon, String nama, String kota, String headline, String isi) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(UNTUK_COL, paslon);
        values.put(ACTOR_COL, nama);
        values.put(KOTA_COL, kota);
        values.put(HEADLINE_COL, headline);
        values.put(ISI_COL, isi);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
