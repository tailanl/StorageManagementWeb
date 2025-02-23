package com.example.demo.DTO;

import com.example.demo.entity.production;

public class ProductionChange {
    private production Preproduction;
    private String ChangeState;
    private int ChangeCostNum;
    private int ChageProductNum;

    public production getPreproduction() {
        return Preproduction;
    }

    public void setPreproduction(production preproduction) {
        Preproduction = preproduction;
    }

    public String getChangeState() {
        return ChangeState;
    }

    public void setChangeState(String changeState) {
        ChangeState = changeState;
    }

    public int getChangeCostNum() {
        return ChangeCostNum;
    }

    public void setChangeCostNum(int changeCostNum) {
        ChangeCostNum = changeCostNum;
    }

    public int getChageProductNum() {
        return ChageProductNum;
    }

    public void setChageProductNum(int chageProductNum) {
        ChageProductNum = chageProductNum;
    }

    public ProductionChange(production preproduction, String changeState, int changeCostNum, int chageProductNum) {
        Preproduction = preproduction;
        ChangeState = changeState;
        ChangeCostNum = changeCostNum;
        ChageProductNum = chageProductNum;
    }
}
