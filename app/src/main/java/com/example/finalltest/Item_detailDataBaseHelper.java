package com.example.finalltest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Item_detailDataBaseHelper extends SQLiteOpenHelper {
    static String name="project.db";
    static int dbVersion=3;
    private  String item_detail_table="item_detail";
    public Item_detailDataBaseHelper(Context context) {
        super(context, name, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String item_detail_sql="create table if not exists "+item_detail_table+"(ino integer primary key,Istate integer, description text,start_real_time date,end_real_time date)";
        db.execSQL(item_detail_sql);;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
