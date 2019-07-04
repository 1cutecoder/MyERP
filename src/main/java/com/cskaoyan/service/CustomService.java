package com.cskaoyan.service;

import com.cskaoyan.bean.Custom;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/18 11:11
 */
public interface CustomService {

    Custom getCustomById(String id);

    int updateByPrimaryKey(Custom custom);

    List<Custom> selectAllCustom();

    List<Custom> findPageCustom(int page, int rows);

    Long selectTotalCount();

    int insert(Custom custom);

    int deleteBatch(String[] ids);

    long selectTotalCountLikeId(String searchValue);

    List<Custom> selectCustomLikeId(String searchValue, int page, int rows);

    long selectTotalCountLikeCustomName(String searchValue);

    List<Custom> selectCustomLikeCustomName(String searchValue, int page, int rows);
}
