package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.Task;
import com.cskaoyan.bean.TaskExample;
import com.cskaoyan.mapper.TaskMapper;
import com.cskaoyan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/19 13:34
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    @Override
    public int insert(Task task) {
        int insert = taskMapper.insert(task);
        return insert;
    }

    @Override
    public int deleteBatch(String[] ids) {
        int  deletes=taskMapper.deleteByIds(ids);
        return deletes;
    }



    @Override
    public int updateByPrimaryKey(Task task) {
        int update = taskMapper.updateByPrimaryKey(task);
        return update;
    }

    @Override
    public List<Task> findPageTask(int page, int rows) {
        int startIndex = (page - 1) * rows;
        List<Task> tasks = taskMapper.findPageTask(startIndex, rows);
        return tasks;
    }

    @Override
    public long selectTotalCount() {
        TaskExample taskExample = new TaskExample();
        long count= taskMapper.countByExample(taskExample);
        return count;
    }

    @Override
    public List<Task> selectTaskLikeTaskId(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<Task> tasks = taskMapper.selectTaskLikeTaskId(searchValue, startIndex, pageSize);
        return tasks;
    }

    @Override
    public Long selectTotalCountLikeTaskId(String searchValue) {
        Long count = taskMapper.selectTotalCountLikeTaskId(searchValue);
        return count;
    }

    @Override
    public List<Task> selectTaskLikeWorkId(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<Task> tasks = taskMapper.selectTaskLikeWorkId(searchValue, startIndex, pageSize);
        return tasks;
    }

    @Override
    public Long selectTotalCountLikeWorkId(String searchValue) {
        Long count = taskMapper.selectTotalCountLikeWorkId(searchValue);
        return count;
    }

    @Override
    public List<Task> selectTaskLikeManuSn(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<Task> tasks = taskMapper.selectTaskLikeManuSn(searchValue, startIndex, pageSize);
        return tasks;
    }

    @Override
    public Long selectTotalCountLikeManuSn(String searchValue) {
        Long count = taskMapper.selectTotalCountLikeManuSn(searchValue);
        return count;
    }
}
