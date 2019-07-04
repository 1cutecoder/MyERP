package com.cskaoyan.mapper;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.DeviceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceMapper {
    long countByExample(DeviceExample example);

    long count_by_deviceId(@Param("searchValue")String searchValue);

    long count_by_deviceName(@Param("searchValue")String searchValue);

    long count_by_deviceTypeName(@Param("searchValue")String searchValue);

    int deleteByExample(DeviceExample example);

    int deleteByPrimaryKey(List<String>  deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    List<Device> selectByExample(DeviceExample example);

    Device selectByPrimaryKey(String deviceId);

    int updateByExampleSelective(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByExample(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

    List<Device> selectPageOrder(@Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    List<Device> selectPageOrder_by_deviceId(@Param("searchValue")String searchValue,@Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    List<Device> selectPageOrder_by_deviceName(@Param("searchValue")String searchValue,@Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    List<Device> selectPageOrder_by_deviceTypeName(@Param("searchValue")String searchValue,@Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

}