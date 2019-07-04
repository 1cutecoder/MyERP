package com.cskaoyan.controller;

import com.cskaoyan.bean.MaterialReceive;
import com.cskaoyan.service.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/erp/materialReceive")
public class MaterialReceiveController {

    @Autowired
    MaterialReceiveService materialReceiveService;

    @RequestMapping("/get/{MaterialReceive_id}")
    @ResponseBody
    public List<MaterialReceive> getMaterialReceive(String MaterialReceive_id) {
        List<MaterialReceive> materialReceiveById = materialReceiveService.getMaterialReceiveById(MaterialReceive_id);
        return materialReceiveById;
    }



    @RequestMapping("/find")
    @ResponseBody
    public ModelAndView find() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("materialReceive_list");
        return modelAndView;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map queryMaterialReceive(){
        List<MaterialReceive> list = materialReceiveService.queryMaterialReceive();
        Map map= new LinkedHashMap<>();
        map.put("total",list.size());
        map.put("rows",list);
        return map;
    }

    @RequestMapping("/add")
    public String add() {
        return "materialReceive_add";
    }

    @RequestMapping("/edit")
    public String edit() {
        return "materialReceive_edit";
    }

    //权限管理
    @RequestMapping("/edit_judge")
    @ResponseBody
    public Map editJudge(MaterialReceive materialReceive) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public Map addJudge(MaterialReceive materialReceive) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public Map deleteJudge(MaterialReceive materialReceive) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<MaterialReceive> getData() {
        List<MaterialReceive> list=materialReceiveService.selectAllMaterialReceive();
        return list;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map deleteBatch(String[] ids) {
        HashMap<Object, Object> map = new HashMap<>();
        int delete = materialReceiveService.deleteBatch(ids);
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

    @RequestMapping("/search_materialReceive_by_materialId")
    @ResponseBody
    public Map searchMaterialReceivebyMaterialId(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        long total = materialReceiveService.selectTotalCountLikeMaterialId(searchValue);
        List<MaterialReceive> materials = materialReceiveService.selectMaterialReceiveLikeMaterialId(searchValue,page,rows);
        map.put("total",total);
        map.put("rows",materials);
        return map;
    }

    @RequestMapping("/search_materialReceive_by_receiveId")
    @ResponseBody
    public Map searchMaterialReceivebyReceiveId(String searchValue,int page,int rows) {
        HashMap<String, Object> map = new HashMap<>();
        long total = materialReceiveService.selectTotalCountLikeReceiveId(searchValue);
        List<MaterialReceive> materials = materialReceiveService.selectMaterialReceiveLikeReceiveId(searchValue, page, rows);
        map.put("total", total);
        map.put("rows", materials);
        return map;
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public Map updateNote(MaterialReceive materialReceive) {
        HashMap<String, Object> map = new HashMap<>();
        int update = materialReceiveService.updateNoteByPrimaryKey(materialReceive);
        if (update != 1) {
            map.put("status", 100);
            map.put("msg", "修改失败");
            map.put("data", null);
        } else {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public Map update(MaterialReceive materialReceive) {
        HashMap<String, Object> map = new HashMap<>();
        int update = materialReceiveService.updateAllByPrimaryKey(materialReceive);
        if (update != 1) {
            map.put("status", 100);
            map.put("msg", "修改失败");
            map.put("data", null);
        } else {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(MaterialReceive materialReceive) {
        HashMap<String, Object> map = new HashMap<>();
        int insert = materialReceiveService.insertMaterialReceive(materialReceive);
        if (insert != 1) {
            map.put("status", 100);
            map.put("msg", "修改失败");
            map.put("data", null);
        } else {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }
}
