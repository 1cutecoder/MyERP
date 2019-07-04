package com.cskaoyan.mapper;

import com.cskaoyan.bean.FinalMeasuretCheck;
import com.cskaoyan.bean.FinalMeasuretCheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalMeasuretCheckMapper {
    long countByExample(FinalMeasuretCheckExample example);

    int deleteByExample(FinalMeasuretCheckExample example);

    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    List<FinalMeasuretCheck> selectByExample(FinalMeasuretCheckExample example);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByExampleSelective(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByExample(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);

    List<FinalMeasuretCheck> findAllMeasure();

    int addMeasurement(FinalMeasuretCheck finalMeasuretCheck);

    int updateMeasurement(FinalMeasuretCheck finalMeasuretCheck);

    int deleteMeasurementById(@Param("ids") String[] ids);

    List<FinalMeasuretCheck> searchMeasureById(@Param("id") String id,@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);

    List<FinalMeasuretCheck> searchMeasureByOid(@Param("oid") String oid,@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);
}