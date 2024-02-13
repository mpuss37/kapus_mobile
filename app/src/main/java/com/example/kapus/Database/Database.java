package com.example.kapus.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.checkerframework.checker.units.qual.C;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "kapus.db";
    private static int DATABASE_VERSION = 1;
    private Context context;
    private ContentValues contentValues;

    public final String table_user = "user";
    public final String col_id_user = "id_user";
    public final String col_username = "username";
    public final String col_password = "password";
    public final String col_email = "email";
    public final String col_nama_lengkap = "nama_lengkap";
    public final String col_alamat = "alamat";

    public final String table_buku = "buku";
    public final String col_id_buku = "id_buku";
    public final String col_judul_buku = "judul";
    public final String col_penulis = "penulis";
    public final String col_penerbit = "penerbit";
    public final String col_tahun_terbit = "tahun_terbit";

    public final String table_admin = "admin";
    public final String table_officer = "officer";
    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
