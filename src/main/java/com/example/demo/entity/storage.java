package com.example.demo.entity;

public class storage {
    public int storageid;
    public int num;
    public int itemid;

    public storage(int sorageid, int num, int itemid) {
        this.storageid = sorageid;
        this.num = num;
        this.itemid = itemid;
    }

    @Override
    public String toString() {
        return "storage{" +
                "storageid=" + storageid +
                ", num=" + num +
                ", itemid=" + itemid +
                '}';
    }

    public int getSorageid() {
        return storageid;
    }

    public void setSorageid(int sorageid) {
        this.storageid = sorageid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }
}
