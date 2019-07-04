package com.cskaoyan.mapper;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.MaterialExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialMapper {
    long countByExample(MaterialExample example);

    int deleteByExample(MaterialExample example);

    int deleteByPrimaryKey(String materialId);

    int insert(Material record);

    int insertSelective(Material record);

    int deleteByIds(@Param("ids") String[] ids);

    List<Material> selectMaterialLikeId(@Param("id") String id, @Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectTotalCountLikeId(@Param("id")String searchValue);

    List<Material> selectMaterialLikeType(@Param("type") String id, @Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectTotalCountLikeType(@Param("type")String searchValue);

    List<Material> selectByExample(MaterialExample example);

    Material selectByPrimaryKey(String materialId);

    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByExample(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);

    int updateNoteByPrimaryKey(Material record);

    int updateAllByPrimaryKey(Material record);

    List<Material> selectPageMaterial(int num);

    List<Material> selectAllMaterial();
}