package com.cskaoyan.mapper;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.bean.ManufactureExample;
import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManufactureMapper {
    long countByExample(ManufactureExample example);

    int deleteByExample(ManufactureExample example);

    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    List<Manufacture> selectByExample(ManufactureExample example);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByExampleSelective(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByExample(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);

    int deleteByIds(@Param("ids") String[] ids);

    List<Manufacture> selectPageManufacture(@Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    List<Manufacture> selectManufactureLikeManufactureSn(@Param("sn") String id, @Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectTotalCountLikeSn(@Param("id")String searchValue);

    List<Manufacture> selectManufactureLikeOrderId(@Param("id") String id, @Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectTotalCountLikeOrderId(@Param("id")String searchValue);

    List<Manufacture> selectLikeTechnologyName(@Param("technologyName") String searchValue, @Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectCountLikeTechnologyName(@Param("technologyName")String searchValue);
}