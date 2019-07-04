package com.cskaoyan.service;

import com.cskaoyan.bean.FinalCountCheck;

import java.util.List;

public interface FinalCountService {
    List<FinalCountCheck> findAllFinalCount(int page, int rows);

    int addFinalCount(FinalCountCheck finalCountCheck);

    int updateFinalCount(FinalCountCheck finalCountCheck);

    int deleteFinalCount(String[] ids);

    List<FinalCountCheck> searchfCountById(String searchValue, int page, int rows);

    List<FinalCountCheck> searchfCountByOid(String searchValue, int page, int rows);

    long searchTotal();
}
