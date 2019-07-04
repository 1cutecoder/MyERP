package com.cskaoyan.controller;

import com.cskaoyan.bean.Device;
import com.cskaoyan.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author：陈绍正
 * @date：Created in 2019/5/19 15:59
 * @description：设备管理-设备台账
 * @version:0.1$
 */

@Controller
@RequestMapping("/erp")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @RequestMapping("device/deviceList")
    public String find(){
        return "deviceList";//跳转到显示页面
    }

    /*查询数据*/
    @RequestMapping("deviceList/list")
    @ResponseBody
    public Map findPage(int page, int rows){
        List<Device> pageDevice = deviceService.findPageDevice(page, rows);
        int total = deviceService.selectTotalCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageDevice);
        return map;
    }

    /*新增数据权限判断*/
    @RequestMapping("deviceList/add_judge")
    @ResponseBody
    public Map add_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    /*新增数据页面*/
    @RequestMapping("deviceList/add")
    public String add(){
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deviceList_add");*/
        return "deviceList_add";
    }

    /*新增数据*/
    @RequestMapping("deviceList/insert")
    @ResponseBody
    public Map insert(Device device){
        switch (device.getDeviceStatusId()){
            case "1" : device.setDeviceStatus("良好");break;
            case "2" : device.setDeviceStatus("故障");break;
            case "3" : device.setDeviceStatus("维修");break;
            case "4" : device.setDeviceStatus("报废");break;
        }
        int status = deviceService.insert(device);
        HashMap<String, Object> map = new HashMap<>();
        if(status == 1){
            map.put("status", 200);
        }else {
            map.put("msg", "设备添加失败！");
        }
        return map;
    }

    /*修改数据权限判断*/
    @RequestMapping("deviceList/edit_judge")
    @ResponseBody
    public Map edit_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    /*修改数据页面*/
    @RequestMapping("deviceList/edit")
    public String edit(){
        return "deviceList_edit";
    }

    /*修改数据*/
    @RequestMapping("deviceList/update")
    @ResponseBody
    public Map update(Device device){
        switch (device.getDeviceStatusId()){
            case "1" : device.setDeviceStatus("良好");break;
            case "2" : device.setDeviceStatus("故障");break;
            case "3" : device.setDeviceStatus("维修");break;
            case "4" : device.setDeviceStatus("报废");break;
            default: ;
        }
        int status = deviceService.update(device);
        HashMap<String, Object> map = new HashMap<>();
        if(status == 1){
            map.put("status", 200);
        }else {
            map.put("msg", "设备信息修改失败！");
        }
        return map;
    }

    /*删除数据权限判断*/
    @RequestMapping("deviceList/delete_judge")
    @ResponseBody
    public Map delete_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    /*删除数据*/
    @RequestMapping("deviceList/delete_batch")
    @ResponseBody
    public Map delete_batch(String[] ids){
        List<String> strings = new ArrayList<String>();
        for (String s :
                ids) {
            strings.add(s);
        }
        int status = deviceService.delete_batch(strings);
        HashMap<String, Object> map = new HashMap<>();
        if(status != 0){
            map.put("status", 200);
        }
        return map;
    }

    /*查找数据-设备编号*/
    @RequestMapping("deviceList/search_device_by_deviceId")
    @ResponseBody
    public Map search_device_by_deviceId(String searchValue, int page, int rows){
        List<Device> pageDevice = deviceService.search_device_by_deviceId(searchValue, page, rows);
        int total = deviceService.selectTotalCount_by_deviceId(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageDevice);
        return map;
    }

    /*查找数据-设备名称*/
    @RequestMapping("deviceList/search_device_by_deviceName")
    @ResponseBody
    public Map search_device_by_deviceName(String searchValue, int page, int rows){
        List<Device> pageDevice = deviceService.search_device_by_deviceName(searchValue, page, rows);
        int total = deviceService.selectTotalCount_by_deviceName(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageDevice);
        return map;
    }

    /*查找数据-设备种类名称*/
    @RequestMapping("deviceList/search_device_by_deviceTypeName")
    @ResponseBody
    public Map search_device_by_deviceTypeName(String searchValue, int page, int rows){
        List<Device> pageDevice = deviceService.search_device_by_deviceTypeName(searchValue, page, rows);
        int total = deviceService.selectTotalCount_by_deviceTypeName(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageDevice);
        return map;
    }
}
