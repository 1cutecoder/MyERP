package com.cskaoyan.service.impl;

import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.bean.DeviceTypeExample;
import com.cskaoyan.mapper.DeviceTypeMapper;
import com.cskaoyan.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    @Override
    public List<DeviceType> findPageDeviceType(int page, int rows) {
        int startIndex = (page-1)*rows;
        int endIndex = startIndex + rows;
        List<DeviceType> deviceTypes = deviceTypeMapper.selectPageOrder(startIndex,endIndex);
        return deviceTypes;
    }

    @Override
    public int selectTotalCount() {
        DeviceTypeExample deviceTypeExample =new DeviceTypeExample();
        long deviceTypeCount = deviceTypeMapper.countByExample(deviceTypeExample);
        int count=(int)deviceTypeCount;
        return count;
    }

    @Override
    public List<DeviceType> search_deviceType_by_deviceTypeId(String searchValue, int page, int rows) {
        int startIndex = (page-1)*rows;
        int endIndex = startIndex + rows;
        List<DeviceType> deviceTypes = deviceTypeMapper.selectPageOrder_by_deviceTypeId(searchValue, startIndex,endIndex);
        return deviceTypes;
    }

    @Override
    public List<DeviceType> search_deviceType_by_deviceTypeName(String searchValue, int page, int rows) {
        int startIndex = (page-1)*rows;
        int endIndex = startIndex + rows;
        List<DeviceType> deviceTypes = deviceTypeMapper.selectPageOrder_by_deviceTypeName(searchValue, startIndex,endIndex);
        return deviceTypes;
    }

    @Override
    public int selectTotalCount_by_deviceTypeId(String searchValue) {
        long deviceTypeCount = deviceTypeMapper.count_by_deviceTypeId(searchValue);
        int count=(int)deviceTypeCount;
        return count;
    }

    @Override
    public int selectTotalCount_by_deviceTypeName(String searchValue) {
        long deviceTypeCount = deviceTypeMapper.count_by_deviceTypeName(searchValue);
        int count=(int)deviceTypeCount;
        return count;
    }

    @Override
    public int insert(DeviceType deviceType) {
        int status = deviceTypeMapper.insert(deviceType);
        return status;
    }

    @Override
    public int update(DeviceType deviceType) {
        int status = deviceTypeMapper.updateByPrimaryKey(deviceType);
        return status;
    }

    @Override
    public int delete_type_batch(List<String>  ids) {
        int status = deviceTypeMapper.deleteByPrimaryKey(ids);
        return status;
    }
}
