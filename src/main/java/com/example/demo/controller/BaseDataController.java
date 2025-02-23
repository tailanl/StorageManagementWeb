package com.example.demo.controller;

import com.example.demo.entity.item;
import com.example.demo.entity.staff;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseDataController {
    @Autowired
    private ItemService itemService;
    @GetMapping("/data/staff")
    List<staff> GetStaffData(){
        return itemService.GetAllStaff();
    }
    @GetMapping("/data/item")
    List<item> GetItemData()
    {
        return  itemService.GetAllItem();
    }
}
