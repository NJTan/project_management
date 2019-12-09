package com.example.finalltest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class itemService {
    private ItemDataBaseHelper dbHelper;
    public  itemService(Context context){
        dbHelper=new ItemDataBaseHelper(context);
    }
    public boolean InputItem(Item item){
        SQLiteDatabase sdb =dbHelper.getReadableDatabase();
        SQLiteDatabase wdb=dbHelper.getWritableDatabase();
//        this.dbHelper.onUpgrade(wdb,3,3);
        this.dbHelper.onCreate(wdb);
        String sql="insert into item(Iname,Inumber,start_plan_time,end_plan_time,record_time)values(?,?,?,?,?)";
        Object obj[]={item.getIname(),item.getInumber(),item.getStart_plan_time(),item.getEnd_plan_time(),item.getRecord_time()};
        sdb.execSQL(sql,obj);
        return true;
    }
}
