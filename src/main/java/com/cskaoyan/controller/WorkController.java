package com.cskaoyan.controller;

import com.cskaoyan.bean.Work;
import com.cskaoyan.service.WorkService;
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
 * 2019/5/19 13:26
 */
@Controller
@RequestMapping("/erp/work")
public class WorkController {
    @Autowired
    WorkService workService;

    @RequestMapping("/find")
    public String find(){
        return "work_list";
    }

    @RequestMapping("/add")
    public String add() {
        return "work_add";
    }

    @RequestMapping("/edit")
    public String edit() {
        return "work_edit";
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public Map editJudge(Work work) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public Map addJudge(Work work) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public Map deleteJudge(Work work) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("list")
    @ResponseBody
    public Map findpage(int page, int rows) {
        List<Work> pageWork = workService.findPageWork(page, rows);
        long total = workService.selectTotalCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", pageWork);
        return map;
    }

    @RequestMapping("insert")
    @ResponseBody
    public Map insert(Work work){
        HashMap<String, Object> map = new HashMap<>();
        int insert = workService.insert(work);
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
        int delete = workService.deleteBatch(ids);
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
    public Map updataAll(Work work) {
        HashMap<String, Object> map = new HashMap<>();
        int update=workService.updateByPrimaryKey(work);
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
    public List<Work> getData() {
        List<Work> list=workService.selectAllCustom();
        return list;
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public Work getCustom(@PathVariable("id") String id) {
        Work workById = workService.getWorkById(id);
        return workById;
    }

    @RequestMapping("search_work_by_workId")
    @ResponseBody
    public Map searchById(String searchValue,int page, int rows) {
        List<Work> pageWork = workService.selectLikeId(searchValue,page, rows);
        long total = workService.selectCountLikeId(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", pageWork);
        return map;
    }

    @RequestMapping("/search_work_by_workProduct")
    @ResponseBody
    public Map searchByOrderCustom(String searchValue,int page, int rows) {
        List<Work> pageWork = workService.selectWorkLikeProdName(searchValue,page, rows);
        long total = workService.selectCountLikeProdName(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", pageWork);
        return map;
    }
}
