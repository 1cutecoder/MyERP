package com.cskaoyan.service.impl;

import com.cskaoyan.bean.UnqualifyApply;
import com.cskaoyan.bean.UnqualifyApplyExample;
import com.cskaoyan.mapper.UnqualifyApplyMapper;
import com.cskaoyan.service.QualifyService;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualifyServiceImpl implements QualifyService {
    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;

    @Override
    public List<UnqualifyApply> findUnqualifyByPage() {
        List<UnqualifyApply> unqualifyApplyList = unqualifyApplyMapper.findUnqualifyByPage();
        return unqualifyApplyList;
    }

    @Override
    public int addUnqualify(UnqualifyApply unqualifyApply) {
        int i = unqualifyApplyMapper.addUnqualify(unqualifyApply);
        return i;
    }


    @Override
    public int deleteUnqualifyApplyById(String[] ids) {
        int i = unqualifyApplyMapper.deleteById(ids);
        return i;
    }

    @Override
    public int updateUnqualify(UnqualifyApply unqualifyApply) {
        int i = unqualifyApplyMapper.updateUnqualify(unqualifyApply);
        return i;
    }

    @Override
    public List<UnqualifyApply> searchById(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.searchById(searchValue, startIndex, pageSize);
        return unqualifyApplies;
    }

    @Override
    public List<UnqualifyApply> searchByName(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.searchByName(searchValue, startIndex, pageSize);
        return unqualifyApplies;
    }

    @Override
    public long selectTotal() {
        UnqualifyApplyExample example = new UnqualifyApplyExample();
        long total = unqualifyApplyMapper.countByExample(example);
        return total;
    }
}
