package com.example.finalltest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	static String name="project.db";
	static int dbVersion=3;
	private String user_table="pro_user";
	private  String item_user_table="user_item";
	private  String item_table="item";
	private String item_detail_table="item_detail";
	public DatabaseHelper(Context context) {
		super(context, name, null, dbVersion);
	}
	public void onCreate(SQLiteDatabase db) {
		String sql="create table "+user_table+"(username varchar(20) primary key ,password varchar(20),age integer,sex varchar(2),userType varchar(20))";
		db.execSQL(sql);
//		String item_sql="create table "+item_table+"(ino integer  primary key  AUTOINCREMENT,Iname varchar(40),Inumber integer,start_plan_time date,end_plan_time date,record_time date)";
//		db.execSQL(item_sql);
		/*String item_user_sql="create table "+item_user_table+"(username varchar(20),ino integer,beizhu text,primary key(usename,ino))";
		db.execSQL(item_user_sql);

		String item_detail_sql="create table "+item_detail_table+"(ino integer primary key,Istate integer, description text,start_real_time date,end_real_time date)";
		db.execSQL(item_detail_sql);*/
	}
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//		db.execSQL("DROP TABLE IF EXISTS "+user_table);

//		db.execSQL("DROP TABLE IF EXISTS "+item_user_table);
//		onCreate(db);
	}

}
