package com.cskaoyan.controller;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.Task;
import com.cskaoyan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cute coder
 * 2019/5/19 13:30
 */
@Controller
@RequestMapping("/erp/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @RequestMapping("/find")
    public String find(){
        return "task_list";
    }

    @RequestMapping("/add")
    public String add() {
        return "task_add";
    }
    @RequestMapping("/edit")
    public String edit() {
        return "task_edit";
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public Map editJudge(Task task) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public Map addJudge(Task task) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public Map deleteJudge(Task task) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("list")
    @ResponseBody
    public Map findpage(int page, int rows) {
        List<Task> pageTask = taskService.findPageTask(page, rows);
        long total = taskService.selectTotalCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", pageTask);
        return map;
    }
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(Task task) {
        HashMap<String, Object> map = new HashMap<>();
        int insert = taskService.insert(task);
        if (insert != 1) {
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
        int delete = taskService.deleteBatch(ids);
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
    public Map updataAll(Task task) {
        HashMap<String, Object> map = new HashMap<>();
        int update=taskService.updateByPrimaryKey(task);
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

    @RequestMapping("/search_task_by_taskId")
    @ResponseBody
    public Map searchTaskbyTaskId(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        long total = taskService.selectTotalCountLikeTaskId(searchValue);
        List<Task> tasks = taskService.selectTaskLikeTaskId(searchValue,page,rows);
        map.put("total",total);
        map.put("rows",tasks);
        return map;
    }

    @RequestMapping("/search_task_by_taskWorkId")
    @ResponseBody
    public Map searchTaskbyWorkId(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        long total = taskService.selectTotalCountLikeWorkId(searchValue);
        List<Task> tasks = taskService.selectTaskLikeWorkId(searchValue,page,rows);
        map.put("total",total);
        map.put("rows",tasks);
        return map;
    }

    @RequestMapping("/search_task_by_taskManufactureSn")
    @ResponseBody
    public Map searchTaskbyManuSn(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        long total = taskService.selectTotalCountLikeManuSn(searchValue);
        List<Task> tasks = taskService.selectTaskLikeManuSn(searchValue,page,rows);
        map.put("total",total);
        map.put("rows",tasks);
        return map;
    }

}
