package com.example.finalltest;

public class Item {
    private int Ino;
    private int Inumber;
    private String Iname;
    private String start_plan_time,end_plan_time,record_time;
    public Item(){
        super();
    }
    public Item(int Inumber,String Iname,String start_plan_time,String end_plan_time,String record_time){
        super();
        this.Iname=Iname;
        this.Inumber=Inumber;
        this.start_plan_time=start_plan_time;
        this.end_plan_time=end_plan_time;
        this.record_time=record_time;
    }

    public int getInumber() {
        return Inumber;
    }
    public void setInumber(int inumber){
        this.Inumber=inumber;
    }
    public int getIno(){
        return Ino;
    }
    public void setIno(int ino){
           this.Ino=ino;
    }

    public String getIname(){
        return Iname;
    }
    public  void setIname(String iname){
        this.Iname=iname;
    }
    public String getStart_plan_time(){
        return start_plan_time;
    }
    public void setStart_plan_time(String start_plan_time){
        this.start_plan_time=start_plan_time;
    }
    public String getEnd_plan_time(){
        return end_plan_time;
    }
    public void setEnd_plan_time(String end_plan_time){
        this.end_plan_time=end_plan_time;

    }
    public String getRecord_time(){
        return record_time;
    }
    public void setRecord_time(String record_time){
        this.record_time=record_time;
    }
    @Override
    public String toString() {
        return "Item [ino=" + Ino + ", Iname=" + Iname + ", Inumber="
                + Inumber + ", start_plan_time=" + start_plan_time + ", end_plan_time=" + end_plan_time + ",record_time="+record_time+"]";
    }
}
