package com.cskaoyan.mapper;

import com.cskaoyan.bean.Work;
import com.cskaoyan.bean.WorkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {
    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(String workId);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    List<Work> selectPageWork(@Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    int deleteByIds(@Param("ids") String[] ids);

    List<Work> selectLikeCondition(@Param("work") Work work, @Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectCountLikeCondition(@Param("work")Work work);

    List<Work> selectLikeProdName(@Param("proName") String searchValue, @Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectCountLikeProdName(@Param("proName")String searchValue);

}