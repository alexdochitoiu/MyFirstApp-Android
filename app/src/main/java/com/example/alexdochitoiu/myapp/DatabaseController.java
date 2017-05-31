package com.example.alexdochitoiu.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.sql.Date;

/**
 * Created by Alex Dochitoiu on 6/1/2017.
 */

public class DatabaseController extends SQLiteOpenHelper {
    public DatabaseController(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "database.db", factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE events(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DATE TEXT, DETAILS TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS events;");
        onCreate(sqLiteDatabase);
    }

    public void insertEvent(String name, String date, String details) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("DATE", date);
        contentValues.put("DETAILS", details);
        this.getWritableDatabase().insertOrThrow("EVENTS","",contentValues);
    }

    public String listAllEvents() {
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM EVENTS", null);
        String result="";
        while(cursor.moveToNext()) {
            result += cursor.getString(0)+" "+cursor.getString(1)+"\n";
        }
        return result;
    }
}
