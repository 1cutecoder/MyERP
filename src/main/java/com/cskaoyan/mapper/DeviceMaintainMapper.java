package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceMaintain;
import com.cskaoyan.bean.DeviceMaintainExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceMaintainMapper {
    long countByExample(DeviceMaintainExample example);

    long count_by_deviceFaultId(@Param("searchValue")String searchValue);

    long count_by_deviceMaintainId(@Param("searchValue")String searchValue);

    int deleteByExample(DeviceMaintainExample example);

    int deleteByPrimaryKey(List<String> deviceMaintainId);

    int insert(DeviceMaintain record);

    int insertSelective(DeviceMaintain record);

    List<DeviceMaintain> selectByExample(DeviceMaintainExample example);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByExampleSelective(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByExample(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    int updateByPrimaryKey(DeviceMaintain record);

    List<DeviceMaintain> selectPageOrder(@Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    List<DeviceMaintain> selectPageOrder_by_deviceMaintainId(@Param("searchValue")String searchValue, @Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    List<DeviceMaintain> selectPageOrder_by_deviceFaultId(@Param("searchValue")String searchValue, @Param("startIndex") int startIndex, @Param("endIndex") int endIndex);
}