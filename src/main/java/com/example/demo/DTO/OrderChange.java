package com.example.demo.DTO;

import com.example.demo.entity.order;

public class OrderChange {
    private order preOrder;
    private int ChangeNum;
    private String ChangeState;

    public order getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(order preOrder) {
        this.preOrder = preOrder;
    }

    public int getChangeNum() {
        return ChangeNum;
    }

    public void setChangeNum(int changeNum) {
        ChangeNum = changeNum;
    }

    public String getChangeState() {
        return ChangeState;
    }

    public void setChangeState(String changeState) {
        ChangeState = changeState;
    }

    public OrderChange(order preOrder, int changeNum, String changeState) {
        this.preOrder = preOrder;
        ChangeNum = changeNum;
        ChangeState = changeState;
    }
}
