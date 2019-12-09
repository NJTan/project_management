package com.example.finalltest;

public class Item_user {
    private String username ;
    private  int Ino;
    private  String beizu;
    public Item_user(){
        super();
    }
    public Item_user(String username,int Ino){
        super();
        this.username=username;
        this.Ino=Ino;
        this.beizu=beizu;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public int getIno(){
        return Ino;
    }
    public  void setIno(int Ino){
        this.Ino=Ino;
    }
    public String getBeizu(){
        return  beizu;
    }
    public void setBeizu(String beizu){
        this.beizu=beizu;
    }
    @Override
    public String toString(){
        return "Item_user [username=" + username + ", Ino="
                + Ino + "beizu="+beizu+"]";
    }
}
