package com.cskaoyan.controller;

import com.cskaoyan.bean.MaterialConsume;
import com.cskaoyan.service.MaterialConsumeService;
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
@RequestMapping("/erp/materialConsume")
public class MaterialConsumeController {

    @Autowired
    MaterialConsumeService materialConsumeService;

    @RequestMapping("/get/{MaterialConsume_id}")
    @ResponseBody
    public List<MaterialConsume> getMaterialConsume(String MaterialConsume_id) {
        List<MaterialConsume> materialConsumeById = materialConsumeService.getMaterialConsumeById(MaterialConsume_id);
        return materialConsumeById;
    }

    @RequestMapping("/find")
    @ResponseBody
    public ModelAndView find() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("materialConsume_list");
        return modelAndView;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map queryMaterialConsume(){
        List<MaterialConsume> list = materialConsumeService.queryMaterialConsume();
        Map map= new LinkedHashMap<>();
        map.put("total",list.size());
        map.put("rows",list);
        return map;
    }

    @RequestMapping("/add")
    public String add() {
        return "materialConsume_add";
    }

    @RequestMapping("/edit")
    public String edit() {
        return "materialConsume_edit";
    }

    //权限管理
    @RequestMapping("/edit_judge")
    @ResponseBody
    public Map editJudge(MaterialConsume materialConsume) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public Map addJudge(MaterialConsume materialConsume) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public Map deleteJudge(MaterialConsume materialConsume) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<MaterialConsume> getData() {
        List<MaterialConsume> list= materialConsumeService.selectAllMaterialConsume();
        return list;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map deleteBatch(String[] ids) {
        HashMap<Object, Object> map = new HashMap<>();
        int delete = materialConsumeService.deleteBatch(ids);
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

    @RequestMapping("/search_materialConsume_by_materialId")
    @ResponseBody
    public Map searchMaterialConsumebyMaterialId(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        long total = materialConsumeService.selectTotalCountLikeMaterialId(searchValue);
        List<MaterialConsume> materials = materialConsumeService.selectMaterialConsumeLikeMaterialId(searchValue,page,rows);
        map.put("total",total);
        map.put("rows",materials);
        return map;
    }

    @RequestMapping("/search_materialConsume_by_consumeId")
    @ResponseBody
    public Map searchMaterialConsumebyConsumeId(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        long total = materialConsumeService.selectTotalCountLikeConsumeId(searchValue);
        List<MaterialConsume> materials = materialConsumeService.selectMaterialConsumeLikeConsumeId(searchValue,page,rows);
        map.put("total",total);
        map.put("rows",materials);
        return map;
    }

    @RequestMapping("search_materialConsume_by_workId")
    @ResponseBody
    public Map searchMaterialConsumebyWorkId(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        long total = materialConsumeService.selectTotalCountLikeWorkId(searchValue);
        List<MaterialConsume> materials = materialConsumeService.selectMaterialConsumeLikeWorkId(searchValue,page,rows);
        map.put("total",total);
        map.put("rows",materials);
        return map;
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public Map updateNote(MaterialConsume materialConsume) {
        HashMap<String, Object> map = new HashMap<>();
        int update = materialConsumeService.updateByPrimaryKey(materialConsume);
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
    public Map update(MaterialConsume materialConsume) {
        HashMap<String, Object> map = new HashMap<>();
        int update = materialConsumeService.updateAllByPrimaryKey(materialConsume);
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
    public Map insert(MaterialConsume materialConsume) {
        HashMap<String, Object> map = new HashMap<>();
        int insert = materialConsumeService.insertMaterialConsume(materialConsume);
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
