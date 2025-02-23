package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    private PurchaseMapper purchaseMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProductionMapper productionMapper;
    @Autowired
    private BatchMapper batchMapper;
    @Autowired
    private StaffMapper staffMapper;
    private List<Integer> GetYearMonthDay() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // 月份从0开始，需要加1
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        List<Integer> res = Arrays.asList(year, month, day);
        return res;
    }

    private Integer GetTimeNum() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // 月份从0开始，需要加1
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        Integer res = year * 10000;
        res += month * 100;
        res += day;
        return res;
    }

    private HashSet<Integer> GetIdInBatchSetByType(String type) {
        HashSet<Integer> idset = new HashSet<>();
        List<batch> batches = batchMapper.GetBatchByType(type);
        for (batch b : batches) {
            idset.add(b.getId());
        }
        return idset;
    }

    public String AddBatchProudctionByStaffid(List<production> productions, Integer staffid) {
        try {
            HashSet<Integer> idset = GetIdInBatchSetByType("production");
            Integer time = GetTimeNum();
            batch temp = new batch(-1, -1, "production", staffid, time);
            for (production p : productions) {
                if (idset.contains(p.getProducitonid())) {
                    continue;
                }
                temp.setId(p.getProducitonid());
                batchMapper.AddNewBatch(temp);
            }
            return "Add_BatchProudction_Staffid_success";
        } catch (Exception e) {
            return "Add_BatchProudction_Staffid_fail";
        }
    }
    public String  AddBatchProdcutionByStaffName(List<production> productions, String name) {
        try {
            List<staff> staffList = staffMapper.GetAllStaff();
            int staffid = -1;
            for(staff s:staffList)
            {
                if(s.getName().equals(name))
                {
                    staffid = s.getStaff();
                }

            }
            if(staffid == -1)
            {
                return "staff_not_exist";
            }
            Integer time = GetTimeNum();
            batch temp = new batch(-1, -1, "production", staffid, time);
            HashSet<Integer> idset = GetIdInBatchSetByType("production");
            for (production p : productions) {
                if (idset.contains(p.getProducitonid())) {
                    continue;
                }
                temp.setId(p.getProducitonid());
                batchMapper.AddNewBatch(temp);
            }
            return "Add_BatchProudction_name_success";
        } catch (Exception e) {
            return "Add_BatchProudction_Name_fail";
        }
    }
    public String AddBatchPurchaseByStaffid(List<purchase> purchases, Integer staffid)
    {
        try {
            HashSet<Integer> idset = GetIdInBatchSetByType("purchase");
            Integer time = GetTimeNum();
            batch temp = new batch(-1, -1, "purchase", staffid, time);
            for (purchase p : purchases) {
                if (idset.contains(p.getPurchaseid())) {
                    continue;
                }
                temp.setId(p.getPurchaseid());
                batchMapper.AddNewBatch(temp);
            }
            return "Add_BatchPurchase_Staffid_success";
        } catch (Exception e) {
            return "Add_BatchPurchase_Staffid_fail";
        }
    };
    public String AddBatchPurchaseByStaffName(List<purchase> purchases, String name){
        try {
            List<staff> staffList = staffMapper.GetAllStaff();
            int staffid = -1;
            for(staff s:staffList)
            {
                if(s.getName().equals(name))
                {
                    staffid = s.getStaff();
                }

            }
            if(staffid == -1)
            {
                return "staff_not_exist";
            }
            Integer time = GetTimeNum();
            batch temp = new batch(-1, -1, "purchase", staffid, time);
            HashSet<Integer> idset = GetIdInBatchSetByType("purchase");
            for (purchase p : purchases) {
                if (idset.contains(p.getPurchaseid())) {
                    continue;
                }
                temp.setId(p.getPurchaseid());
                batchMapper.AddNewBatch(temp);
            }
            return "Add_BatchPurchase_StaffName_success";
        } catch (Exception e) {
            return "Add_BatchPurchase_StaffName_fail";
        }
    }
    public String AddBatchOrderByStaffid(List<order> orders , Integer staffid)
    {
        try {
            HashSet<Integer> idset = GetIdInBatchSetByType("order");
            Integer time = GetTimeNum();
            batch temp = new batch(-1, -1, "order", staffid, time);
            for (order p : orders) {
                if (idset.contains(p.getOrderid())) {
                    continue;
                }
                temp.setId(p.getOrderid());
                batchMapper.AddNewBatch(temp);
            }
            return "Add_BatchOrder_Staffid_success";
        } catch (Exception e) {
            return "Add_BatchOrder_Staffid_fail";
        }
    }
    public String AddBatchOrderByStaffName(List<order> orders ,String name) {
        try {
            List<staff> staffList = staffMapper.GetAllStaff();
            int staffid = -1;
            for (staff s : staffList) {
                if (s.getName().equals(name)) {
                    staffid = s.getStaff();
                }
            }
            if (staffid == -1) {
                return "staff_not_exist";
            }
            Integer time = GetTimeNum();
            batch temp = new batch(-1, -1, "order", staffid, time);
            HashSet<Integer> idset = GetIdInBatchSetByType("order");
            for (order p : orders) {
                if (idset.contains(p.getOrderid())) {
                    continue;
                }
                temp.setId(p.getOrderid());
                batchMapper.AddNewBatch(temp);
            }
            return "Add_BatchOrder_StaffName_success";
        } catch (Exception e) {
            return "Add_BatchOrder_StaffName_fail";
        }
    }
    public String AddNewStaff(String type,String name)
    {
        try{
            List<staff> staffList = staffMapper.GetAllStaff();
            for (staff s : staffList) {
                if (s.getName().equals(name)) {
                    return "staff_have_exist";
                }
            }
            staff s = new staff(-1,name,type);
            staffMapper.AddStaff(s);
            return "Add_staff_success";
        }
        catch (Exception e)
        {
            return "Add_staff_fail";
        }
    }
    public String RefreshBatchByProduction()
    {
        try {
            List<production> productions = productionMapper.GetAllProduction();
            HashSet<Integer> idset = GetIdInBatchSetByType("production");
            batch temp = new batch(-1, 1, "production", -1, GetTimeNum());
            for (production p : productions) {
                if (!idset.contains(p.getProducitonid())) {
                    temp.setId(p.getProducitonid());
                    batchMapper.AddNewBatch(temp);
                }
            }
            return "RefreshBatchByProduction";
        }
        catch (Exception e)
        {
            return "RefreshBatchByProduction_fail";
        }
    }
    public String RefreshBatchByOrder()
    {
        try {
            List<order> orders = orderMapper.GetAllOrder();
            HashSet<Integer> idset = GetIdInBatchSetByType("order");

            batch temp = new batch(-1, 1, "order", -1, GetTimeNum());
            for (order o : orders) {
                if (!idset.contains(o.getOrderid())) {
                    temp.setId(o.getOrderid());
                    try {
                        System.out.println();
                        batchMapper.AddNewBatch(temp);
                    }
                    catch (Exception e2)
                    {
                    }
                }
            }
            return "RefreshBatchByOrder";
        }
        catch (Exception e)
        {
            return "RefreshBatchByOrder_fail";
        }
    }
    public String RefreshBatchByPurchase()
    {
        try {
            List<purchase> purchases = purchaseMapper.GetAllPurchase();
            HashSet<Integer> idset = GetIdInBatchSetByType("purchase");
            batch temp = new batch(-1, 1, "purchase", -1, GetTimeNum());
            for (purchase p : purchases) {
                if (!idset.contains(p.getPurchaseid())) {
                    temp.setId(p.getPurchaseid());
                    batchMapper.AddNewBatch(temp);
                }
            }
            return "RefreshBatchByPurchase";
        }
        catch (Exception e)
        {
            return "RefreshBatchByPurchase_fail";
        }
    }
    public List<production> GetAllProductionByWorker(staff worker)
    {
        List<batch> batches = batchMapper.GetBatchByStaffType("production",worker.getStaff());
        List<production> res = new ArrayList<>();
        for(batch b:batches)
        {
            res.add(productionMapper.GetProductionById(b.getId()));
        }
        return res;
    }
    public List<order> GetAllOrderByConsumer(staff consumer)
    {
        List<batch> batches = batchMapper.GetBatchByStaffType("order",consumer.getStaff());
        List<order> res = new ArrayList<>();
        for(batch b:batches)
        {
            res.add(orderMapper.GetOrderById(b.getId()));
        }
        return res;
    }
    public List<purchase> GetAllPurchaseBySeller(staff seller)
    {
        List<batch> batches = batchMapper.GetBatchByStaffType("purchase",seller.getStaff());
        List<purchase> res = new ArrayList<>();
        for(batch b:batches)
        {
            res.add(purchaseMapper.GetPurchaseById(b.getId()));
        }
        return res;
    }
    public List<batch> GetAllBatch()
    {
        return batchMapper.GetAllBatch();
    }
    public List<staff> GetAllStaff()
    {
        return staffMapper.GetAllStaff();
    }
    public List<batch> GetBatchByType(String type){return batchMapper.GetBatchByType(type);}
}

