package com.example.finalltest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class item_detailService {
    private Item_detailDataBaseHelper dbHelper;
    public item_detailService(Context context){
        dbHelper=new Item_detailDataBaseHelper(context);
    }
    public boolean saveItem_detail(Item_detail item_detail){
       SQLiteDatabase sdb=dbHelper.getReadableDatabase();
       SQLiteDatabase wdb=dbHelper.getWritableDatabase();
       this.dbHelper.onCreate(wdb);
       String sql="insert into item_detail(ino,description)values(?,?)";
       Object obj[]={item_detail.getIno(),item_detail.getDescription()};
       sdb.execSQL(sql,obj);
       return  true;
    }
}
