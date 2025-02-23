package com.example.demo.entity;

public class purchase {
    public int purchaseid;
    public int itemid;
    public int num;
    public float price;
    public String state;

    public int getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(int purchaseid) {
        this.purchaseid = purchaseid;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "purchase{" +
                "purchaseid=" + purchaseid +
                ", itemid=" + itemid +
                ", num=" + num +
                ", price=" + price +
                ", state='" + state + '\'' +
                '}';
    }

    public purchase(int purchaseid, int itemid, int num, float price, String state) {
        this.purchaseid = purchaseid;
        this.itemid = itemid;
        this.num = num;
        this.price = price;
        this.state = state;
    }
}
