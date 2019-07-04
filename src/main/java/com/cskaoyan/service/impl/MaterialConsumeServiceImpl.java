package com.cskaoyan.service.impl;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.MaterialConsumeMapper;
import com.cskaoyan.service.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {


    @Autowired
    MaterialConsumeMapper materialConsumeMapper;

    @Override
    public List<MaterialConsume> queryMaterialConsume() {
        MaterialConsumeExample example= new MaterialConsumeExample();
        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectByExample(example);
        return materialConsumes;
    }

    @Override
    public List<MaterialConsume> selectAllMaterialConsume() {
        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectPageMaterialConsume(1);
        return materialConsumes;
    }

    @Override
    public List<MaterialConsume> getMaterialConsumeById(String id) {
        List<MaterialConsume> list= materialConsumeMapper.selectAllMaterialConsume();
        return list;
    }


    @Override
    public Long selectTotalCount() {
        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        long materialCount = materialConsumeMapper.countByExample(materialConsumeExample);
        return materialCount;
    }

    @Override
    public int deleteBatch(String[] ids) {

        int deletes = materialConsumeMapper.deleteByIds(ids);
        return deletes;
    }

    @Override
    public List<MaterialConsume> selectMaterialConsumeLikeMaterialId(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectMaterialConsumeLikeMaterialId(searchValue, startIndex, pageSize);
        return materialConsumes;
    }

    @Override
    public Long selectTotalCountLikeMaterialId(String searchValue) {
        Long count = materialConsumeMapper.selectTotalCountLikeMaterialId(searchValue);
        return count;
    }

    @Override
    public List<MaterialConsume> selectMaterialConsumeLikeConsumeId(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectMaterialConsumeLikeConsumeId(searchValue, startIndex, pageSize);
        return materialConsumes;
    }

    @Override
    public Long selectTotalCountLikeConsumeId(String searchValue) {
        Long count = materialConsumeMapper.selectTotalCountLikeConsumeId(searchValue);
        return count;
    }

    @Override
    public List<MaterialConsume> selectMaterialConsumeLikeWorkId(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectMaterialConsumeLikeWorkId(searchValue, startIndex, pageSize);
        return materialConsumes;
    }

    @Override
    public Long selectTotalCountLikeWorkId(String searchValue) {
        Long count = materialConsumeMapper.selectTotalCountLikeWorkId(searchValue);
        return count;
    }

    @Override
    public int updateByPrimaryKey(MaterialConsume materialConsume) {
        int update = materialConsumeMapper.updateNoteByPrimaryKey(materialConsume);
        return update;
    }

    @Override
    public int updateNoteByPrimaryKey(MaterialConsume materialConsume) {
        int update = materialConsumeMapper.updateNoteByPrimaryKey(materialConsume);
        return update;
    }


    @Override
    public int updateAllByPrimaryKey(MaterialConsume materialConsume) {
        int update = materialConsumeMapper.updateAllByPrimaryKey(materialConsume);
        return update;
    }

    @Override
    public int insertMaterialConsume(MaterialConsume materialConsume) {
        int insert = materialConsumeMapper.insert(materialConsume);
        return insert;
    }
}
