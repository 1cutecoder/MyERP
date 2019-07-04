package com.cskaoyan.mapper;

import com.cskaoyan.bean.*;
import com.cskaoyan.bean.MaterialConsume;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialConsumeMapper {

    long countByExample(MaterialConsumeExample example);

    int deleteByExample(MaterialConsumeExample example);

    int deleteByPrimaryKey(String consumeId);

    int insert(MaterialConsume record);

    int insertSelective(MaterialConsume record);

    int deleteByIds(@Param("ids") String[] ids);

    List<MaterialConsume> selectMaterialConsumeLikeMaterialId(@Param("material_id") String id, @Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectTotalCountLikeMaterialId(@Param("material_id")String searchValue);

    List<MaterialConsume> selectMaterialConsumeLikeConsumeId(@Param("consume_id") String id, @Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectTotalCountLikeConsumeId(@Param("consume_id")String searchValue);

    List<MaterialConsume> selectMaterialConsumeLikeWorkId(@Param("work_id") String id, @Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectTotalCountLikeWorkId(@Param("work_id")String searchValue);

    List<MaterialConsume> selectByExample(MaterialConsumeExample example);

    MaterialConsume selectByPrimaryKey(String consumeId);

    int updateByExampleSelective(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByExample(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByPrimaryKeySelective(MaterialConsume record);

    int updateByPrimaryKey(MaterialConsume record);

    List<MaterialConsume> selectPageMaterialConsume(int num);

    List<MaterialConsume> selectAllMaterialConsume();

    List<MaterialConsume> selectPageMaterialConsume(int startIndex, int rows);

    int updateNoteByPrimaryKey(MaterialConsume record);

    int updateAllByPrimaryKey(MaterialConsume record);
}