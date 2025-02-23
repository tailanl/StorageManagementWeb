package com.example.demo.DTO;

public class OrderShown {
    private int orderid;
    private String name;
    private String item;
    private int num;
    private String state;
    private int time;

    @Override
    public String toString() {
        return "ordertrans{" +
                "orderid=" + orderid +
                ", name='" + name + '\'' +
                ", item='" + item + '\'' +
                ", num=" + num +
                ", state='" + state + '\'' +
                ", time=" + time +
                '}';
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public OrderShown(int orderid, String name, String item, int num, String state, int time) {
        this.orderid = orderid;
        this.name = name;
        this.item = item;
        this.num = num;
        this.state = state;
        this.time = time;
    }
}
