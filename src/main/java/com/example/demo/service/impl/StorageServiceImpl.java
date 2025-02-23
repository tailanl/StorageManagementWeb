package com.example.demo.service.impl;

import com.example.demo.DTO.StorageChange;
import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.Tuple;

import java.util.*;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageMapper storageMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private PurchaseMapper purchaseMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProductionMapper productionMapper;
    @Autowired
    private BatchMapper batchMapper;
    public List<item> GetAllItem()
    {
        return itemMapper.GetAllItem();
    }
    public List<storage> GetAllStorage()
    {
        return storageMapper.GetAllStorage();
    }
    public Integer GetInitProductionId(){
        return productionMapper.GetMaxProductionId();
    }
    public Integer GetInitOrderId()
    {
        return orderMapper.GetMaxOrderId();
    }
    public Integer GetInitPurchaseId()
    {
        return purchaseMapper.GetMaxPurchaseId();
    }
    public boolean UpdatePurchaseState(purchase purchase, String state) {
        try {
            if (purchase.state.equals(state)) {
                return true;
            }
            storage s = storageMapper.GetStorageByItemId(purchase.getItemid());
            if (state.equals("done")) {
                s.setNum(s.getNum() + purchase.getNum());
                storageMapper.updateStorage(s);
            } else {
                s.setNum(s.getNum() - purchase.getNum());
                storageMapper.updateStorage(s);
            }
            purchase.setState(state);
            purchaseMapper.updatePurchaseState(purchase);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean AddNewPurchase(purchase purchase) {
        try {
            if (purchase.getState().equals("done")) {
                storage s = storageMapper.GetStorageByItemId(purchase.itemid);
                s.num = s.getNum() + purchase.getNum();
                storageMapper.updateStorage(s);
            }
            purchaseMapper.AddNewPurchase(purchase);
            return true;
        }
        catch (Exception e)
        {
            return  false;
        }
    }
    public boolean AddNewPurchaseWithId(purchase purchase) {
        try {
            if (purchase.getState().equals("done")) {
                storage s = storageMapper.GetStorageByItemId(purchase.itemid);
                s.num = s.getNum() + purchase.getNum();
                storageMapper.updateStorage(s);
            }
            purchaseMapper.AddPurchaseWithId(purchase);
            return true;
        }
        catch (Exception e)
        {
            return  false;
        }
    }
    public boolean UpdateOrderState(order order, String state) {
        try {
            if (order.getState().equals(state)) {
                return true;
            }
            storage s = storageMapper.GetStorageByItemId(order.getItemid());
            if (state.equals("done")) {
                s.num = s.getNum() - order.getNum();
            } else {
                s.num = s.getNum() + order.getNum();
            }
            order.setState(state);
            storageMapper.updateStorage(s);
            orderMapper.updateOrderState(order);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean AddNewOrder(order order) {
        try {
            if (order.getState().equals("done")) {
                storage s = storageMapper.GetStorageByItemId(order.itemid);
                s.num = s.getNum() + order.getNum();
                storageMapper.updateStorage(s);
            }
            orderMapper.AddNewOrder(order);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean AddNewOrderWithId(order order) {
        try {
            if (order.getState().equals("done")) {
                storage s = storageMapper.GetStorageByItemId(order.itemid);
                s.num = s.getNum() + order.getNum();
                storageMapper.updateStorage(s);
            }
            orderMapper.AddOrderWithId(order);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean UpdateProductionState(production production, String state)
    {
        try {
            if (production.getState().equals(state)) {
                return true;
            }
            if(state.equals("done")) {
                storage s = storageMapper.GetStorageByItemId(production.getCostid());
                s.num = s.getNum() - production.getCostnum();
                storageMapper.updateStorage(s);

                s = storageMapper.GetStorageByItemId(production.getProduct());
                s.num = s.getNum() + production.getProductnum();
                storageMapper.updateStorage(s);
            }
            else {
                storage s = storageMapper.GetStorageByItemId(production.getCostid());
                s.num = s.getNum() + production.getCostnum();
                storageMapper.updateStorage(s);

                s = storageMapper.GetStorageByItemId(production.getProduct());
                s.num = s.getNum() - production.getProductnum();
                storageMapper.updateStorage(s);
            }
            production.setState(state);
            productionMapper.updateProductionState(production);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean AddNewProduction(production production) {
        try {
            if(production.getState().equals("done")) {
                storage s = storageMapper.GetStorageByItemId(production.getCostid());
                s.num = s.getNum() - production.getCostnum();
                System.out.println(s);
                storageMapper.updateStorage(s);

                s = storageMapper.GetStorageByItemId(production.getProduct());
                s.num = s.getNum() + production.getProductnum();
                storageMapper.updateStorage(s);

            }
            productionMapper.AddProduction(production);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public boolean AddNewProductionWithId(production production) {
        try {
            if(production.getState().equals("done")) {
                storage s = storageMapper.GetStorageByItemId(production.getCostid());
                s.num = s.getNum() - production.getCostnum();
                System.out.println(s);
                storageMapper.updateStorage(s);

                s = storageMapper.GetStorageByItemId(production.getProduct());
                s.num = s.getNum() + production.getProductnum();
                storageMapper.updateStorage(s);

            }
            productionMapper.AddProductionWithId(production);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public List<StorageChange> StorageItemChange(Integer itemid)
    {
        List<production> productions = productionMapper.GetAllProduction();
        List<purchase> purchases = purchaseMapper.GetAllPurchase();
        List<order> orders = orderMapper.GetAllOrder();
        List<batch> batches = batchMapper.GetAllBatch();

        List<StorageChange> res = new ArrayList<StorageChange>();
        Dictionary<Map<String,Integer>,batch> tempDict =new Hashtable<>();
        for(batch batch:batches)
        {
            tempDict.put(Map.of(batch.getType(), batch.getId()) , batch);
        }
        for(production p:productions)
        {
            if(p.getCostid()==itemid&& p.getState().equals("done"))
            {
                StorageChange temp = new StorageChange(1,"a",1,1,1);
                temp.setTime(tempDict.get(Map.of("production",p.getProducitonid())).getTime());
                temp.setType("production_cost");
                temp.setNum(-1*p.getCostnum());
                temp.setId(p.getProducitonid());
                temp.setStaffid(tempDict.get(Map.of("production",p.getProducitonid())).getStaffid());
                res.add(temp);
            }
            if(p.getProduct() == itemid && p.getState().equals("done"))
            {
                StorageChange temp = new StorageChange(1,"a",1,1,1);
                temp.setTime(tempDict.get(Map.of("production",p.getProducitonid())).getTime());
                temp.setType("production_product");
                temp.setNum(p.getProductnum());
                temp.setStaffid(tempDict.get(Map.of("production",p.getProducitonid())).getStaffid());
                res.add(temp);
            }
        }
        for(purchase p :purchases)
        {
            if(p.getItemid()==itemid && p.getState().equals("done"))
            {
                StorageChange temp = new StorageChange(1,"a",1,1,1);
                temp.setTime(tempDict.get(Map.of("purchase",p.getPurchaseid())).getTime());
                temp.setType("purchase");
                temp.setNum(p.getNum());
                temp.setId(p.getPurchaseid());
                temp.setStaffid(tempDict.get(Map.of("purchase",p.getPurchaseid())).getStaffid());
                res.add(temp);
            }
        }
        for(order o:orders)
        {
            if(o.getItemid() == itemid && o.getState().equals("wait"))
            {
                StorageChange temp = new StorageChange(1,"a",1,1,1);
                temp.setTime(tempDict.get(Map.of("order",o.getOrderid())).getTime());
                temp.setType("order");
                temp.setNum(o.getNum());
                temp.setId(o.getOrderid());
                temp.setStaffid(tempDict.get(Map.of("order",o.getOrderid())).getStaffid());
                res.add(temp);
            }
        }
        return res;
    }
    public boolean UpdateProductionNum(production production,Integer costnum,Integer productNum)
    {
        try{
            if(production.getState().equals("done")) {
                storageMapper.updateStorageByNumDel(production.getCostid(), costnum - production.getCostnum());
                storageMapper.updateStorageByNumPlus(production.getProduct(), productNum - production.getProductnum());
            }
            production.setCostnum(costnum);
            production.setProductnum(productNum);
            productionMapper.updateProductionNum(production);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    };
    public boolean UpdateOrderNum(order order, Integer ordernum)
    {
        try{
            if(order.getState().equals("done")) {
                storageMapper.updateStorageByNumDel(order.getItemid(),ordernum - order.getNum());
            }
            order.setNum(ordernum);
            orderMapper.updateOrderNum(order);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    };
    public  boolean UpdatePurchaseNum(purchase purchase,Integer purchasenum)
    {
        try{
            if(purchase.getState().equals("done")) {
                storageMapper.updateStorageByNumPlus(purchase.getItemid(),purchasenum - purchase.getNum());
            }
            purchase.setNum(purchasenum);
            purchaseMapper.updatePurchaseNum(purchase);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public boolean HalfWay_Production(production production,Integer newcostnum,Integer newproductNum)
    {
        try
        {
            if(production.getProductnum()> newproductNum && production.getCostnum() > newcostnum &&production.getState().equals("wait"))
            {
                production p = new production(GetProductionId(),production.getCostid(),
                        production.getCostnum()- newcostnum,production.getProduct(),
                        production.getProductnum()-newproductNum,"wait" );
                UpdateProductionNum(production,newcostnum, newproductNum);
                AddNewProductionWithId(production);
                return true;
            }
            return false;
        }
        catch (Exception e)
        {
            return  false;
        }
    }
    public boolean HalfWay_Order(order order,Integer newnum)
    {
        try{
            if(order.getNum()>newnum && order.getState().equals("wait")) {
                order neworder = new order(GetOrderId(), order.getItemid(), order.getNum() - newnum, order.getPrice(), "wait");
                UpdateOrderNum(order,newnum);
                AddNewOrderWithId(order);
                return true;
            }
            return false;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public boolean HalfWay_Purchase(purchase purchase,Integer newnum)
    {
        try{
            if(purchase.getNum()>newnum && purchase.getState().equals("wait")) {
                purchase neworder = new purchase(GetPurchaseId(), purchase.getItemid(), purchase.getNum() - newnum, purchase.getPrice(), "wait");
                UpdatePurchaseNum(purchase,newnum);
                AddNewPurchaseWithId(purchase);
                return true;
            }
            return false;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public Integer GetOrderId()
    {
        return orderMapper.GetMaxOrderId()+1;
    }
    public Integer GetPurchaseId()
    {
        return purchaseMapper.GetMaxPurchaseId()+1;
    }
    public Integer GetProductionId()
    {
        return productionMapper.GetMaxProductionId()+1;
    }
    public List<order> GetAllOrderByState(String state)
    {

        return orderMapper.GetOrderByState(state);
    }
    public List<purchase> GetAllPurchaseByState(String state)
    {

        return purchaseMapper.GetPurchaseByState(state);
    }
    public List<production> GetAllProductionByState(String state)
    {
        return  productionMapper.GetProductionByState(state);
    }
    public boolean UpdateOrderListState(List<order>orders,String state)
    {
        try {
            for (order o : orders) {
                o.setState(state);
                orderMapper.updateOrderState(o);
            }
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public boolean UpdateProductionListState(List<production>productions,String state)
    {
        try {
            for (production p : productions) {
                p.setState(state);
                productionMapper.updateProductionState(p);
            }
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public boolean UpdatePurchaseListState(List<purchase>purchases,String state)
    {
        try {
            for (purchase p : purchases) {
                p.setState(state);
                purchaseMapper.updatePurchaseState(p);
            }
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public List<order> GetAllOrder(){
        return orderMapper.GetAllOrder();
    }
}
