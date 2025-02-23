package com.example.demo.DTO;

import com.example.demo.entity.purchase;

import java.util.List;

public class PurchaseRequest {
    public int staff;
    public List<purchase> data;

    public PurchaseRequest(int staff, List<purchase> data) {
        this.staff = staff;
        this.data = data;
    }

    public int getStaff() {
        return staff;
    }

    public void setStaff(int staff) {
        this.staff = staff;
    }

    public List<purchase> getData() {
        return data;
    }

    public void setData(List<purchase> data) {
        this.data = data;
    }
}
