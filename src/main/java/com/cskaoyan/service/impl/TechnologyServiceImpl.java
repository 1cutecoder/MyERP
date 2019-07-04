package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyExample;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：李柏宏（LiberHome）
 * @date：Created in 2019/5/18 11:55
 * @description：工艺-最开始显示的list（李柏宏）
 * @version:$
 */
@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    TechnologyMapper technologyMapper;
    @Override
    public List<Technology> findPageTechnology(int page, int rows) {
        int startIndex=(page-1)*rows;
        List<Technology> technologies = technologyMapper.selectPageOrder(startIndex,rows);
        return technologies;
    }

    @Override
    public int selectTotalCount() {
        TechnologyExample technologyExample =new TechnologyExample();
        long technologyCount = technologyMapper.countByExample(technologyExample);
        int count=(int)technologyCount;
        return count;
    }
}
