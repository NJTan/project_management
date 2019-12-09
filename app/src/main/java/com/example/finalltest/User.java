package com.example.finalltest;



;

public class User {
	private int id;
	private String username;
	private String password;
	private int age;
	private String sex;
	private String userType;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, int age, String sex,String userType) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.userType=userType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public  void setUserType(String userType){this.userType=userType;}
	public  String getUserType(){return userType;}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", age=" + age + ", sex=" + sex + ",userType="+userType+"]";
	}
	
}
