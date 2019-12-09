package com.example.finalltest;

public class Item_detail {
    private int Ino;
    private String description;
    private String start_real_time;
    private String end_real_time ;
    private int Istate;//0表示未开始，1表示进行中，2表示已结束
    public Item_detail(){
        super();
    }
    public Item_detail(int Ino,String description){
       super();
        this.Ino=Ino;
        this.description=description;
    }
    public int getIno(){
        return Ino;
    }
    public String getDescription(){
        return  description;
    }
    public  String getStart_real_time(){
        return  start_real_time;
    }
    public  String getEnd_real_time(){
        return  end_real_time;
    }
    public int getIstate(){
        return Istate;
    }
    public void setIno(int ino){
        this.Ino=ino;
    }
    public  void setDescription(String description){
        this.description=description;
    }
    public void setStart_real_time(String start_real_time){
        this.start_real_time=start_real_time;
    }
    public void setEnd_real_time(String end_real_time){
        this.end_real_time=end_real_time;
    }
    public  void setIstate(int istate){
        this.Istate=istate;
    }
    @Override
    public String toString(){
        return "Item_detail [ino=" + Ino + ", Istate=" + Istate + ", description="
                + description + ", start_real_time=" + start_real_time + ", end_real_time=" + end_real_time + "]";
    }
}
