package com.cskaoyan.service.impl;

import com.cskaoyan.bean.ProcessCountCheck;
import com.cskaoyan.bean.ProcessCountCheckExample;
import com.cskaoyan.bean.ProcessMeasureCheck;
import com.cskaoyan.mapper.ProcessCountCheckMapper;
import com.cskaoyan.service.ProcessCountCheckService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService {
    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;
    @Override
    public List<ProcessCountCheck> findAllProcessCount(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<ProcessCountCheck> allProcessCount = processCountCheckMapper.findAllProcessCount();
        return allProcessCount;
    }

    @Override
    public int insert(ProcessCountCheck processCountCheck) {
        int i = processCountCheckMapper.insert(processCountCheck);
        return i;
    }
    @Override
    public int update(ProcessCountCheck processCountCheck) {
        int i = processCountCheckMapper.updateByPrimaryKey(processCountCheck);
        return i;
    }

    @Override
    public int deleteProcessCount(String[] ids) {
        int i = processCountCheckMapper.deleteProcessCount(ids);
        return i;
    }

    @Override
    public List<ProcessCountCheck> searchpCountById(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<ProcessCountCheck> processCountChecks = processCountCheckMapper.searchpCountById(searchValue, startIndex, pageSize);
        return processCountChecks;
    }

    @Override
    public long selectTotal() {
        ProcessCountCheckExample example = new ProcessCountCheckExample();
        long total = processCountCheckMapper.countByExample(example);
        return total;

    }
}
