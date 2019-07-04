package com.cskaoyan.controller;

import com.cskaoyan.bean.Material;
import com.cskaoyan.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/erp/material")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @RequestMapping("/get/{id}")
    @ResponseBody
    public Material getMaterial(@PathVariable("id")String id){
        Material materialById = materialService.getMaterialById(id);
        return materialById;
    }

    @RequestMapping("/find")
    @ResponseBody
    public ModelAndView find() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("material_list");
        return modelAndView;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map  queryMaterial(){
        List<Material> list = materialService.queryMaterial();
        Map map= new LinkedHashMap<>();
        map.put("total",list.size());
        map.put("rows",list);
        return map;
    }

    @RequestMapping("/add")
    public String add() {
        return "material_add";
    }

    @RequestMapping("/edit")
    public String edit() {
        return "material_edit";
    }

    //权限管理
    @RequestMapping("/edit_judge")
    @ResponseBody
    public Map editJudge(Material material) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public Map addJudge(Material material) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public Map deleteJudge(Material material) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Material> getData() {
        List<Material> list= materialService.selectAllMaterial();
        return list;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map deleteBatch(String[] ids) {
        HashMap<Object, Object> map = new HashMap<>();
        int delete = materialService.deleteBatch(ids);
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

    @RequestMapping("/search_material_by_materialId")
    @ResponseBody
    public Map searchMaterialbyMaterialId(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        long total = materialService.selectTotalCountLikeId(searchValue);
        List<Material> materials = materialService.selectMaterialLikeId(searchValue,page,rows);
        map.put("total",total);
        map.put("rows",materials);
        return map;
    }

    @RequestMapping("/search_material_by_materialType")
    @ResponseBody
    public Map searchMaterialbyMaterialType(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        long total = materialService.selectTotalCountLikeType(searchValue);
        List<Material> materials = materialService.selectMaterialLikeType(searchValue,page,rows);
        map.put("total",total);
        map.put("rows",materials);
        return map;
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public Map updateNote(Material material) {
        HashMap<String, Object> map = new HashMap<>();
        int update = materialService.updateNoteByPrimaryKey(material);
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
    public Map update(Material material) {
        HashMap<String, Object> map = new HashMap<>();
        int update = materialService.updateAllByPrimaryKey(material);
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
    public Map insert(Material material) {
        HashMap<String, Object> map = new HashMap<>();
        int insert = materialService.insertMaterial(material);
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
