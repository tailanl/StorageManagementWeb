package com.example.demo.mapper;

import com.example.demo.entity.purchase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PurchaseMapper {
    public List<purchase> GetAllPurchase();
    public purchase GetPurchaseById(@Param("id") int id);
    public  List<purchase> GetPurchaseByState(@Param("state") String state);
    public  List<purchase> GetDonePurchase();
    public void AddNewPurchase(purchase purchase);
    public void updatePurchaseState(purchase purchase);
    public void updatePurchaseStateById(@Param("state") String state,@Param("id") int id);
    public void updatePurchaseNum(purchase purchase);
    public Integer GetMaxPurchaseId();
    public void AddPurchaseWithId(purchase purchase);
}
