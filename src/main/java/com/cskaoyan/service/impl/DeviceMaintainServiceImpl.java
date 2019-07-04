package com.cskaoyan.service.impl;

import com.cskaoyan.bean.DeviceMaintain;
import com.cskaoyan.bean.DeviceMaintainExample;
import com.cskaoyan.mapper.DeviceMaintainMapper;
import com.cskaoyan.service.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {
    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;

    @Override
    public List<DeviceMaintain> findPageDeviceMaintain(int page, int rows) {
        int startIndex = (page-1)*rows;
        int endIndex = startIndex + rows;
        List<DeviceMaintain> deviceMaintains = deviceMaintainMapper.selectPageOrder(startIndex,endIndex);
        return deviceMaintains;
    }

    @Override
    public int selectTotalCount() {
        DeviceMaintainExample deviceMaintainExample =new DeviceMaintainExample();
        long deviceMaintainCount = deviceMaintainMapper.countByExample(deviceMaintainExample);
        int count=(int)deviceMaintainCount;
        return count;
    }

    @Override
    public List<DeviceMaintain> search_deviceMaintain_by_deviceMaintainId(String searchValue, int page, int rows) {
        int startIndex = (page-1)*rows;
        int endIndex = startIndex + rows;
        List<DeviceMaintain> deviceMaintains = deviceMaintainMapper.selectPageOrder_by_deviceMaintainId(searchValue, startIndex,endIndex);
        return deviceMaintains;
    }

    @Override
    public List<DeviceMaintain> search_deviceMaintain_by_deviceFaultId(String searchValue, int page, int rows) {
        int startIndex = (page-1)*rows;
        int endIndex = startIndex + rows;
        List<DeviceMaintain> deviceMaintains = deviceMaintainMapper.selectPageOrder_by_deviceFaultId(searchValue, startIndex,endIndex);
        return deviceMaintains;
    }

    @Override
    public int selectTotalCount_by_deviceMaintainId(String searchValue) {
        long deviceMaintainCount = deviceMaintainMapper.count_by_deviceMaintainId(searchValue);
        int count=(int)deviceMaintainCount;
        return count;
    }

    @Override
    public int selectTotalCount_by_deviceFaultId(String searchValue) {
        long deviceMaintainCount = deviceMaintainMapper.count_by_deviceFaultId(searchValue);
        int count=(int)deviceMaintainCount;
        return count;
    }

    @Override
    public int insert(DeviceMaintain deviceMaintain) {
        int status = deviceMaintainMapper.insert(deviceMaintain);
        return status;
    }

    @Override
    public int update(DeviceMaintain deviceMaintain) {
        int status = deviceMaintainMapper.updateByPrimaryKey(deviceMaintain);
        return status;
    }

    @Override
    public int delete_maintain_batch(List<String>  ids) {
        int status = deviceMaintainMapper.deleteByPrimaryKey(ids);
        return status;
    }
}
