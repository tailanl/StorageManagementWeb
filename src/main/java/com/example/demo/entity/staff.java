package com.example.demo.entity;

public class staff {
    public int staff;
    public String name;
    public String type;

    public int getStaff() {
        return staff;
    }

    public void setStaff(int staff) {
        this.staff = staff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public staff(int staff, String name, String type) {
        this.staff = staff;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "staff{" +
                "staff=" + staff +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
