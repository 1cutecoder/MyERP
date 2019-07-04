package com.cskaoyan.service;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.Task;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/19 13:31
 */
public interface TaskService {

    List<Task> findPageTask(int page, int rows);

    long selectTotalCount();

    public int deleteBatch(String[] ids);

    int insert(Task task);

    int updateByPrimaryKey(Task task);

    List<Task> selectTaskLikeTaskId(String searchValue, int page, int rows);

    Long selectTotalCountLikeTaskId(String searchValue);

    List<Task> selectTaskLikeWorkId(String searchValue, int page, int rows);

    Long selectTotalCountLikeWorkId(String searchValue);

    List<Task> selectTaskLikeManuSn(String searchValue, int page, int rows);

    Long selectTotalCountLikeManuSn(String searchValue);
}
