package com.cskaoyan.service;

import com.cskaoyan.bean.DeviceType;

import java.util.List;

public interface DeviceTypeService {
    List<DeviceType> findPageDeviceType(int page, int rows);

    List<DeviceType> search_deviceType_by_deviceTypeId(String searchValue,int page, int rows);

    List<DeviceType> search_deviceType_by_deviceTypeName(String searchValue,int page, int rows);

    int selectTotalCount();

    int selectTotalCount_by_deviceTypeId(String searchValue);

    int selectTotalCount_by_deviceTypeName(String searchValue);

    int delete_type_batch(List<String>  ids);

    int insert(DeviceType deviceType);

    int update(DeviceType deviceType);
}
