package com.cskaoyan.mapper;

import com.cskaoyan.bean.ProcessMeasureCheck;
import com.cskaoyan.bean.ProcessMeasureCheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMeasureCheckMapper {
    long countByExample(ProcessMeasureCheckExample example);

    int deleteByExample(ProcessMeasureCheckExample example);

    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasureCheck processMeasureCheck);

    int insertSelective(ProcessMeasureCheck record);

    List<ProcessMeasureCheck> selectByExample(ProcessMeasureCheckExample example);

    ProcessMeasureCheck selectByPrimaryKey(String pMeasureCheckId);

    int updateByExampleSelective(@Param("record") ProcessMeasureCheck record, @Param("example") ProcessMeasureCheckExample example);

    int updateByExample(@Param("record") ProcessMeasureCheck record, @Param("example") ProcessMeasureCheckExample example);

    int updateByPrimaryKeySelective(ProcessMeasureCheck record);

    int updateByPrimaryKey(ProcessMeasureCheck record);

    List<ProcessMeasureCheck> findAllProcessMeasure();

    int deleteProcessMeasure(@Param("ids") String[] ids);

    List<ProcessMeasureCheck> searchProcessById(@Param("id") String id,@Param("startIndex")int startIndex,@Param("pageSize") int pageSize);
}