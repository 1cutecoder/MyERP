package com.cskaoyan.service;

import com.cskaoyan.bean.MaterialConsume;

import java.util.List;

public interface MaterialConsumeService {


    List<MaterialConsume> queryMaterialConsume();

    List<MaterialConsume> selectAllMaterialConsume();

    int updateByPrimaryKey(MaterialConsume materialConsume);

    List<MaterialConsume> getMaterialConsumeById(String id);

    Long selectTotalCount();

    int deleteBatch(String[] ids);

    List<MaterialConsume> selectMaterialConsumeLikeMaterialId(String searchValue, int page, int rows);

    Long selectTotalCountLikeMaterialId(String searchValue);

    List<MaterialConsume> selectMaterialConsumeLikeConsumeId(String searchValue, int page, int rows);

    Long selectTotalCountLikeConsumeId(String searchValue);

    List<MaterialConsume> selectMaterialConsumeLikeWorkId(String searchValue, int page, int rows);

    Long selectTotalCountLikeWorkId(String searchValue);

    int updateNoteByPrimaryKey(MaterialConsume materialConsume);

    int updateAllByPrimaryKey(MaterialConsume materialConsume);

    int insertMaterialConsume(MaterialConsume materialConsume);
}
