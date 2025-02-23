package com.example.demo.service;

import com.example.demo.DTO.StorageChange;
import com.example.demo.entity.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StorageService {
    public List<item> GetAllItem();
    public List<storage> GetAllStorage();//tested
    public Integer GetInitProductionId();
    public Integer GetInitOrderId();
    public Integer GetInitPurchaseId();
    public boolean UpdatePurchaseState(purchase purchase ,String state);//tested
    public boolean AddNewPurchase(purchase purchase);//tested
    public boolean AddNewPurchaseWithId(purchase purchase);
    public boolean UpdateOrderState(order order, String state);//tested
    public boolean AddNewOrder(order order);//tested
    public boolean AddNewOrderWithId(order order);
    public boolean UpdateProductionState(production production, String state);//tested
    public boolean AddNewProduction(production production);//tested
    public boolean AddNewProductionWithId(production production);
    public List<StorageChange> StorageItemChange(Integer item);//tested
    public boolean UpdateProductionNum(production production,Integer costnum,Integer productNum);//tested
    public boolean UpdateOrderNum(order order, Integer ordernum);//tested
    public  boolean UpdatePurchaseNum(purchase purchase,Integer purchasenum);//tested
    public boolean HalfWay_Production(production production,Integer costnum,Integer productNum);
    public boolean HalfWay_Order(order order,Integer newnum);
    public boolean HalfWay_Purchase(purchase purchase,Integer newnum);
    public List<order> GetAllOrderByState(String state);
    public List<purchase> GetAllPurchaseByState(String state);
    public List<production> GetAllProductionByState(String state);
    public Integer GetOrderId();
    public Integer GetPurchaseId();
    public Integer GetProductionId();
    public boolean UpdateOrderListState(List<order>orders,String state);
    public boolean UpdateProductionListState(List<production>productions,String state);
    public boolean UpdatePurchaseListState(List<purchase>purchases,String state);
    public List<order> GetAllOrder();
}