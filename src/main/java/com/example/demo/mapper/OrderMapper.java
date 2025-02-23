package com.example.demo.mapper;

import com.example.demo.entity.order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    public List<order> GetAllOrder();
    public order GetOrderById(@Param("id") int id);
    public  List<order> GetOrderByState(@Param("state") String state);
    public  List<order> GetDoneOrder();
    public void AddNewOrder(order order);
    public void updateOrderState(order order);
    public void updateOrderStateById(@Param("state") String state,@Param("id") int id);
    public void updateOrderNum(order order);
    public Integer GetMaxOrderId();
    public void AddOrderWithId(order order);
}
