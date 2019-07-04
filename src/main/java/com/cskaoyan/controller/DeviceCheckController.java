package com.cskaoyan.controller;

import com.cskaoyan.bean.DeviceCheck;
import com.cskaoyan.service.DeviceCheckService;
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
 * @description：设备管理-设备例检
 * @version:0.1$
 */
@Controller
@RequestMapping("/erp")
public class DeviceCheckController {
    @Autowired
    DeviceCheckService deviceCheckService;

    @RequestMapping("device/deviceCheck")
    public String find(){
        return "deviceCheck";//跳转到显示页面
    }

    /*查询数据*/
    @RequestMapping("deviceCheck/list")
    @ResponseBody
    public Map findPage(int page, int rows){
        List<DeviceCheck> pageDeviceCheck = deviceCheckService.findPageDeviceCheck(page, rows);
        int total = deviceCheckService.selectTotalCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageDeviceCheck);
        return map;
    }

    /*新增数据权限判断*/
    @RequestMapping("deviceCheck/add_judge")
    @ResponseBody
    public Map add_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    /*新增数据页面*/
    @RequestMapping("deviceCheck/add")
    public String add(){
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deviceList_add");*/
        return "deviceCheck_add";
    }

    /*新增数据*/
    @RequestMapping("deviceCheck/insert")
    @ResponseBody
    public Map insert(DeviceCheck deviceCheck){
        int status = deviceCheckService.insert(deviceCheck);
        HashMap<String, Object> map = new HashMap<>();
        if(status == 1){
            map.put("status", 200);
        }else {
            map.put("msg", "设备例检信息添加失败！");
        }
        return map;
    }

    /*修改数据权限判断*/
    @RequestMapping("deviceCheck/edit_judge")
    @ResponseBody
    public Map edit_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    /*修改数据页面*/
    @RequestMapping("deviceCheck/edit")
    public String edit(){
        return "deviceCheck_edit";
    }

    /*修改数据*/
    @RequestMapping("deviceCheck/update")
    @ResponseBody
    public Map update(DeviceCheck deviceCheck){
        int status = deviceCheckService.update(deviceCheck);
        HashMap<String, Object> map = new HashMap<>();
        if(status == 1){
            map.put("status", 200);
        }else {
            map.put("msg", "设备例检信息修改失败！");
        }
        return map;
    }

    /*删除数据权限判断*/
    @RequestMapping("deviceCheck/delete_judge")
    @ResponseBody
    public Map delete_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    /*删除数据*/
    @RequestMapping("deviceCheck/delete_batch")
    @ResponseBody
    public Map delete_check_batch(String[] ids){
        List<String> strings = new ArrayList<String>();
        for (String s :
                ids) {
            strings.add(s);
        }
        int status = deviceCheckService.delete_check_batch(strings);
        HashMap<String, Object> map = new HashMap<>();
        if(status != 0){
            map.put("status", 200);
        }
        return map;
    }

    /*查找数据-设备例检编号*/
    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceCheckId")
    @ResponseBody
    public Map search_deviceCheck_by_deviceCheckId(String searchValue, int page, int rows){
        List<DeviceCheck> pageDeviceCheck = deviceCheckService.search_deviceCheck_by_deviceCheckId(searchValue, page, rows);
        int total = deviceCheckService.selectTotalCount_by_deviceCheckId(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageDeviceCheck);
        return map;
    }

    /*查找数据-设备名称*/
    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceName")
    @ResponseBody
    public Map search_deviceCheck_by_deviceName(String searchValue, int page, int rows){
        List<DeviceCheck> pageDeviceCheck = deviceCheckService.search_deviceCheck_by_deviceName(searchValue, page, rows);
        int total = deviceCheckService.selectTotalCount_by_deviceName(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageDeviceCheck);
        return map;
    }
}
