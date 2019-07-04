package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.MaterialExample;
import com.cskaoyan.mapper.MaterialMapper;
import com.cskaoyan.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    @Override
    public List<Material> queryMaterial() {
        MaterialExample example= new MaterialExample();
        List<Material> materials = materialMapper.selectByExample(example);
        return materials;
    }

    @Override
    public int selectTotalCount() {
        return 0;
    }

    @Override
    public List<Material> selectAllMaterial() {
        List<Material> list= materialMapper.selectAllMaterial();
        return list;
    }

    @Override
    public Material getMaterialById(String id) {
        Material material = materialMapper.selectByPrimaryKey(id);
        return material;
    }

    @Override
    public int deleteBatch(String[] ids) {
        int deletes= materialMapper.deleteByIds(ids);
        return deletes;
    }

    @Override
    public List<Material> selectMaterialLikeId(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<Material> materials = materialMapper.selectMaterialLikeId(searchValue, startIndex, pageSize);
        return materials;
    }

    @Override
    public Long selectTotalCountLikeId(String searchValue) {
        Long count = materialMapper.selectTotalCountLikeId(searchValue);
        return count;
    }

    @Override
    public List<Material> selectMaterialLikeType(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<Material> materials = materialMapper.selectMaterialLikeType(searchValue, startIndex, pageSize);
        return materials;
    }

    @Override
    public Long selectTotalCountLikeType(String searchValue) {
        Long count = materialMapper.selectTotalCountLikeType(searchValue);
        return count;
    }

    @Override
    public int updateByPrimaryKey(Material material) {
        int update = materialMapper.updateByPrimaryKey(material);
        return update;
    }

    @Override
    public int updateNoteByPrimaryKey(Material material) {
        int update = materialMapper.updateNoteByPrimaryKey(material);
        return update;
    }

    @Override
    public int updateAllByPrimaryKey(Material material) {
        int update = materialMapper.updateAllByPrimaryKey(material);
        return update;
    }

    @Override
    public int insertMaterial(Material material) {
        int insert = materialMapper.insert(material);
        return insert;
    }
}
