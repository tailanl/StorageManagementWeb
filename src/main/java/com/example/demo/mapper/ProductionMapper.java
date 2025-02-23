package com.example.demo.mapper;

import com.example.demo.entity.production;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ProductionMapper {
    public List<production> GetAllProduction();

    public void AddProduction(production newproduction);

    public void updateProductionState(production production);

    public production GetProductionById(@Param("id") int id);

    public List<production> GetProductionByState(@Param("state") String state);

    public void updateProductionNum(production production);
    public Integer GetMaxProductionId();
    public  void AddProductionWithId(production production);
}
