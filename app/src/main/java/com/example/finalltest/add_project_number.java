package com.example.finalltest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class add_project_number extends FragmentActivity {
    private int pro_mem_number;
    private  String[] tilte;
    private  String[][] contents;
    private String[] Membernames;
    public String[] getTilte() {
        return tilte;
    }
    public String[][] getContents(){return contents;}
    public  int getPro_mem_number(){
     return  pro_mem_number;
   }
    public void setMembernames(String name){
            for(int i=0;i<pro_mem_number;i++){
               this.Membernames[i]=name;
            }
    }
    public String[] getMembernames(){
        return  Membernames;
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_project_number);
        Intent intent =getIntent();
        Bundle bundle= intent.getExtras();
        String project_members=bundle.getString("project_numbers");
//        add_project_number.this.setTitle("项目人数"+project_members);
        Log.d("tag1",project_members);
        //设置列表的标题
        pro_mem_number=Integer.parseInt(project_members);
//        Log.d("tag2","项目人数"+pro_mem_number);
        tilte=new String[pro_mem_number];
        contents =new String[pro_mem_number][pro_mem_number];

        for(int i=0;i<pro_mem_number;i++){
            tilte[i]="成员"+i;
        Log.d("tilte","title[i]"+tilte[i]);

        }
        for(int i=0;i<pro_mem_number;i++){
                contents[i][0]="成员"+i;
                contents[i][1]="输入成员"+i+"的信息";
        }
        for(int i=0;i<pro_mem_number-1;i++){
            for(int j=0;j<2;j++){
                Log.d("contents","content[i]"+contents[i][j]);
            }
        }
        setNumberFragment numberFragment=new setNumberFragment();
        setContent_fragement contentFragment=new setContent_fragement();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.setNember,numberFragment);
        transaction.replace(R.id.setInputMember, contentFragment);
        transaction.commit();
    }

}
