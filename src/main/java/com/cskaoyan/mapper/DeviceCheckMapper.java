package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceCheck;
import com.cskaoyan.bean.DeviceCheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceCheckMapper {
    long countByExample(DeviceCheckExample example);

    long count_by_deviceCheckId(@Param("searchValue")String searchValue);

    long count_by_deviceName(@Param("searchValue")String searchValue);

    int deleteByExample(DeviceCheckExample example);

    int deleteByPrimaryKey(List<String> deviceCheckId);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    List<DeviceCheck> selectByExample(DeviceCheckExample example);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByExampleSelective(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByExample(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);

    List<DeviceCheck> selectPageOrder(@Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    List<DeviceCheck> selectPageOrder_by_deviceCheckId(@Param("searchValue")String searchValue, @Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    List<DeviceCheck> selectPageOrder_by_deviceName(@Param("searchValue")String searchValue, @Param("startIndex") int startIndex, @Param("endIndex") int endIndex);
}