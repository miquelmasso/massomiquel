package com.example.memesity.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.memesity.DB.MemesContract.*;
import com.example.memesity.Models.Memes;

import java.util.ArrayList;

public class MemesDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "memes.db";
 // command to create table with all variables
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +
            MemesEntry.TABLE_NAME + "(" +
            MemesEntry.ID_PUBLICACIO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
       //   MemesEntry.ID_FOTO_USUARI + " INTEGER  , " +
            MemesEntry.COLUMN_NAME_DESCRIPTION + " TEXT ," +
            MemesEntry.COLUMN_NAME_NOM_USUARI + " TEXT UNIQUE " +
        ")";
    private long insert;

    public MemesDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void dropAllMemes(SQLiteDatabase db){
        //Check the bd is open
        if (db.isOpen()){
            db.delete(MemesEntry.TABLE_NAME, null, null); //if open, delete it
        }else{
            Log.i("sql","Database is closed");
        }
    }

    public void insertMemes(SQLiteDatabase db, Memes c) {
        //Check the bd is open
        if (db.isOpen()) {
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the contacts getting all values
            values.put(MemesEntry.COLUMN_NAME_DESCRIPTION, c.getDescripcio());
            values.put(MemesEntry.COLUMN_NAME_NOM_USUARI, c.getNom_usuari());

            db.insert(MemesEntry.TABLE_NAME, null, values);

        } else {
            Log.i("sql", "Database is closed");
        }
    }

    //set all local variables

    private String nom_usuari;
    private String descripcio;
    //private int id_foto_usuari=1;
    private int id_publicacio;

    public ArrayList<Memes> getMemes(SQLiteDatabase db){ //get all values from table
        ArrayList<Memes> data=new ArrayList<Memes>();
        Cursor cursor = db.query(MemesEntry.TABLE_NAME, new String[]{"nom_usuari", "descripcio", "id_publicacio"},null, null, null, null, null);
        //Cursor cursor = db.query(MemesEntry.TABLE_NAME, new String[]{"nom_usuari", "descripcio", "id_foto_usuari", "id_publicacio"},null, null, null, null, null);
        Memes m;
        while(cursor.moveToNext()){
            m = new Memes(cursor.getString(0), cursor.getString(1), cursor.getInt(2));//cursos with only this items
            data.add(m);
        }
        cursor.close();
        return data;
    }

    public void deleteMemes(SQLiteDatabase db, int id_publicacio){ //delete all values from table where id is ID
        if (db.isOpen()){
            String ID = String.valueOf(id_publicacio);
            Log.i("test tests", ID);
            db.execSQL("DELETE FROM " + MemesEntry.TABLE_NAME + " WHERE id_publicacio = " + ID);
        }else{
            Log.i("test sql","Database is closed");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
