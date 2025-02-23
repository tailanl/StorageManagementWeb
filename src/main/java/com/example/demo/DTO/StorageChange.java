package com.example.demo.DTO;

public class StorageChange {
    int time;
    String type;
    int num;
    int id;
    int staffid;


    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "StorageChange{" +
                "time=" + time +
                ", type='" + type + '\'' +
                ", num=" + num +
                ", id=" + id +
                ", staffid=" + staffid +
                '}';
    }

    public StorageChange(int time, String type, int num, int id, int staffid) {
        this.time = time;
        this.type = type;
        this.num = num;
        this.id = id;
        this.staffid = staffid;

    }

}
