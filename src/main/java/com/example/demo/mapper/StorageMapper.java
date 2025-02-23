package com.example.demo.mapper;

import com.example.demo.entity.item;
import com.example.demo.entity.storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface StorageMapper {
    public List<storage> GetAllStorage();

    public void addStorage(storage s);

    public void updateStorage(storage s);

    public storage GetStorageByItem(item i);

    public storage GetStorageByItemId(@Param("id") int itemid);

    public storage GetStorageById(@Param("id") int id);

    public void updateStorageNumByItemId(@Param("id") int id, @Param("num") int num);

    public void updateStorageByNumPlus(@Param("id") int id, @Param("num") int num);

    public void updateStorageByNumDel(@Param("id") int id, @Param("num") int num);
}
