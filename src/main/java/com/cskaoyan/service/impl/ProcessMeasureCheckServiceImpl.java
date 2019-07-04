package com.cskaoyan.service.impl;

import com.cskaoyan.bean.ProcessMeasureCheck;
import com.cskaoyan.bean.ProcessMeasureCheckExample;
import com.cskaoyan.bean.UnqualifyApply;
import com.cskaoyan.mapper.ProcessMeasureCheckMapper;
import com.cskaoyan.service.ProcessMeasureCheckService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessMeasureCheckServiceImpl implements ProcessMeasureCheckService {
    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;

    @Override
    public int addProcessMeasure(ProcessMeasureCheck processMeasureCheck) {
        int i = processMeasureCheckMapper.insert(processMeasureCheck);
        return i;
    }

    @Override
    public int updateProcessMeasure(ProcessMeasureCheck processMeasureCheck) {
        int i = processMeasureCheckMapper.updateByPrimaryKey(processMeasureCheck);
        return i;
    }

    @Override
    public int deleteProcessMeasure(String[] ids) {
        int i = processMeasureCheckMapper.deleteProcessMeasure(ids);
        return i;
    }

    @Override
    public List<ProcessMeasureCheck> findAllProcessMeasure(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<ProcessMeasureCheck> allProcessMeasure = processMeasureCheckMapper.findAllProcessMeasure();
        return allProcessMeasure;
    }

    @Override
    public List<ProcessMeasureCheck> searchProcessById(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckMapper.searchProcessById(searchValue, startIndex, pageSize);
        return processMeasureChecks;
    }

    @Override
    public long selectTotal() {
        ProcessMeasureCheckExample example = new ProcessMeasureCheckExample();
        long total = processMeasureCheckMapper.countByExample(example);
        return total;
    }
}
