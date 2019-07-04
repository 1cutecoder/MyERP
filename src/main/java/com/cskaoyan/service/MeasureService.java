package com.cskaoyan.service;

import com.cskaoyan.bean.FinalMeasuretCheck;

import java.util.List;

public interface MeasureService {
    List<FinalMeasuretCheck> findAllMeasure(int page, int rows);

    int addMeasurement(FinalMeasuretCheck finalMeasuretCheck);

    int updateMeasurement(FinalMeasuretCheck finalMeasuretCheck);

    int deleteMeasurementById(String[] ids);
    List<FinalMeasuretCheck> searchMeasureById(String searchValue,int page, int rows);

    List<FinalMeasuretCheck> searchMeasureByOid(String searchValue, int page, int rows);

    long selectTotalCount();
}
