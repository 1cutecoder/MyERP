package com.cskaoyan.controller;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author：李柏宏（LiberHome）
 * @date：Created in 2019/5/17 15:56
 * @description：工艺监控-工艺管理（李柏宏）
 * @version:0.1$
 */
@Controller
@RequestMapping("/erp/technology")
public class TechnologyController {
    /*引入Service*/
    @Autowired/*注入一下，就不用new*/
    TechnologyService technologyService;

    /*跳转*/
    @RequestMapping("/find")
    @ResponseBody//返回json
    public ModelAndView find(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("technology_list");//指定跳转的页面
        return modelAndView;
    }

    /*查询数据*/
    @RequestMapping("list")
    @ResponseBody
    public Map findPage(int page,int rows){
        List<Technology> pageTechnology = technologyService.findPageTechnology(page, rows);
        int total = technologyService.selectTotalCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageTechnology);
        return map;
    }
}
