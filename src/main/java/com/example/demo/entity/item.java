package com.example.demo.entity;

public class item {
    public int itemid;
    public String name;

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public item(int itemid, String name) {
        this.itemid = itemid;
        this.name = name;
    }

    @Override
    public String toString() {
        return "item{" +
                "itemid=" + itemid +
                ", name='" + name + '\'' +
                '}';
    }
}
