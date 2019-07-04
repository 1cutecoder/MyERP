package com.cskaoyan.service;

import com.cskaoyan.bean.ProcessMeasureCheck;

import java.util.List;

public interface ProcessMeasureCheckService {
    List<ProcessMeasureCheck> findAllProcessMeasure(int page, int rows);

    int addProcessMeasure(ProcessMeasureCheck processMeasureCheck);

    int updateProcessMeasure(ProcessMeasureCheck processMeasureCheck);

    int deleteProcessMeasure(String[] ids);

    List<ProcessMeasureCheck> searchProcessById(String searchValue, int page, int rows);

    long selectTotal();
}

