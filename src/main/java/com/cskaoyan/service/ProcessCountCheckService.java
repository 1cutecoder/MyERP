package com.cskaoyan.service;

import com.cskaoyan.bean.ProcessCountCheck;

import java.util.List;

public interface ProcessCountCheckService {
    List<ProcessCountCheck> findAllProcessCount(int page, int rows);

    int insert(ProcessCountCheck processCountCheck);

    int update(ProcessCountCheck processCountCheck);

    int deleteProcessCount(String[] ids);

    List<ProcessCountCheck> searchpCountById(String searchValue, int page, int rows);

    long selectTotal();
}

