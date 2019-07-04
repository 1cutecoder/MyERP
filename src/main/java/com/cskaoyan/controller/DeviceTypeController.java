package com.cskaoyan.controller;

import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author：陈绍正
 * @date：Created in 2019/5/19 15:59
 * @description：设备管理-设备种类
 * @version:0.1$
 */

@Controller
@RequestMapping("/erp")
public class DeviceTypeController {

    @Autowired
    DeviceTypeService deviceTypeService;

    @RequestMapping("device/deviceType")
    public String find(){
        return "deviceType";//跳转到显示页面
    }

    /*查询数据*/
    @RequestMapping("deviceType/list")
    @ResponseBody
    public Map findPage(int page, int rows){
        List<DeviceType> pageDeviceType = deviceTypeService.findPageDeviceType(page, rows);
        int total = deviceTypeService.selectTotalCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageDeviceType);
        return map;
    }

    /*新增数据权限判断*/
    @RequestMapping("deviceType/add_judge")
    @ResponseBody
    public Map add_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    /*新增数据页面*/
    @RequestMapping("deviceType/add")
    public String add(){
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deviceList_add");*/
        return "deviceType_add";
    }

    /*新增数据*/
    @RequestMapping("deviceType/insert")
    @ResponseBody
    public Map insert(DeviceType deviceType){
        int status = deviceTypeService.insert(deviceType);
        HashMap<String, Object> map = new HashMap<>();
        if(status == 1){
            map.put("status", 200);
        }else {
            map.put("msg", "设备种类添加失败！");
        }
        return map;
    }

    /*修改数据权限判断*/
    @RequestMapping("deviceType/edit_judge")
    @ResponseBody
    public Map edit_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    /*修改数据页面*/
    @RequestMapping("deviceType/edit")
    public String edit(){
        return "deviceType_edit";
    }

    /*修改数据*/
    @RequestMapping("deviceType/update")
    @ResponseBody
    public Map update(DeviceType deviceType){
        int status = deviceTypeService.update(deviceType);
        HashMap<String, Object> map = new HashMap<>();
        if(status == 1){
            map.put("status", 200);
        }else {
            map.put("msg", "设备种类信息修改失败！");
        }
        return map;
    }

    /*删除数据权限判断*/
    @RequestMapping("deviceType/delete_judge")
    @ResponseBody
    public Map delete_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    /*删除数据*/
    @RequestMapping("deviceType/delete_batch")
    @ResponseBody
    public Map delete_type_batch(String[] ids){
        List<String> strings = new ArrayList<String>();
        for (String s :
                ids) {
            strings.add(s);
        }
        int status = deviceTypeService.delete_type_batch(strings);
        HashMap<String, Object> map = new HashMap<>();
        if(status != 0){
            map.put("status", 200);
        }
        return map;
    }

    /*查找数据-设备种类编号*/
    @RequestMapping("deviceType/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public Map search_deviceType_by_deviceTypeId(String searchValue, int page, int rows){
        List<DeviceType> pageDeviceType = deviceTypeService.search_deviceType_by_deviceTypeId(searchValue, page, rows);
        int total = deviceTypeService.selectTotalCount_by_deviceTypeId(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageDeviceType);
        return map;
    }

    /*查找数据-设备种类名称*/
    @RequestMapping("deviceType/search_deviceType_by_deviceTypeName")
    @ResponseBody
    public Map search_deviceType_by_deviceTypeName(String searchValue, int page, int rows){
        List<DeviceType> pageDeviceType = deviceTypeService.search_deviceType_by_deviceTypeName(searchValue, page, rows);
        int total = deviceTypeService.selectTotalCount_by_deviceTypeName(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageDeviceType);
        return map;
    }
}
