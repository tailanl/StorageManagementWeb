package com.example.demo.service.impl;

import com.example.demo.entity.item;
import com.example.demo.entity.staff;
import com.example.demo.mapper.ItemMapper;
import com.example.demo.mapper.StaffMapper;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private StaffMapper staffMapper;
    @Override
    public List<item> GetAllItem() {
        return itemMapper.GetAllItem();
    }
    @Override
    public List<staff> GetAllStaff()
    {
        return staffMapper.GetAllStaff();
    }

}
