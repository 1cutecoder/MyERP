package com.cskaoyan.controller;

import com.cskaoyan.bean.DeviceMaintain;
import com.cskaoyan.service.DeviceMaintainService;
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
 * @description：设备管理-设备维修
 * @version:0.1$
 */
@Controller
@RequestMapping("/erp")
public class DeviceMaintainController {
    @Autowired
    DeviceMaintainService deviceMaintainService;

    @RequestMapping("device/deviceMaintain")
    public String find(){
        return "deviceMaintain";//跳转到显示页面
    }

    /*查询数据*/
    @RequestMapping("deviceMaintain/list")
    @ResponseBody
    public Map findPage(int page, int rows){
        List<DeviceMaintain> pageDeviceMaintain = deviceMaintainService.findPageDeviceMaintain(page, rows);
        int total = deviceMaintainService.selectTotalCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageDeviceMaintain);
        return map;
    }

    /*新增数据权限判断*/
    @RequestMapping("deviceMaintain/add_judge")
    @ResponseBody
    public Map add_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    /*新增数据页面*/
    @RequestMapping("deviceMaintain/add")
    public String add(){
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deviceList_add");*/
        return "deviceMaintain_add";
    }

    /*新增数据*/
    @RequestMapping("deviceMaintain/insert")
    @ResponseBody
    public Map insert(DeviceMaintain deviceMaintain){
        int status = deviceMaintainService.insert(deviceMaintain);
        HashMap<String, Object> map = new HashMap<>();
        if(status == 1){
            map.put("status", 200);
        }else {
            map.put("msg", "设备维修信息添加失败！");
        }
        return map;
    }

    /*修改数据权限判断*/
    @RequestMapping("deviceMaintain/edit_judge")
    @ResponseBody
    public Map edit_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    /*修改数据页面*/
    @RequestMapping("deviceMaintain/edit")
    public String edit(){
        return "deviceMaintain_edit";
    }

    /*修改数据*/
    @RequestMapping("deviceMaintain/update")
    @ResponseBody
    public Map update(DeviceMaintain deviceMaintain){
        int status = deviceMaintainService.update(deviceMaintain);
        HashMap<String, Object> map = new HashMap<>();
        if(status == 1){
            map.put("status", 200);
        }else {
            map.put("msg", "设备维修信息修改失败！");
        }
        return map;
    }

    /*删除数据权限判断*/
    @RequestMapping("deviceMaintain/delete_judge")
    @ResponseBody
    public Map delete_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    /*删除数据*/
    @RequestMapping("deviceMaintain/delete_batch")
    @ResponseBody
    public Map delete_maintain_batch(String[] ids){
        List<String> strings = new ArrayList<String>();
        for (String s :
                ids) {
            strings.add(s);
        }
        int status = deviceMaintainService.delete_maintain_batch(strings);
        HashMap<String, Object> map = new HashMap<>();
        if(status != 0){
            map.put("status", 200);
        }
        return map;
    }

    /*查找数据-设备维修编号*/
    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public Map search_deviceMaintain_by_deviceMaintainId(String searchValue, int page, int rows){
        List<DeviceMaintain> pageDeviceMaintain = deviceMaintainService.search_deviceMaintain_by_deviceMaintainId(searchValue, page, rows);
        int total = deviceMaintainService.selectTotalCount_by_deviceMaintainId(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageDeviceMaintain);
        return map;
    }

    /*查找数据-故障编号*/
    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public Map search_deviceMaintain_by_deviceFaultId(String searchValue, int page, int rows){
        List<DeviceMaintain> pageDeviceMaintain = deviceMaintainService.search_deviceMaintain_by_deviceFaultId(searchValue, page, rows);
        int total = deviceMaintainService.selectTotalCount_by_deviceFaultId(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageDeviceMaintain);
        return map;
    }
}
