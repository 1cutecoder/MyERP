package com.cskaoyan.service;

import com.cskaoyan.bean.Material;

import java.util.List;



public interface MaterialService {

    List<Material> queryMaterial();

    int selectTotalCount();

    List<Material> selectAllMaterial();

    Material getMaterialById(String id);

    int deleteBatch(String[] ids);

    List<Material> selectMaterialLikeId(String searchValue, int page, int rows);

    Long selectTotalCountLikeId(String searchValue);

    List<Material> selectMaterialLikeType(String searchValue, int page, int rows);

    Long selectTotalCountLikeType(String searchValue);

    int updateByPrimaryKey(Material material);

    int updateNoteByPrimaryKey(Material material);

    int updateAllByPrimaryKey(Material material);

    int insertMaterial(Material material);
}
