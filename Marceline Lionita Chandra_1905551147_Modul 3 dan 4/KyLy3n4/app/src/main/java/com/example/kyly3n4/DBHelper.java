package com.example.kyly3n4;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
    private final Context context;


    public DBHelper(Context context) {
        super(context, "db_kyly", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tb_user(username TEXT PRIMARY KEY, name TEXT, email TEXT, gender TEXT, grup TEXT, age TEXT, keterangan TEXT DEFAULT '', is_valid TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS db_kyly");
        onCreate(db);
    }

    public Boolean insert(String username, String name, String email, String gender, String grup, String age, String keterangan, String is_valid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("gender", gender);
        contentValues.put("grup", grup);
        contentValues.put("age", age);
        contentValues.put("keterangan", keterangan);
        contentValues.put("is_valid", is_valid);
        long result = db.insert("tb_user", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor readalldata() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = ("SELECT*FROM tb_user ORDER BY username ASC");
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    public void deleteData(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM tb_user WHERE username='" + username + "'");
    }

    void updateData(String username, String keterangan, String is_valid){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("keterangan", keterangan);
        cv.put("is_valid", is_valid);


        long result = db.update("tb_user", cv, "username" + "='" + username + "'", null);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(context, Data.class);
            context.startActivity(intent);
        }
    }
}