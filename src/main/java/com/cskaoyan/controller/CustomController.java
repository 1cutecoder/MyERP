package com.cskaoyan.controller;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cute coder
 * 2019/5/18 11:09
 */
@Controller
@RequestMapping("/erp/custom")
public class CustomController {

    @Autowired
    CustomService customService;
    @RequestMapping("/find")
    public String find(){
        return "custom_list";
    }

    @RequestMapping("/add")
    public String add() {
        return "custom_add";
    }

    @RequestMapping("/edit")
    public String edit() {
        return "custom_edit";
    }
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Custom getCustom(@PathVariable("id") String id) {
        Custom customById = customService.getCustomById(id);
        return customById;
    }

    //权限管理
    @RequestMapping(value = {"/edit_judge","/add_judge","/delete_judge"})
    @ResponseBody
    public Map Judge() {
        return null;
    }
    @RequestMapping("/get_data")
    @ResponseBody
    public List<Custom> getData() {
        List<Custom> list=customService.selectAllCustom();
        return list;
    }
    @RequestMapping("list")
    @ResponseBody
    public Map findpage(int page, int rows) {
        List<Custom> pageCustom = customService.findPageCustom(page, rows);
        Long total = customService.selectTotalCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", pageCustom);
        return map;
    }
    @RequestMapping("update_all")
    @ResponseBody
    public Map updataAll(Custom custom) {
        HashMap<String, Object> map = new HashMap<>();
        boolean dataCorrected = confirm(map, custom);
        if (!dataCorrected) {
            return map;
        }
        int update=customService.updateByPrimaryKey(custom);
        if (update!=1) {
            map.put("status", 100);
            map.put("msg", "修改失败");
            map.put("data", null);
            return map;
        }
        map.put("status", 200);
        map.put("msg", "OK");
        map.put("data", null);
        return map;
    }

    @RequestMapping("insert")
    @ResponseBody
    public Map insert(Custom custom){
        HashMap<String, Object> map = new HashMap<>();
        boolean dataCorrected = confirm(map, custom);
        if (!dataCorrected) {
            return map;
        }
        int insert = customService.insert(custom);
        if (insert!=1) {
            map.put("status", 100);
            map.put("msg", "添加失败");
            map.put("data", null);
            return map;
        }
        map.put("status", 200);
        map.put("msg", "OK");
        map.put("data", null);
        return map;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map deleteBatch(String[] ids) {
        HashMap<Object, Object> map = new HashMap<>();
        int delete = customService.deleteBatch(ids);
        if (delete!= ids.length) {
            map.put("status", 100);
            map.put("msg", "删除失败");
            map.put("data", null);
            return null;
        }
        map.put("status", 200);
        map.put("msg", "OK");
        map.put("data", null);
        return map;
    }

    @RequestMapping("/search_custom_by_customId")
    @ResponseBody
    public Map searchCustombyCustomId(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        long total =customService.selectTotalCountLikeId(searchValue);
        List<Custom> customs = customService.selectCustomLikeId(searchValue,page,rows);
        map.put("total",total);
        map.put("rows",customs);
        return map;

    }
    @RequestMapping("/search_custom_by_customName")
    @ResponseBody
    public Map searchCustombyCustomName(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        long total =customService.selectTotalCountLikeCustomName(searchValue);
        List<Custom> customs = customService.selectCustomLikeCustomName(searchValue,page,rows);
        map.put("total",total);
        map.put("rows",customs);
        return map;

    }
    private boolean confirm(HashMap<String, Object> map, Custom custom) {

        if (custom.getCustomName().length() > 20) {
            map.put("status", 100);
            map.put("msg", "客户名称请限制在20个字符内");
            map.put("data", null);
            return false;
        }

        if (!custom.getEmail().matches("^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$")){
            map.put("status", 100);
            map.put("msg", "格式不符");
            map.put("data", null);
            return false;
        }

        if (custom.getOwnerName().length() > 20) {
            map.put("status", 100);
            map.put("msg", "经理姓名请限制在20个字符内");
            map.put("data", null);
            return false;
        }
        if (custom.getFax().length() > 20) {
            map.put("status", 100);
            map.put("msg", "传真请限制在20个字符内");
            map.put("data", null);
            return false;

        }
        if (custom.getOwnerTel().length() > 20) {
            map.put("status", 100);
            map.put("msg", "电话请限制在20个字符内");
            map.put("data", null);
            return false;
        }
        return true;
    }
}
