package com.cskaoyan.service;

import com.cskaoyan.bean.DeviceFault;

import java.util.List;

public interface DeviceFaultService {
    List<DeviceFault> findPageDeviceFault(int page, int rows);

    List<DeviceFault> search_deviceFault_by_deviceFaultId(String searchValue, int page, int rows);

    List<DeviceFault> search_deviceFault_by_deviceName(String searchValue, int page, int rows);

    int selectTotalCount();

    int selectTotalCount_by_deviceFaultId(String searchValue);

    int selectTotalCount_by_deviceName(String searchValue);


    int delete_fault_batch(List<String> ids);

    int insert(DeviceFault deviceFault);

    int update(DeviceFault deviceFault);
}
