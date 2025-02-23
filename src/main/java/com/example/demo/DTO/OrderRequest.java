package com.example.demo.DTO;

import com.example.demo.entity.order;

import java.util.List;

public class OrderRequest {
    public Integer staff;     // 员工ID
    public List<order> data; // 订单项列表

    public Integer getStaff() {
        return staff;
    }

    public void setStaff(Integer staff) {
        this.staff = staff;
    }

    public List<order> getData() {
        return data;
    }

    public void setData(List<order> data) {
        this.data = data;
    }


    public OrderRequest(Integer staff,  List<order> data) {
        this.staff = staff;
        this.data = data;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "staff=" + staff +
                ", data=" + data +
                '}';
    }
}