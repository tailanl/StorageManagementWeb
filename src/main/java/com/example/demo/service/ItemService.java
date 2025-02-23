package com.example.demo.service;

import com.example.demo.entity.item;
import com.example.demo.entity.staff;
import com.example.demo.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface ItemService {
    public List<item> GetAllItem();
    public List<staff> GetAllStaff();
}
