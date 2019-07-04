package com.cskaoyan.mapper;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.CustomExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomMapper {
    long countByExample(CustomExample example);

    int deleteByExample(CustomExample example);

    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    int insertSelective(Custom record);

    List<Custom> selectByExample(CustomExample example);

    Custom selectByPrimaryKey(String customId);

    int updateByExampleSelective(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByExample(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    List<Custom> selectAllCustom();

    List<Custom> selectPageCustom(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    int deleteByIds(@Param("ids") String[] ids);

    Long selectTotalCountLikeId(@Param("id")String searchValue);

    List<Custom> selectCustomLikeId(@Param("id") String id,@Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectTotalCountLikeCustomName(@Param("customName")String searchValue);

    List<Custom> selectCustomLikeCustomName(@Param("customName")String searchValue,@Param("startIndex") int startIndex, @Param("pageSize")int pageSize);
}