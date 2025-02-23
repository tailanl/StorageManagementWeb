package com.example.demo.DTO;

import com.example.demo.entity.purchase;

public class PurchaseChange {
    private purchase Prepurchase;
    private int ChangeNum;
    private String ChangeState;

    public purchase getPrepurchase() {
        return Prepurchase;
    }

    public void setPrepurchase(purchase prepurchase) {
        Prepurchase = prepurchase;
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

    public PurchaseChange(purchase prepurchase, int changeNum, String changeState) {
        Prepurchase = prepurchase;
        ChangeNum = changeNum;
        ChangeState = changeState;
    }
}
