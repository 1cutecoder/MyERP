package com.cskaoyan.service;

import com.cskaoyan.bean.DeviceMaintain;

import java.util.List;

public interface DeviceMaintainService {
    List<DeviceMaintain> findPageDeviceMaintain(int page, int rows);

    List<DeviceMaintain> search_deviceMaintain_by_deviceMaintainId(String searchValue,int page, int rows);

    List<DeviceMaintain> search_deviceMaintain_by_deviceFaultId(String searchValue, int page, int rows);

    int selectTotalCount();

    int selectTotalCount_by_deviceMaintainId(String searchValue);

    int selectTotalCount_by_deviceFaultId(String searchValue);

    int delete_maintain_batch(List<String> ids);

    int insert(DeviceMaintain deviceMaintain);

    int update(DeviceMaintain deviceMaintain);
}
