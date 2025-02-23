package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StorageHtmlController {
    @RequestMapping("/storage")
    public String ManageStorage()
    {
        return "ManageStorage.html";
    }
    @RequestMapping("/data/storageChange")
    public String StorageChange(@RequestParam(value = "itemid") int id){return  "StorageChange.html";}
    @RequestMapping("/")
    public String IndexHtml()
    {
        return "index.html";
    }
    @RequestMapping("/order")
    public String OrderManager()
    {
        return "OrderManager.html";
    }
}
