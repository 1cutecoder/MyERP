package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.bean.DeviceTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceTypeMapper {
    long countByExample(DeviceTypeExample example);

    long count_by_deviceTypeId(@Param("searchValue")String searchValue);

    long count_by_deviceTypeName(@Param("searchValue")String searchValue);

    int deleteByExample(DeviceTypeExample example);

    int deleteByPrimaryKey(List<String>  deviceId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    List<DeviceType> selectByExample(DeviceTypeExample example);

    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByExampleSelective(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByExample(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);

    List<DeviceType> selectPageOrder(@Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    List<DeviceType> selectPageOrder_by_deviceTypeId(@Param("searchValue")String searchValue, @Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    List<DeviceType> selectPageOrder_by_deviceTypeName(@Param("searchValue")String searchValue, @Param("startIndex") int startIndex, @Param("endIndex") int endIndex);
}