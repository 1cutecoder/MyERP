package com.cskaoyan.service;

import com.cskaoyan.bean.DeviceCheck;

import java.util.List;

public interface DeviceCheckService {
    List<DeviceCheck> findPageDeviceCheck(int page, int rows);

    List<DeviceCheck> search_deviceCheck_by_deviceCheckId(String searchValue, int page, int rows);

    List<DeviceCheck> search_deviceCheck_by_deviceName(String searchValue, int page, int rows);

    int selectTotalCount();

    int selectTotalCount_by_deviceCheckId(String searchValue);

    int selectTotalCount_by_deviceName(String searchValue);

    int delete_check_batch(List<String>  ids);

    int insert(DeviceCheck deviceCheck);

    int update(DeviceCheck deviceCheck);
}
