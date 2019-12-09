package com.example.finalltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    RadioGroup identity;
    Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }
    private void findViews() {
        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        identity=(RadioGroup) findViewById(R.id.login_identity);
        login=(Button) findViewById(R.id.login);
        register=(Button) findViewById(R.id.register);
       login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name=username.getText().toString();
                String pass=password.getText().toString();
                String idenstr=((RadioButton)MainActivity.this.findViewById(identity.getCheckedRadioButtonId())).getText().toString();
                Log.i("TAG",name+"_"+pass+"_"+idenstr);
                UserService uService=new UserService(MainActivity.this);
                boolean flag=uService.login(name, pass,idenstr);
                if(flag){
                    Log.i("TAG","登录成功");
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                    if(idenstr.equals("负责人")) {
                        Intent intent = new Intent(MainActivity.this, managerActivtity.class);
                        intent.putExtra("username",name);
                        startActivityForResult(intent,1000);
                    }
                }else{
                    Log.i("TAG","登录失败");
                    Toast.makeText(MainActivity.this, "用户名或密码错误", Toast.LENGTH_LONG).show();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
