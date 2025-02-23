package com.example.demo.entity;

public class order {
    public int orderid;
    public int itemid;
    public int num;
    public float price;

    public String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "order{" +
                "orderid=" + orderid +
                ", itemid=" + itemid +
                ", num=" + num +
                ", price=" + price +
                ", state='" + state + '\'' +
                '}';
    }

    public order(int orderid, int itemid, int num, float price, String state) {
        this.orderid = orderid;
        this.itemid = itemid;
        this.num = num;
        this.state = state;
        this.price = price;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
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
}
