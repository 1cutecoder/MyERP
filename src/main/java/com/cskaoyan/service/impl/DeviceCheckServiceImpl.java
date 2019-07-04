package com.cskaoyan.service.impl;

import com.cskaoyan.bean.DeviceCheck;
import com.cskaoyan.bean.DeviceCheckExample;
import com.cskaoyan.mapper.DeviceCheckMapper;
import com.cskaoyan.service.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {
    @Autowired
    DeviceCheckMapper deviceCheckMapper;

    @Override
    public List<DeviceCheck> findPageDeviceCheck(int page, int rows) {
        int startIndex = (page-1)*rows;
        int endIndex = startIndex + rows;
        List<DeviceCheck> deviceChecks = deviceCheckMapper.selectPageOrder(startIndex,endIndex);
        return deviceChecks;
    }

    @Override
    public int selectTotalCount() {
        DeviceCheckExample deviceCheckExample =new DeviceCheckExample();
        long deviceCheckCount = deviceCheckMapper.countByExample(deviceCheckExample);
        int count=(int)deviceCheckCount;
        return count;
    }

    @Override
    public List<DeviceCheck> search_deviceCheck_by_deviceCheckId(String searchValue, int page, int rows) {
        int startIndex = (page-1)*rows;
        int endIndex = startIndex + rows;
        List<DeviceCheck> deviceChecks = deviceCheckMapper.selectPageOrder_by_deviceCheckId(searchValue, startIndex,endIndex);
        return deviceChecks;
    }

    @Override
    public List<DeviceCheck> search_deviceCheck_by_deviceName(String searchValue, int page, int rows) {
        int startIndex = (page-1)*rows;
        int endIndex = startIndex + rows;
        List<DeviceCheck> deviceChecks = deviceCheckMapper.selectPageOrder_by_deviceName(searchValue, startIndex,endIndex);
        return deviceChecks;
    }

    @Override
    public int selectTotalCount_by_deviceCheckId(String searchValue) {
        long deviceCheckCount = deviceCheckMapper.count_by_deviceCheckId(searchValue);
        int count=(int)deviceCheckCount;
        return count;
    }

    @Override
    public int selectTotalCount_by_deviceName(String searchValue) {
        long deviceCheckCount = deviceCheckMapper.count_by_deviceName(searchValue);
        int count=(int)deviceCheckCount;
        return count;
    }

    @Override
    public int insert(DeviceCheck deviceCheck) {
        int status = deviceCheckMapper.insert(deviceCheck);
        return status;
    }

    @Override
    public int update(DeviceCheck deviceCheck) {
        int status = deviceCheckMapper.updateByPrimaryKey(deviceCheck);
        return status;
    }

    @Override
    public int delete_check_batch(List<String>  ids) {
        int status = deviceCheckMapper.deleteByPrimaryKey(ids);
        return status;
    }
}
