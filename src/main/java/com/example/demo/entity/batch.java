package com.example.demo.entity;
public class batch {
    public int batchid;
    public int id;
    public String type;
    public int staffid;
    public int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getBatchid() {
        return batchid;
    }

    public void setBatchid(int batchid) {
        this.batchid = batchid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public batch(int batchid, int id, String type, int staffid, int time) {
        this.batchid = batchid;
        this.id = id;
        this.type = type;
        this.staffid = staffid;
        this.time = time;
    }

    @Override
    public String toString() {
        return "batch{" +
                "batchid=" + batchid +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", staffid=" + staffid +
                ", time=" + time +
                '}';
    }
}
