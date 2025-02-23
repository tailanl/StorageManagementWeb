package com.example.demo.mapper;

import com.example.demo.entity.staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StaffMapper {
    public List<staff> GetAllStaff();
    public List<staff> GetStaffByType(@Param("type") String type);
    public List<staff> GetStaffByName(@Param("name") String name);
    public staff GetStaffById(@Param("id") int id);
    public void AddStaff(staff staff);

}
