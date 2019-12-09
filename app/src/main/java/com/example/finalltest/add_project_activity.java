package com.example.finalltest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class add_project_activity extends AppCompatActivity implements View.OnClickListener {
  private Button plan_record_date,plan_begin_date,plan_end_date;
  private EditText pro_name,pro_detail,pro_number;
  private TextView text_record,text_beigin,text_end;
  private  String project_members_number;
  private String curusername;
  private  Button summit_btn;
  private String Membernames[];
  Intent intent2;
  private  int item_id;
  private DatabaseHelper dbHelper;
//  public add_project_activity(Context context){
//      new DatabaseHelper(context);
//  }
  private String record_time,start_plan_time,end_plan_time,time;
  Calendar calendar=Calendar.getInstance(Locale.CANADA);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_project);
        dbHelper=new DatabaseHelper(add_project_activity.this);
        init();
        Intent intent1 =getIntent();
        curusername=intent1.getStringExtra("username");
//       Log.d("tag","当前用户"+curusername);
    }
   public void  init(){
        text_record=(TextView) findViewById(R.id.record_date);
        text_beigin=(TextView) findViewById(R.id.txt_beginDate);
        text_end=(TextView) findViewById(R.id.txt_endDate);
        plan_record_date=(Button)findViewById(R.id.btn_record);
        plan_begin_date=(Button)findViewById(R.id.btn_beginTime);
        plan_end_date=(Button)findViewById(R.id.btn_endTime);
        plan_record_date.setOnClickListener(this);
        plan_begin_date.setOnClickListener(this);
        plan_end_date.setOnClickListener(this);
        pro_name=(EditText)findViewById(R.id.pro_name);
        pro_detail=(EditText)findViewById(R.id.prodetail);
        pro_number=(EditText)findViewById(R.id.proNumber);
        pro_number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("tag", "afterTextChanged 被执行---->" + s);
                project_members_number=s.toString();
                Log.d("项目人数：","项目的人数为"+ project_members_number);
//                pro_number.setFocusableInTouchMode(false);
//                pro_number.clearFocus();
                intent2 =new Intent(add_project_activity.this,add_project_number.class);
                intent2.putExtra("project_numbers",project_members_number);
                startActivityForResult(intent2,1000);
//                pro_number.setFocusableInTouchMode(true);
//                }
            }


        });

        summit_btn=(Button)findViewById(R.id.add_project_form);
        summit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName=pro_name.getText().toString().trim();
                String itemDescription=pro_detail.getText().toString().trim();
                String itemNumber=pro_number.getText().toString().trim();
/**
 *  测试返回的成员是否正确
 */
//                for(int i=0;i<Integer.parseInt(itemNumber);i++){
//                    Log.i("Tad_add",Membernames[i]);
//                }
                Log.d("Tag_add_project",itemName+"_"+itemDescription+"_"+itemNumber+"_"+start_plan_time+"_"+end_plan_time+"_"+record_time);
                /**
                 * 将项目基本信息的数据存放在project数据库的item表
                 */
               itemService iService=new itemService(add_project_activity.this);
                Item item=new Item();
                item.setIname(itemName);
                item.setInumber(Integer.parseInt(itemNumber));
                item.setStart_plan_time(start_plan_time);
                item.setEnd_plan_time(end_plan_time);
                item.setRecord_time(record_time);
//                Intent intent2=getIntent();

                Log.i("item",item.getIname()+item.getInumber()+item.getStart_plan_time()+item.getRecord_time());
                iService.InputItem(item);
                Toast.makeText(add_project_activity.this,"项目基本信息添加完毕",Toast.LENGTH_SHORT).show();
                /**
                 * 查询该项目的id号，然后将id号的数据存放在item_use和item_detail中
                 */
                SQLiteDatabase sdb=dbHelper.getReadableDatabase();
                String sql="select ino from item where Iname=? ";
                Cursor cursor=sdb.rawQuery(sql, new String[]{itemName});
               if(cursor.moveToFirst()){
                   item_id=cursor.getInt(cursor.getColumnIndex("ino"));
               }
                /**
                 * 将数据存放在item_user中
                 */
                Log.i("item_id", String.valueOf(item_id));
                item_userService i_uService=new item_userService(add_project_activity.this);
                for(int i=0;i<Integer.parseInt(itemNumber);i++){
                    Item_user item_user=new Item_user();
                    item_user.setIno(item_id);
                    item_user.setUsername(Membernames[i]);
                    i_uService.Inputitem_userService(item_user);
                }
                /**
                 * 将数据存放在item_detail中
                 */
                item_detailService i_dService=new item_detailService(add_project_activity.this);
                Item_detail item_detail=new Item_detail();
                item_detail.setIno(item_id);
                item_detail.setDescription(itemDescription);
                i_dService.saveItem_detail(item_detail);
            }
        });
     }
    public void showDatePickerDialog1(Activity activity, int themeResId, final TextView tv, Calendar calendar) {
        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        new DatePickerDialog(activity, themeResId, new DatePickerDialog.OnDateSetListener() {
            // 绑定监听器(How the parent is notified that the date is set.)
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 此处得到选择的时间，可以进行你想要的操作
//             tv.setText("您选择了：" + year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日");
                final String data = year+"-" +(monthOfYear+1) + "-" + dayOfMonth ;
                tv.setText(data);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ",Locale.getDefault());
                String d = df.format(new Date(year-1900,monthOfYear,dayOfMonth));
                record_time=d;
                Log.d("tag",record_time);
            }
        }
                // 设置初始日期
                , calendar.get(Calendar.YEAR)
                , 1
                ,1).show();
    }
    public void showDatePickerDialog2(Activity activity, int themeResId, final TextView tv, Calendar calendar) {
        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        new DatePickerDialog(activity, themeResId, new DatePickerDialog.OnDateSetListener() {
            // 绑定监听器(How the parent is notified that the date is set.)
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 此处得到选择的时间，可以进行你想要的操作
//             tv.setText("您选择了：" + year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日");
                final String data = year+"-" +(monthOfYear+1) + "-" + dayOfMonth ;
                tv.setText(data);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ",Locale.getDefault());
                String d = df.format(new Date(year-1900,monthOfYear,dayOfMonth));
                start_plan_time=d;
            }
        }
                // 设置初始日期
                , calendar.get(Calendar.YEAR)
                , 1
                ,1).show();
    }
    public void showDatePickerDialog3(Activity activity, int themeResId, final TextView tv, Calendar calendar) {
        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        new DatePickerDialog(activity, themeResId, new DatePickerDialog.OnDateSetListener() {
            // 绑定监听器(How the parent is notified that the date is set.)
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 此处得到选择的时间，可以进行你想要的操作
//             tv.setText("您选择了：" + year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日");
                final String data = year+"-" +(monthOfYear+1) + "-" + dayOfMonth ;
                tv.setText(data);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ",Locale.getDefault());
                String d = df.format(new Date(year-1900,monthOfYear,dayOfMonth));
               end_plan_time=d;
            }
        }
                // 设置初始日期
                , calendar.get(Calendar.YEAR)
                , 1
                ,1).show();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_record:
                showDatePickerDialog1(this,  2, text_record, calendar);
                break;
            case R.id.btn_beginTime:
                showDatePickerDialog2(this,  2,text_beigin, calendar);;
                break;
            case R.id.btn_endTime:
                showDatePickerDialog3(this,  2,text_end, calendar);
                break;
            default:
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1000 && resultCode==RESULT_OK) {

//            String text = null;
            if (data != null) {
//                Log.d("text", text);
                Membernames =data.getStringArrayExtra("nameList");
//                Log.i("nameList", Membernames[0]);
//                int nameListLen = Membernames.length;
//                for (int i = 0; i < nameListLen; i++) {
//                    Log.i("nameList", Membernames[i]);
//                }
//            editText.setText(text);
            }
        }
    }
}
