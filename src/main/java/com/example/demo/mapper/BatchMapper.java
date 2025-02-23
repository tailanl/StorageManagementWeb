package com.example.demo.mapper;

import com.example.demo.entity.batch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BatchMapper {
    public  List<batch> GetAllBatch();
    public List<batch> GetBatchByType(@Param("type") String type);
    public List<batch> GetBatchByStaffType(@Param("type") String type,@Param("staffid") int  staffid);
    public List<batch> GetBatchByStaff(@Param("staffid") int  staffid);
    public List<batch> GetAllProductionBatch();
    public List<batch> GetAllOrderBatch();
    public List<batch> GetAllPurchaseBatch();
    public void AddNewBatch(batch batch);
    public List<batch> GetBatctByTimeRangeTpye(int early,int later,String type);
    public List<batch> GetBatctByTimeRange(int early,int later,String type);
}
