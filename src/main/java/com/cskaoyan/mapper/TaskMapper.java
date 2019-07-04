package com.cskaoyan.mapper;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.Task;
import com.cskaoyan.bean.TaskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {
    long countByExample(TaskExample example);

    int deleteByExample(TaskExample example);

    int deleteByPrimaryKey(String taskId);

    int insert(Task record);

    int insertSelective(Task record);

    List<Task> selectByExample(TaskExample example);

    Task selectByPrimaryKey(String taskId);

    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    List<Task> findPageTask(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    int deleteByIds(@Param("ids") String[] ids);

    List<Task> selectTaskLikeTaskId(@Param("task_id") String id, @Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectTotalCountLikeTaskId(@Param("task_id")String searchValue);

    List<Task> selectTaskLikeWorkId(@Param("work_id") String id, @Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectTotalCountLikeWorkId(@Param("work_id")String searchValue);

    List<Task> selectTaskLikeManuSn(@Param("sn") String id, @Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectTotalCountLikeManuSn(@Param("sn")String searchValue);
}