package com.cskaoyan.controller;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.MaterialConsume;
import com.cskaoyan.bean.Order;
import com.cskaoyan.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cute coder
 * 2019/5/19 13:29
 */
@Controller
@RequestMapping("erp/manufacture")
public class ManufactureController {
    @Autowired
    ManufactureService manufactureService;

    @RequestMapping("/find")
    public String find(){
        return "manufacture_list";
    }

    @RequestMapping("/add")
    public String add() {
        return "manufacture_add";
    }

    @RequestMapping("/edit")
    public String edit() {
        return "manufacture_edit";
    }
    @RequestMapping("/edit_judge")
    @ResponseBody
    public Map editJudge(Manufacture manufacture) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public Map addJudge(Manufacture manufacture) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public Map deleteJudge(Manufacture manufacture) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map findpage(int page, int rows) {
        List<Manufacture> pageManufacture = manufactureService.findPageManufacture(page, rows);
        Long total = manufactureService.selectTotalCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", pageManufacture);
        return map;
    }

    @RequestMapping("insert")
    @ResponseBody
    public Map insert(Manufacture manufacture){
        HashMap<String, Object> map = new HashMap<>();
        int insert = manufactureService.insert(manufacture);
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
        int delete = manufactureService.deleteBatch(ids);
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

    @RequestMapping("update_all")
    @ResponseBody
    public Map updataAll(Manufacture manufacture) {
        HashMap<String, Object> map = new HashMap<>();
        int update=manufactureService.updateByPrimaryKey(manufacture);
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
    @RequestMapping("/get_data")
    @ResponseBody
    public List<Manufacture> getData() {
        List<Manufacture> list=manufactureService.selectAllCustom();
        return list;
    }

    @RequestMapping("/search_manufacture_by_manufactureSn")
    @ResponseBody
    public Map searchManufactureConsumebyManufactureSn(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        long total = manufactureService.selectTotalCountLikeSn(searchValue);
        List<Manufacture> manufactures = manufactureService.selectManufactureLikeManufactureSn(searchValue,page,rows);
        map.put("total",total);
        map.put("rows",manufactures);
        return map;
    }

    @RequestMapping("/search_manufacture_by_manufactureOrderId")
    @ResponseBody
    public Map searchManufactureConsumebyManufactureOrderId(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        long total = manufactureService.selectTotalCountLikeOrderId(searchValue);
        List<Manufacture> manufactures = manufactureService.selectManufactureLikeManufactureOrderId(searchValue,page,rows);
        map.put("total",total);
        map.put("rows",manufactures);
        return map;
    }

    @RequestMapping("/search_manufacture_by_manufactureTechnologyName")
    @ResponseBody
    public Map searchManufacturebyManufactureTechnologyName(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        long total = manufactureService.selectTotalCountLikeTechnologyName(searchValue);
        List<Manufacture> manufactures = manufactureService.selectManufactureLikeManufactureTechnologyName(searchValue,page,rows);
        map.put("total",total);
        map.put("rows",manufactures);
        return map;
    }

}
