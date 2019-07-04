package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Work;
import com.cskaoyan.bean.WorkExample;
import com.cskaoyan.mapper.WorkMapper;
import com.cskaoyan.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/19 13:34
 */
@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkMapper workMapper;

    @Override
    public List<Work> findPageWork(int page, int rows) {
        int startIndex = (page - 1) * rows;
        List<Work> works = workMapper.selectPageWork(startIndex, rows);
        return works;    }

    @Override
    public long selectTotalCount() {
        WorkExample workExample = new WorkExample();
        long count = workMapper.countByExample(workExample);
        return count;
    }

    @Override
    public int insert(Work work) {
        int insert = workMapper.insert(work);
        return insert;
    }

    @Override
    public int deleteBatch(String[] ids) {
        int  deletes=workMapper.deleteByIds(ids);
        return deletes;
    }

    @Override
    public int updateByPrimaryKey(Work work) {
        int update = workMapper.updateByPrimaryKey(work);
        return update;
    }

    @Override
    public List<Work> selectAllCustom() {
        WorkExample workExample = new WorkExample();
        List<Work> list = workMapper.selectByExample(workExample);
        return list;
    }

    @Override
    public Work getWorkById(String id) {
        Work work = workMapper.selectByPrimaryKey(id);
        return  work;
    }

    @Override
    public List<Work> selectLikeId(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        Work work = new Work();
        work.setWorkId(searchValue);
        List<Work> works = workMapper.selectLikeCondition(work, startIndex, pageSize);
        return works;
    }

    @Override
    public long selectCountLikeId(String searchValue) {
        Work work = new Work();
        work.setWorkId(searchValue);
        Long count = workMapper.selectCountLikeCondition(work);
        return count;
    }

    @Override
    public List<Work> selectWorkLikeProdName(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<Work> works =workMapper.selectLikeProdName(searchValue, startIndex, pageSize);
        return works;
    }

    @Override
    public Long selectCountLikeProdName(String searchValue) {
        Long count = workMapper.selectCountLikeProdName(searchValue);
        return count;
    }
}
