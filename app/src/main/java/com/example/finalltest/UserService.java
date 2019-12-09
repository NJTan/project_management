package com.example.finalltest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class UserService {
	private DatabaseHelper dbHelper;
	public UserService(Context context){
		dbHelper=new DatabaseHelper(context);
	}

	public boolean login(String username,String password,String userType){
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		String sql="select * from pro_user where username=? and password=? and userType=?";
		Cursor cursor=sdb.rawQuery(sql, new String[]{username,password,userType});
		Log.i("pro_user",username+"_"+password+"_"+userType);
		if(cursor.moveToFirst()==true){
			cursor.close();
			return true;
		}
		return false;
	}
	public boolean register(User user){
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		String sql="insert into pro_user(username,password,age,sex,userType) values(?,?,?,?,?)";
		Object obj[]={user.getUsername(),user.getPassword(),user.getAge(),user.getSex(),user.getUserType()};
		sdb.execSQL(sql, obj);	
		return true;
	}
}
