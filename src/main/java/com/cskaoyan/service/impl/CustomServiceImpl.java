package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.CustomExample;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/18 11:20
 */
@Service
public class CustomServiceImpl implements CustomService {

    @Autowired
    CustomMapper customMapper;

    @Override
    public Custom getCustomById(String id) {
        Custom custom = customMapper.selectByPrimaryKey(id);
        return custom;
    }

    @Override
    public int updateByPrimaryKey(Custom custom) {
        int update = customMapper.updateByPrimaryKey(custom);
        return update;
    }

    @Override
    public List<Custom> selectAllCustom() {
        List<Custom> list= customMapper.selectAllCustom();
        return list;
    }

    @Override
    public List<Custom> findPageCustom(int page, int rows) {
        int startIndex = (page - 1) * rows;
        List<Custom> customs = customMapper.selectPageCustom(startIndex, rows);
        return customs;
    }

    @Override
    public Long selectTotalCount() {
        CustomExample customExample = new CustomExample();
        long orderCount= customMapper.countByExample(customExample);
        return orderCount;
    }

    @Override
    public int insert(Custom custom) {
        int insert = customMapper.insert(custom);
        return insert;
    }

    @Override
    public int deleteBatch(String[] ids) {
        int  deletes=customMapper.deleteByIds(ids);
        return deletes;
    }

    @Override
    public long selectTotalCountLikeId(String searchValue) {
        Long count = customMapper.selectTotalCountLikeId(searchValue);
        return count;
    }

    @Override
    public List<Custom> selectCustomLikeId(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<Custom> customs = customMapper.selectCustomLikeId(searchValue, startIndex, pageSize);
        return customs;
    }

    @Override
    public long selectTotalCountLikeCustomName(String searchValue) {
        Long count = customMapper.selectTotalCountLikeCustomName(searchValue);
        return count;    }

    @Override
    public List<Custom> selectCustomLikeCustomName(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<Custom> customs = customMapper.selectCustomLikeCustomName(searchValue, startIndex, pageSize);
        return customs;
    }
}
