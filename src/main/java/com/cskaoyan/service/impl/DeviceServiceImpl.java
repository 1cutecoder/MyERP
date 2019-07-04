package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.DeviceExample;
import com.cskaoyan.mapper.DeviceMapper;
import com.cskaoyan.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public List<Device> findPageDevice(int page, int rows) {
        int startIndex = (page-1)*rows;
        int endIndex = startIndex + rows;
        List<Device> devices = deviceMapper.selectPageOrder(startIndex,endIndex);
        return devices;
    }

    @Override
    public int selectTotalCount() {
        DeviceExample deviceExample =new DeviceExample();
        long deviceCount = deviceMapper.countByExample(deviceExample);
        int count=(int)deviceCount;
        return count;
    }

    @Override
    public List<Device> search_device_by_deviceId(String searchValue, int page, int rows) {
        int startIndex = (page-1)*rows;
        int endIndex = startIndex + rows;
        List<Device> devices = deviceMapper.selectPageOrder_by_deviceId(searchValue, startIndex,endIndex);
        return devices;
    }

    @Override
    public int selectTotalCount_by_deviceId(String searchValue) {
        long deviceCount = deviceMapper.count_by_deviceId(searchValue);
        int count=(int)deviceCount;
        return count;
    }

    @Override
    public List<Device> search_device_by_deviceName(String searchValue, int page, int rows) {
        int startIndex = (page-1)*rows;
        int endIndex = startIndex + rows;
        List<Device> devices = deviceMapper.selectPageOrder_by_deviceName(searchValue, startIndex,endIndex);
        return devices;
    }

    @Override
    public int selectTotalCount_by_deviceName(String searchValue) {
        long deviceCount = deviceMapper.count_by_deviceName(searchValue);
        int count=(int)deviceCount;
        return count;
    }

    @Override
    public List<Device> search_device_by_deviceTypeName(String searchValue, int page, int rows) {
        int startIndex = (page-1)*rows;
        int endIndex = startIndex + rows;
        List<Device> devices = deviceMapper.selectPageOrder_by_deviceTypeName(searchValue, startIndex,endIndex);
        return devices;
    }

    @Override
    public int selectTotalCount_by_deviceTypeName(String searchValue) {
        long deviceCount = deviceMapper.count_by_deviceTypeName(searchValue);
        int count=(int)deviceCount;
        return count;
    }

    @Override
    public int insert(Device device) {
        int status = deviceMapper.insert(device);
        return status;
    }

    @Override
    public int update(Device device) {
        int status = deviceMapper.updateByPrimaryKey(device);
        return status;
    }

    @Override
    public int delete_batch(List<String>  ids) {
        int status = deviceMapper.deleteByPrimaryKey(ids);
        return status;
    }

}
