package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.bean.DeviceFaultExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceFaultMapper {
    long countByExample(DeviceFaultExample example);

    long count_by_deviceFaultId(@Param("searchValue")String searchValue);

    long count_by_deviceName(@Param("searchValue")String searchValue);

    int deleteByExample(DeviceFaultExample example);

    int deleteByPrimaryKey(List<String> deviceFaultId);

    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    List<DeviceFault> selectByExample(DeviceFaultExample example);

    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByExampleSelective(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByExample(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByPrimaryKeySelective(DeviceFault record);

    int updateByPrimaryKey(DeviceFault record);

    List<DeviceFault> selectPageOrder(@Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    List<DeviceFault> selectPageOrder_by_deviceFaultId(@Param("searchValue")String searchValue, @Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    List<DeviceFault> selectPageOrder_by_deviceName(@Param("searchValue")String searchValue, @Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

}