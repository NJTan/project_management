package com.example.finalltest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ItemDataBaseHelper extends SQLiteOpenHelper {
    static String name="project.db";
    static int dbVersion=3;
    private  String item_table="item";
    public ItemDataBaseHelper(Context context) {
        super(context, name, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String item_sql="create table IF NOT EXISTS "+item_table+"(ino integer  primary key  AUTOINCREMENT,Iname varchar(40),Inumber integer,start_plan_time date,end_plan_time date,record_time date)";
        db.execSQL(item_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
