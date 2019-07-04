package com.cskaoyan.mapper;

import com.cskaoyan.bean.MaterialConsume;
import com.cskaoyan.bean.MaterialReceive;
import com.cskaoyan.bean.MaterialReceiveExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialReceiveMapper {
    long countByExample(MaterialReceiveExample example);

    int deleteByExample(MaterialReceiveExample example);

    int deleteByPrimaryKey(String receiveId);

    int insert(MaterialReceive record);

    int insertSelective(MaterialReceive record);

    int deleteByIds(@Param("ids") String[] ids);

    List<MaterialReceive> selectMaterialReceiveLikeMaterialId(@Param("material_id") String id, @Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectTotalCountLikeMaterialId(@Param("material_id")String searchValue);

    List<MaterialReceive> selectMaterialReceiveLikeReceiveId(@Param("receive_id") String id, @Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectTotalCountLikeReceiveId(@Param("receive_id")String searchValue);

    List<MaterialReceive> selectByExample(MaterialReceiveExample example);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByExampleSelective(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByExample(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);

    List<MaterialReceive> selectPageMaterialReceive(int num);

    List<MaterialReceive> selectAllMaterialReceive();

    List<MaterialConsume> selectPageMaterialReceive(int startIndex, int rows);

    int updateNoteByPrimaryKey(MaterialReceive record);

    int updateAllByPrimaryKey(MaterialReceive record);

}