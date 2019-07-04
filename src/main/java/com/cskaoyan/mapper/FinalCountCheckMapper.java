package com.cskaoyan.mapper;

import com.cskaoyan.bean.FinalCountCheck;
import com.cskaoyan.bean.FinalCountCheckExample;
import com.cskaoyan.bean.FinalMeasuretCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalCountCheckMapper {
    long countByExample(FinalCountCheckExample example);

    int deleteByExample(FinalCountCheckExample example);

    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    List<FinalCountCheck> selectByExample(FinalCountCheckExample example);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByExampleSelective(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByExample(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);

    List<FinalCountCheck> findAllFinalCount();

    int addFinalCount(FinalCountCheck finalCountCheck);

    int updateFinalCount(FinalCountCheck finalCountCheck);

    int  deleteFinalCount(@Param("ids") String[] ids);

    List<FinalCountCheck> searchfCountById(@Param("id") String id,@Param("startIndex") int startIndex,@Param("pageSize")int pageSize);

    List<FinalCountCheck> searchfCountByOid(@Param("oid") String oid,@Param("startIndex") int startIndex,@Param("pageSize")int pageSize);
}