package com.cskaoyan.controller;

import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.service.DeviceFaultService;
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
 * @description：设备管理-设备故障
 * @version:0.1$
 */
@Controller
@RequestMapping("/erp")
public class DeviceFaultController {
    @Autowired
    DeviceFaultService deviceFaultService;

    @RequestMapping("device/deviceFault")
    public String find(){
        return "deviceFault";//跳转到显示页面
    }

    /*查询数据*/
    @RequestMapping("deviceFault/list")
    @ResponseBody
    public Map findPage(int page, int rows){
        List<DeviceFault> pageDeviceFault = deviceFaultService.findPageDeviceFault(page, rows);
        int total = deviceFaultService.selectTotalCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageDeviceFault);
        return map;
    }

    /*新增数据权限判断*/
    @RequestMapping("deviceFault/add_judge")
    @ResponseBody
    public Map add_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    /*新增数据页面*/
    @RequestMapping("deviceFault/add")
    public String add(){
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deviceList_add");*/
        return "deviceFault_add";
    }

    /*新增数据*/
    @RequestMapping("deviceFault/insert")
    @ResponseBody
    public Map insert(DeviceFault deviceFault){
        int status = deviceFaultService.insert(deviceFault);
        HashMap<String, Object> map = new HashMap<>();
        if(status == 1){
            map.put("status", 200);
        }else {
            map.put("msg", "设备故障信息添加失败！");
        }
        return map;
    }

    /*修改数据权限判断*/
    @RequestMapping("deviceFault/edit_judge")
    @ResponseBody
    public Map edit_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    /*修改数据页面*/
    @RequestMapping("deviceFault/edit")
    public String edit(){
        return "deviceFault_edit";
    }

    /*修改数据*/
    @RequestMapping("deviceFault/update")
    @ResponseBody
    public Map update(DeviceFault deviceFault){
        int status = deviceFaultService.update(deviceFault);
        HashMap<String, Object> map = new HashMap<>();
        if(status == 1){
            map.put("status", 200);
        }else {
            map.put("msg", "设备故障信息修改失败！");
        }
        return map;
    }

    /*删除数据权限判断*/
    @RequestMapping("deviceFault/delete_judge")
    @ResponseBody
    public Map delete_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    /*删除数据*/
    @RequestMapping("deviceFault/delete_batch")
    @ResponseBody
    public Map delete_fault_batch(String[] ids){
        List<String> strings = new ArrayList<String>();
        for (String s :
                ids) {
            strings.add(s);
        }
        int status = deviceFaultService.delete_fault_batch(strings);
        HashMap<String, Object> map = new HashMap<>();
        if(status != 0){
            map.put("status", 200);
        }
        return map;
    }
    /*查找数据-设备故障编号*/
    @RequestMapping("deviceFault/search_deviceFault_by_deviceFaultId")
    @ResponseBody
    public Map search_deviceFault_by_deviceFaultId(String searchValue, int page, int rows){
        List<DeviceFault> pageDeviceFault = deviceFaultService.search_deviceFault_by_deviceFaultId(searchValue, page, rows);
        int total = deviceFaultService.selectTotalCount_by_deviceFaultId(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageDeviceFault);
        return map;
    }

    /*查找数据-设备名称*/
    @RequestMapping("deviceFault/search_deviceFault_by_deviceName")
    @ResponseBody
    public Map search_deviceFault_by_deviceName(String searchValue, int page, int rows){
        List<DeviceFault> pageDeviceFault = deviceFaultService.search_deviceFault_by_deviceName(searchValue, page, rows);
        int total = deviceFaultService.selectTotalCount_by_deviceName(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageDeviceFault);
        return map;
    }
}
