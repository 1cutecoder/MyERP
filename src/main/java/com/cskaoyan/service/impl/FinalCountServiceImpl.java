package com.cskaoyan.service.impl;

import com.cskaoyan.bean.FinalCountCheck;
import com.cskaoyan.bean.FinalCountCheckExample;
import com.cskaoyan.bean.FinalMeasuretCheck;
import com.cskaoyan.mapper.FinalCountCheckMapper;
import com.cskaoyan.service.FinalCountService;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalCountServiceImpl implements FinalCountService {
    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;

    @Override
    public List<FinalCountCheck> findAllFinalCount(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<FinalCountCheck> allFinalCount = finalCountCheckMapper.findAllFinalCount();
        return allFinalCount;
    }

    @Override
    public int addFinalCount(FinalCountCheck finalCountCheck) {
        int i = finalCountCheckMapper.addFinalCount(finalCountCheck);
        return i;
    }

    @Override
    public int updateFinalCount(FinalCountCheck finalCountCheck) {
        int i = finalCountCheckMapper.updateFinalCount(finalCountCheck);
        return i;
    }

    @Override
    public int deleteFinalCount(String[] ids) {
        int i = finalCountCheckMapper.deleteFinalCount(ids);
        return i;
    }

    @Override
    public List<FinalCountCheck> searchfCountById(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.searchfCountById(searchValue, startIndex, pageSize);
        return finalCountChecks;
    }

    @Override
    public List<FinalCountCheck> searchfCountByOid(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.searchfCountByOid(searchValue, startIndex, pageSize);
        return finalCountChecks;
    }

    @Override
    public long searchTotal() {
        FinalCountCheckExample example = new FinalCountCheckExample();
        long total = finalCountCheckMapper.countByExample(example);
        return total;
    }
}
