package com.example.prak7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_kampus";
    private static final String tb_parfum = "tb_parfum";
    private static final String tb_parfum_id = "id";
    private static final String tb_parfum_jenis = "jenis";
    private static final String tb_parfum_pengertian = "pengertian";
    private static final String CREATE_TABLE_PARFUM = "CREATE TABLE " +
    tb_parfum +"("
            + tb_parfum_id + " INTEGER PRIMARY KEY ,"
            + tb_parfum_jenis + " TEXT ,"
            + tb_parfum_pengertian + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PARFUM);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateParfum (Parfum data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_parfum_id, data.get_id());
        values.put(tb_parfum_jenis, data.get_jenis());
        values.put(tb_parfum_pengertian, data.get_pengertian());
        db.insert(tb_parfum, null, values);
        db.close();
    }
    public List<Parfum> ReadParfum() {
        List<Parfum> listPr = new ArrayList<Parfum>();
        String selectQuery = "SELECT * FROM " + tb_parfum;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Parfum data = new Parfum();
                data.set_id(cursor.getString(0));
                data.set_jenis(cursor.getString(1));
                data.set_pengertian(cursor.getString(2));
                listPr.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listPr;
    }
    public int UpdateParfum (Parfum data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_parfum_jenis, data.get_jenis());
        values.put(tb_parfum_pengertian, data.get_pengertian());
        return db.update(tb_parfum, values, tb_parfum_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteParfum(Parfum data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_parfum,tb_parfum_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
