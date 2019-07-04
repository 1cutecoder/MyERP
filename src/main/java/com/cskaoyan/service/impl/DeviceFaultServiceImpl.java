package com.cskaoyan.service.impl;

import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.bean.DeviceFaultExample;
import com.cskaoyan.mapper.DeviceFaultMapper;
import com.cskaoyan.service.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {
    @Autowired
    DeviceFaultMapper deviceFaultMapper;

    @Override
    public List<DeviceFault> findPageDeviceFault(int page, int rows) {
        int startIndex = (page-1)*rows;
        int endIndex = startIndex + rows;
        List<DeviceFault> deviceFaults = deviceFaultMapper.selectPageOrder(startIndex,endIndex);
        return deviceFaults;
    }

    @Override
    public int selectTotalCount() {
        DeviceFaultExample deviceFaultExample =new DeviceFaultExample();
        long deviceFaultCount = deviceFaultMapper.countByExample(deviceFaultExample);
        int count=(int)deviceFaultCount;
        return count;
    }

    @Override
    public List<DeviceFault> search_deviceFault_by_deviceFaultId(String searchValue, int page, int rows) {
        int startIndex = (page-1)*rows;
        int endIndex = startIndex + rows;
        List<DeviceFault> deviceFaults = deviceFaultMapper.selectPageOrder_by_deviceFaultId(searchValue, startIndex,endIndex);
        return deviceFaults;
    }

    @Override
    public List<DeviceFault> search_deviceFault_by_deviceName(String searchValue, int page, int rows) {
        int startIndex = (page-1)*rows;
        int endIndex = startIndex + rows;
        List<DeviceFault> deviceFaults = deviceFaultMapper.selectPageOrder_by_deviceName(searchValue, startIndex,endIndex);
        return deviceFaults;
    }

    @Override
    public int selectTotalCount_by_deviceFaultId(String searchValue) {
        long deviceFaultCount = deviceFaultMapper.count_by_deviceFaultId(searchValue);
        int count=(int)deviceFaultCount;
        return count;
    }

    @Override
    public int selectTotalCount_by_deviceName(String searchValue) {
        long deviceFaultCount = deviceFaultMapper.count_by_deviceName(searchValue);
        int count=(int)deviceFaultCount;
        return count;
    }

    @Override
    public int insert(DeviceFault deviceFault) {
        int status = deviceFaultMapper.insert(deviceFault);
        return status;
    }

    @Override
    public int update(DeviceFault deviceFault) {
        int status = deviceFaultMapper.updateByPrimaryKey(deviceFault);
        return status;
    }

    @Override
    public int delete_fault_batch(List<String>  ids) {
        int status = deviceFaultMapper.deleteByPrimaryKey(ids);
        return status;
    }
}
