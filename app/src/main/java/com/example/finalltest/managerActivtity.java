package com.example.finalltest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class managerActivtity extends AppCompatActivity {
    private Button add_project_btn,delete_project_btn,modify_project_btn,search_project_btn;
    private String curusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_behavior);
        findView();
        Intent intent1 =getIntent();
        curusername=intent1.getStringExtra("username");
        Log.d("tag","当前用户"+curusername);
        add_project_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(managerActivtity.this,add_project_activity.class);
                intent.putExtra("username",curusername);
                startActivity(intent);
            }
        });
    }
    public void findView(){
        add_project_btn=(Button)findViewById(R.id.add_porject);
        delete_project_btn=(Button)findViewById(R.id.delect_project);
        modify_project_btn=(Button)findViewById(R.id.modify_project);
        search_project_btn=(Button)findViewById(R.id.search_project);
    }
}
