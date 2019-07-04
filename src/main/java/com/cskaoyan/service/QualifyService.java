package com.cskaoyan.service;

import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.UnqualifyApply;
import com.cskaoyan.mapper.UnqualifyApplyMapper;


import java.util.List;

public interface QualifyService {
    List<UnqualifyApply> findUnqualifyByPage();

    int addUnqualify(UnqualifyApply unqualifyApply);


    int deleteUnqualifyApplyById(String[] ids);

    int updateUnqualify(UnqualifyApply unqualifyApply);

    List<UnqualifyApply> searchById(String searchValue, int page, int rows);

    List<UnqualifyApply> searchByName(String searchValue, int page, int rows);

    long selectTotal();
}
