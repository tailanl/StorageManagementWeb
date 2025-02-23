package com.example.demo.controller;

import com.example.demo.DTO.*;
import com.example.demo.entity.*;
import com.example.demo.service.BatchService;
import com.example.demo.service.ItemService;
import com.example.demo.service.StorageService;
import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;
    @Autowired
    private BatchService batchService;
    @GetMapping("/data/storage")
    List<storage> GetAllStorage(){
        return storageService.GetAllStorage();
    }
    @GetMapping("/data/storageChange/{item}")
    List<StorageChange> GetStorageChange(@PathVariable(value = "item") int item){
        return storageService.StorageItemChange(item);
    }
    @GetMapping("/data/order")
    List<order> GetOrderData()
    {
        return storageService.GetAllOrder();
    }
    @GetMapping("/data/batch/{type}")
    List<batch> GetAllBatchByType(@PathVariable(value = "type") String type)
    {
        return batchService.GetBatchByType(type);
    }
    public class Staff_orderarray{
        private String staff;
        private List<order> data;
    }
    private Queue<OrderRequest> OrderRequestQueue=new LinkedList<>();//实现不同AddNewOrder之间的并发
    private Queue<PurchaseRequest> PurchaseRequestQueue = new LinkedList<>();
    private Queue<ProductionRequest> ProductionRequestQueue = new LinkedList<>();
    private boolean OrderKey = false;
    private boolean PurchaseKey = false;
    private boolean ProductionKey = false;
    @PostMapping("/data/addOrder")
    void AddNewOrder(@RequestBody OrderRequest orderRequest)
    {
        OrderRequestQueue.offer(orderRequest);
        if(!OrderKey){
            OrderKey = true;
            AddOrderRequest();
        }
    }
    private void AddOrderRequest()
    {
        OrderRequest temp =new OrderRequest(1,new ArrayList<>());
        List<order> neworders = new ArrayList<>();
        while(!OrderRequestQueue.isEmpty())
        {
            temp = OrderRequestQueue.poll();
            for(order o : temp.getData()) {
                o.setOrderid(storageService.GetOrderId());
                storageService.AddNewOrderWithId(o);
            }
            neworders = temp.getData();
            System.out.println(neworders);
            batchService.AddBatchOrderByStaffid(neworders, temp.getStaff());
        }
        OrderKey = false;
    }
    @PostMapping("/data/addPurchase")
    void AddNewPurchase(@RequestBody PurchaseRequest purchaseRequest)
    {
        PurchaseRequestQueue.offer(purchaseRequest);
        System.out.println(PurchaseRequestQueue);
        if(!PurchaseKey){
            PurchaseKey = true;
            AddPurchaseRequest();
        }
    }
    private void AddPurchaseRequest()
    {
        PurchaseRequest temp =new PurchaseRequest(1,new ArrayList<>());
        List<purchase> newpurchases = new ArrayList<>();
        while(!PurchaseRequestQueue.isEmpty())
        {
            temp = PurchaseRequestQueue.poll();
            for(purchase p : temp.getData()) {
               storageService.AddNewPurchaseWithId(p);
            }
            batchService.AddBatchPurchaseByStaffid(newpurchases, temp.getStaff());
        }
        OrderKey = false;
    }
    @PostMapping("/data/addProduction")
    void AddNewProduction(@RequestBody ProductionRequest productionRequest)
    {
        ProductionRequestQueue.offer(productionRequest);
        if(!ProductionKey){
            ProductionKey = true;
            AddProductionRequest();
        }
    }
    private void AddProductionRequest()
    {
        ProductionRequest temp =new ProductionRequest(1,new ArrayList<>());
        List<production> newprodctions = new ArrayList<>();
        while(!PurchaseRequestQueue.isEmpty())
        {
            temp = ProductionRequestQueue.poll();
            for(production p : temp.getData()) {
                storageService.AddNewProductionWithId(p);
            }
            batchService.AddBatchProudctionByStaffid(newprodctions, temp.getStaff());
        }
        OrderKey = false;
    }
    @PostMapping("/data/updateOrderState")
    void UpdateOrderState(@RequestBody OrderChange orderChange)
    {
        storageService.UpdateOrderState(orderChange.getPreOrder(),orderChange.getChangeState());
    }
    @PostMapping("/data/updateOrderNum")
    void UpdateOrderNum(@RequestBody OrderChange orderChange)
    {
        storageService.UpdateOrderNum(orderChange.getPreOrder(),orderChange.getChangeNum());
    }
    @PostMapping("/data/UpdatePurchaseState")
    void UpdatePurchaseState(@RequestBody PurchaseChange purchaseChange)
    {
        storageService.UpdatePurchaseState(purchaseChange.getPrepurchase(), purchaseChange.getChangeState());
    }
    @PostMapping("/data/UpdatePurchaseNum")
    void UpdatePurchaseNum(@RequestBody PurchaseChange purchaseChange)
    {
        storageService.UpdatePurchaseNum(purchaseChange.getPrepurchase(),purchaseChange.getChangeNum());
    }
    @PostMapping("/data/UpdateProductionState")
    void UpdateProductionState(@RequestBody ProductionChange productionChange)
    {
        storageService.UpdateProductionState(productionChange.getPreproduction(), productionChange.getChangeState());
    }
    @PostMapping("/data/UpdateProductionNum")
    void  UpdateProductionNum(@RequestBody ProductionChange productionChange)
    {
        storageService.UpdateProductionNum(productionChange.getPreproduction(), productionChange.getChangeCostNum(), productionChange.getChageProductNum());
    }

}
