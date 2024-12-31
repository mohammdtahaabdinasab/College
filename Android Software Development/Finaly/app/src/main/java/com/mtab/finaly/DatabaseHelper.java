package com.mtab.finaly;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "UserDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + "users" + "(" + "email" + " TEXT UNIQUE" + ")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "users");
        onCreate(db);
    }

    public boolean addUser(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", email);

        try {
            db.insertOrThrow("users", null, values);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("users",
                new String[]{"email"},
                "email" + " = ?",
                new String[]{email},
                null, null, null);
        
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }
} 