package com.cskaoyan.service;

import com.cskaoyan.bean.Work;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/19 13:27
 */
public interface WorkService {

    List<Work> findPageWork(int page, int rows);

    long selectTotalCount();

    int insert(Work work);

    int deleteBatch(String[] ids);

    int updateByPrimaryKey(Work work);

    List<Work> selectAllCustom();


    Work getWorkById(String id);

    List<Work> selectLikeId(String searchValue, int page, int rows);

    long selectCountLikeId(String searchValue);

    List<Work> selectWorkLikeProdName(String searchValue, int page, int rows);

    Long selectCountLikeProdName(String searchValue);
}
