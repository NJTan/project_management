package com.example.finalltest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Item_useDataBaseHelper extends SQLiteOpenHelper {
    static String name="project.db";
    static int dbVersion=3;
    private  String item_user_table="user_item";
    public Item_useDataBaseHelper(Context context) {
        super(context, name, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String item_user_sql="create table if not exists "+item_user_table+"(username varchar(20),ino integer,beizhu text,primary key(username,ino))";
        db.execSQL(item_user_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
