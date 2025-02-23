package com.example.demo.entity;

public class production {
    public int producitonid;
    public int costid;
    public int costnum;
    public int product;
    public int productnum;
    public String state;

    public int getProducitonid() {
        return producitonid;
    }

    public void setProducitonid(int producitonid) {
        this.producitonid = producitonid;
    }

    public int getCostid() {
        return costid;
    }

    public void setCostid(int costid) {
        this.costid = costid;
    }

    public int getCostnum() {
        return costnum;
    }

    public void setCostnum(int costnum) {
        this.costnum = costnum;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getProductnum() {
        return productnum;
    }

    public void setProductnum(int productnum) {
        this.productnum = productnum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "production{" +
                "producitonid=" + producitonid +
                ", costid=" + costid +
                ", costnum=" + costnum +
                ", product=" + product +
                ", productnum=" + productnum +
                ", state='" + state + '\'' +
                '}';
    }

    public production(int producitonid, int costid, int costnum, int product, int productnum, String state) {
        this.producitonid = producitonid;
        this.costid = costid;
        this.costnum = costnum;
        this.product = product;
        this.productnum = productnum;
        this.state = state;
    }
}
