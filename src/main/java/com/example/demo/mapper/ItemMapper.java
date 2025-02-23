package com.example.demo.mapper;

import com.example.demo.entity.item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ItemMapper {
    public List<item> GetAllItem();

}
