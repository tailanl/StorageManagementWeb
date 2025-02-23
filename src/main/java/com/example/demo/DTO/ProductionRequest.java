package com.example.demo.DTO;

import com.example.demo.entity.production;

import java.util.List;

public class ProductionRequest {
    public int staff;
    public List<production> data;

    public int getStaff() {
        return staff;
    }

    public void setStaff(int staff) {
        this.staff = staff;
    }

    public List<production> getData() {
        return data;
    }

    public void setData(List<production> data) {
        this.data = data;
    }

    public ProductionRequest(int staff, List<production> data) {
        this.staff = staff;
        this.data = data;
    }
}
