package com.example.demo.service;

import com.example.demo.entity.*;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import java.util.HashSet;
import java.util.List;

@Repository
public interface BatchService {
    public String AddBatchProudctionByStaffid(List<production> productions, Integer staffid);
    public String AddBatchProdcutionByStaffName(List<production> productions, String name);
    public String AddBatchPurchaseByStaffid(List<purchase> purchases, Integer staffid);
    public String AddBatchPurchaseByStaffName(List<purchase> purchases, String name);
    public String AddBatchOrderByStaffid(List<order> orders ,Integer staffid);
    public String AddBatchOrderByStaffName(List<order> orders ,String name);
    public String AddNewStaff(String type,String name);//tested
    public String RefreshBatchByProduction();//tested
    public String RefreshBatchByOrder();//tested
    public String RefreshBatchByPurchase();//tested
    public List<production> GetAllProductionByWorker(staff worker);//tested
    public List<order> GetAllOrderByConsumer(staff consumer);//tested
    public List<purchase> GetAllPurchaseBySeller(staff seller);//tested
    public List<batch> GetAllBatch();//tested
    public List<staff> GetAllStaff();//tested
    public List<batch> GetBatchByType(String type);
}
