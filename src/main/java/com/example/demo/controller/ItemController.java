package com.example.demo.controller;

import com.example.demo.DTO.StorageChange;
import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.service.BatchService;
import com.example.demo.service.ItemService;
import com.example.demo.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ItemController {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private StorageMapper storageMapper;
    @Autowired
    private ProductionMapper productionMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private BatchMapper batchMapper;
    @Autowired
    private PurchaseMapper purchaseMapper;
    @GetMapping("/test")
    Integer GetAllItem()
    {
        storage s = new storage(2,3,2);
        item i = new item(1,"a") ;
        //storageMapper.updateStorage(s);
        batch b = new batch(-1, 3, "order",-1,20250218);
        production production = new production(-1,1,1,2,1,"wait");
        purchase purchase = new purchase(-1,1,1,1,"wait");
        order order =new order(-1,1,2,2,"wait");
        purchaseMapper.AddNewPurchase(purchase);
        return  purchaseMapper.GetMaxPurchaseId();
    }

    @Autowired
    private StorageService storageService;
    @GetMapping("/test2")
    List<StorageChange> GetChange()
    {
        purchase purchase = purchaseMapper.GetPurchaseById(2);

        //System.out.println(purchase);
        //System.out.println(storageService.UpdatePurchaseNum(purchase,3));
        return storageService.StorageItemChange(1);
    }

    @Autowired
    private BatchService batchService;
    @GetMapping("/test3")
    List<batch> TestBatchService()
    {
        batchService.RefreshBatchByOrder();
        batchService.RefreshBatchByPurchase();
        batchService.RefreshBatchByProduction();
        return batchService.GetAllBatch();
    }
}
