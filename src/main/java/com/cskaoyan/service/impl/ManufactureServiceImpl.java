package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.bean.ManufactureExample;
import com.cskaoyan.bean.Order;
import com.cskaoyan.mapper.ManufactureMapper;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/19 13:33
 */
@Service
public class ManufactureServiceImpl implements ManufactureService {
    @Autowired
    ManufactureMapper manufactureMapper;

    @Override
    public List<Manufacture> findPageManufacture(int page, int rows) {
        int startIndex = (page - 1) * rows;
        List<Manufacture> manufactures = manufactureMapper.selectPageManufacture(startIndex, rows);
        return manufactures;    }

    @Override
    public Long selectTotalCount() {
        ManufactureExample manufactureExample = new ManufactureExample();
        long count = manufactureMapper.countByExample(manufactureExample);
        return count;
    }

    @Override
    public int insert(Manufacture manufacture) {
        int insert = manufactureMapper.insert(manufacture);
        return insert;
    }

    @Override
    public int deleteBatch(String[] ids) {
        int  deletes=manufactureMapper.deleteByIds(ids);
        return deletes;
    }

    @Override
    public int updateByPrimaryKey(Manufacture manufacture) {
        int update = manufactureMapper.updateByPrimaryKey(manufacture);
        return update;
    }

    @Override
    public List<Manufacture> selectAllCustom() {
        ManufactureExample manufactureExample = new ManufactureExample();
        List<Manufacture> list = manufactureMapper.selectByExample(manufactureExample);
        return list;
    }

    @Override
    public List<Manufacture> selectManufactureLikeManufactureSn(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<Manufacture> manufactures = manufactureMapper.selectManufactureLikeManufactureSn(searchValue, startIndex, pageSize);
        return manufactures;
    }

    @Override
    public Long selectTotalCountLikeSn(String searchValue) {
        Long count = manufactureMapper.selectTotalCountLikeSn(searchValue);
        return count;
    }

    @Override
    public List<Manufacture> selectManufactureLikeManufactureOrderId(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<Manufacture> manufactures = manufactureMapper.selectManufactureLikeOrderId(searchValue, startIndex, pageSize);
        return manufactures;
    }

    @Override
    public Long selectTotalCountLikeOrderId(String searchValue) {
        Long count = manufactureMapper.selectTotalCountLikeOrderId(searchValue);
        return count;
    }

    @Override
    public List<Manufacture> selectManufactureLikeManufactureTechnologyName(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<Manufacture> manufactures = manufactureMapper.selectLikeTechnologyName(searchValue, startIndex, pageSize);
        return manufactures;
    }

    @Override
    public Long selectTotalCountLikeTechnologyName(String searchValue) {
        Long count = manufactureMapper.selectCountLikeTechnologyName(searchValue);
        return count;
    }
}
