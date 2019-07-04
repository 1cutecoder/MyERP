package com.cskaoyan.service.impl;

import com.cskaoyan.bean.FinalMeasuretCheck;
import com.cskaoyan.bean.FinalMeasuretCheckExample;
import com.cskaoyan.mapper.FinalMeasuretCheckMapper;
import com.cskaoyan.service.MeasureService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasureServiceImpl implements MeasureService {
    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;
    @Override
    public List<FinalMeasuretCheck> findAllMeasure(int page, int rows) {

        List<FinalMeasuretCheck> allMeasure = finalMeasuretCheckMapper.findAllMeasure();
        return allMeasure;
    }

    @Override
    public int addMeasurement(FinalMeasuretCheck finalMeasuretCheck) {
        int i = finalMeasuretCheckMapper.addMeasurement(finalMeasuretCheck);
        return i;
    }

    @Override
    public int updateMeasurement(FinalMeasuretCheck finalMeasuretCheck) {
        int i = finalMeasuretCheckMapper.updateMeasurement(finalMeasuretCheck);
        return i;
    }

    @Override
    public int deleteMeasurementById(String[] ids) {
        int i = finalMeasuretCheckMapper.deleteMeasurementById(ids);
        return i;
    }

    @Override
    public List<FinalMeasuretCheck> searchMeasureById(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.searchMeasureById(searchValue, startIndex, pageSize);
        return finalMeasuretChecks;
    }

    @Override
    public List<FinalMeasuretCheck> searchMeasureByOid(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.searchMeasureByOid(searchValue, startIndex, pageSize);
        return finalMeasuretChecks;
    }

    @Override
    public long selectTotalCount() {
        FinalMeasuretCheckExample example = new FinalMeasuretCheckExample();
        long total = finalMeasuretCheckMapper.countByExample(example);
        return total;
    }
}
