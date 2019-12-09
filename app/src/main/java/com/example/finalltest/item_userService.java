package com.example.finalltest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class item_userService {
    private Item_useDataBaseHelper dbHelper;
    public item_userService(Context context){
        dbHelper=new Item_useDataBaseHelper(context);
    }
    public boolean Inputitem_userService(Item_user item_user){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        SQLiteDatabase wdb=dbHelper.getWritableDatabase();
        this.dbHelper.onCreate(wdb);
        String sql="insert into user_item(username,ino)values(?,?)";
        Object obj[]={item_user.getUsername(),item_user.getIno()};
        sdb.execSQL(sql,obj);
        return true;
    }
}
