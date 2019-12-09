package com.example.finalltest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends Activity  {
	EditText username;
	EditText password;
	EditText age;
	RadioGroup sex,identity;
	Button register;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		findViews();
		register.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String name=username.getText().toString().trim();
				String pass=password.getText().toString().trim();
				String agestr=age.getText().toString().trim();
				String sexstr=((RadioButton)RegisterActivity.this.findViewById(sex.getCheckedRadioButtonId())).getText().toString();
				String idtenstr=((RadioButton)RegisterActivity.this.findViewById(identity.getCheckedRadioButtonId())).getText().toString();
				Log.i("TAG",name+"_"+pass+"_"+agestr+"_"+sexstr+"_"+idtenstr);
			   UserService uService=new UserService(RegisterActivity.this);
			   User user=new User();
    			user.setUsername(name);
    			user.setPassword(pass);
    			user.setAge(Integer.parseInt(agestr));
    			user.setSex(sexstr);
    			user.setUserType(idtenstr);
    			Log.i("user",user.getPassword()+user.getAge()+user.getUserType());
 				uService.register(user);
				Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
				RegisterActivity.this.finish();
			}
		});
	}
	private void findViews() {
		username=(EditText) findViewById(R.id.usernameRegister);
		password=(EditText) findViewById(R.id.passwordRegister);
		age=(EditText) findViewById(R.id.ageRegister);
		sex=(RadioGroup) findViewById(R.id.sexRegister);
		identity=(RadioGroup) findViewById(R.id.identity);
		register=(Button) findViewById(R.id.Register);
	}

}
