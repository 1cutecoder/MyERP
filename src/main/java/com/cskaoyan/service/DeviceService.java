package com.cskaoyan.service;

import com.cskaoyan.bean.Device;

import java.util.List;

public interface DeviceService {
    List<Device> findPageDevice(int page, int rows);

    List<Device> search_device_by_deviceId(String searchValue, int page, int rows);

    List<Device> search_device_by_deviceName(String searchValue, int page, int rows);

    List<Device> search_device_by_deviceTypeName(String searchValue, int page, int rows);

    int selectTotalCount();

    int selectTotalCount_by_deviceId(String searchValue);

    int selectTotalCount_by_deviceName(String searchValue);

    int selectTotalCount_by_deviceTypeName(String searchValue);


    int delete_batch(List<String>  ids);

    int insert(Device device);

    int update(Device device);

}
