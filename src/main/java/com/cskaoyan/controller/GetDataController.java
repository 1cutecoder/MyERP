package com.cskaoyan.controller;

import com.cskaoyan.bean.*;
import com.cskaoyan.bean.Process;
import com.cskaoyan.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/20 8:44
 */
@Controller
@RequestMapping("/erp")
public class GetDataController {
    @Autowired
    ProcessMapper processMapper;
    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    TechnologyMapper technologyMapper;
    @Autowired
    TechnologyPlanMapper technologyPlanMapper;
    @RequestMapping("/process/get_data")
    @ResponseBody
    public List<Process> getProcessData() {
        List<Process> list=processMapper.selectByExample(new ProcessExample());
        return list;
    }

    @RequestMapping("/deviceList/get_data")
    @ResponseBody
    public List<Device> getDeviceData() {
        List<Device> list=deviceMapper.selectByExample(new DeviceExample());
        return list;
    }
    @RequestMapping("/technology/get_data")
    @ResponseBody
    public List<Technology> getTechnologyData() {
        List<Technology> list=technologyMapper.selectByExample(new TechnologyExample());
        return list;
    }
    @RequestMapping("/technologyPlan/get_data")
    @ResponseBody
    public List<TechnologyPlan> getTechnologyPlanData() {
        List<TechnologyPlan> list=technologyPlanMapper.selectByExample(new TechnologyPlanExample());
        return list;
    }
}
