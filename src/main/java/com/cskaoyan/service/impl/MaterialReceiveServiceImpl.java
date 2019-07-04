package com.cskaoyan.service.impl;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.MaterialReceiveMapper;
import com.cskaoyan.service.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {

    @Autowired
    MaterialReceiveMapper materialReceiveMapper;

    @Override
    public List<MaterialReceive> queryMaterialReceive() {
        MaterialReceiveExample example= new MaterialReceiveExample();
        List<MaterialReceive> materialReceives = materialReceiveMapper.selectByExample(example);
        return materialReceives;
    }

    @Override
    public List<MaterialReceive> selectAllMaterialReceive() {
        List<MaterialReceive> materialReceives = materialReceiveMapper.selectPageMaterialReceive(1);
        return materialReceives;
    }


    @Override
    public int updateByPrimaryKey(MaterialReceive materialReceive) {
        int update = materialReceiveMapper.updateByPrimaryKey(materialReceive);
        return update;
    }

    @Override
    public List<MaterialReceive> getMaterialReceiveById(String id) {
        List<MaterialReceive> list= materialReceiveMapper.selectAllMaterialReceive();
        return list;
    }

    @Override
    public int deleteBatch(String[] ids) {

        int deletes = materialReceiveMapper.deleteByIds(ids);
        return deletes;
    }

    @Override
    public List<MaterialReceive> selectMaterialReceiveLikeMaterialId(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<MaterialReceive> materialReceives = materialReceiveMapper.selectMaterialReceiveLikeMaterialId(searchValue, startIndex, pageSize);
        return materialReceives;
    }

    @Override
    public Long selectTotalCountLikeMaterialId(String searchValue) {
        Long count = materialReceiveMapper.selectTotalCountLikeMaterialId(searchValue);
        return count;
    }

    @Override
    public List<MaterialReceive> selectMaterialReceiveLikeReceiveId(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<MaterialReceive> materialReceives = materialReceiveMapper.selectMaterialReceiveLikeReceiveId(searchValue, startIndex, pageSize);
        return materialReceives;
    }

    @Override
    public Long selectTotalCountLikeReceiveId(String searchValue) {
        Long count = materialReceiveMapper.selectTotalCountLikeReceiveId(searchValue);
        return count;
    }

    @Override
    public int updateNoteByPrimaryKey(MaterialReceive materialReceive) {
        int update = materialReceiveMapper.updateNoteByPrimaryKey(materialReceive);
        return update;
    }

    @Override
    public int updateAllByPrimaryKey(MaterialReceive materialReceive) {
        int update = materialReceiveMapper.updateAllByPrimaryKey(materialReceive);
        return update;
    }

    @Override
    public int insertMaterialReceive(MaterialReceive materialReceive) {
        int insert = materialReceiveMapper.insert(materialReceive);
        return insert;
    }

}
