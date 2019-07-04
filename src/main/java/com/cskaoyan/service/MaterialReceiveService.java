package com.cskaoyan.service;

import com.cskaoyan.bean.MaterialReceive;

import java.util.List;

public interface MaterialReceiveService {


    List<MaterialReceive> queryMaterialReceive();

    List<MaterialReceive> selectAllMaterialReceive();

    int updateByPrimaryKey(MaterialReceive materialReceive);

    List<MaterialReceive> getMaterialReceiveById(String id);

    int deleteBatch(String[] ids);

    List<MaterialReceive> selectMaterialReceiveLikeMaterialId(String searchValue, int page, int rows);

    Long selectTotalCountLikeMaterialId(String searchValue);

    List<MaterialReceive> selectMaterialReceiveLikeReceiveId(String searchValue, int page, int rows);

    Long selectTotalCountLikeReceiveId(String searchValue);

    int updateNoteByPrimaryKey(MaterialReceive materialReceive);

    int updateAllByPrimaryKey(MaterialReceive materialReceive);

    int insertMaterialReceive(MaterialReceive materialReceive);
}
