package com.example.stephie.prueba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.net.ssl.KeyManager;

/**
 * Created by Stephie on 18-10-2016.
 */

public class AnimalDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Animales";
    private static final String TABLE_PERFILES = "perfiles";


    private static final String KEY_ID = "id";
    private static final String KEY_NOMBRE = "username";
    private static final String KEY_PESO = "pass";
    private static final String KEY_DUENO = "server";

    private static final String key = "12345678909876543212345678909876";
    private static final String iv = "1234567890987654";

    private KeyManager km;


    public AnimalDB(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_PERFILES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NOMBRE + " INTEGER,"
                + KEY_PESO + " TEXT," + KEY_DUENO + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERFILES);
        // Create tables again
        onCreate(db);
    }
    public void addAnimal(Animal animal) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NOMBRE, animal.getNombre()); // Contact Name
        values.put(KEY_PESO,animal.getPeso());
        values.put(KEY_DUENO,animal.getDueno());
        // Inserting Row
        db.insert(TABLE_PERFILES, null, values);
        db.close(); // Closing database connection
    }

    public List<Animal> getAllUsers() {
        List<Animal> AnimalList = new ArrayList<Animal>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PERFILES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Animal contact = new Animal();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setNombre(cursor.getString(1));
                contact.setPeso(cursor.getInt(2));
                contact.setDueno(cursor.getString(3));
                // Adding contact to list
                AnimalList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return AnimalList;
    }
    public int updateAnimal(Animal animal) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NOMBRE, animal.getNombre());

        // updating row
        return db.update(TABLE_PERFILES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(animal.getId()) });
    }

    public void deleteAnimal(Animal animal) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PERFILES, KEY_ID + " = ?",
                new String[] { String.valueOf(animal.getId()) });
        db.close();
    }
    public int getAnimalCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PERFILES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }
}


