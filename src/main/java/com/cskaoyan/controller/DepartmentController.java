package com.cskaoyan.controller;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.service.DepartmentService;
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
@RequestMapping("/erp/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @RequestMapping("/find")
    @ResponseBody
    public ModelAndView find(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("department_list");
        return modelAndView;
    }
    @RequestMapping("/list")
    @ResponseBody
    public Map getEmployeeList(){
        List<Department> list=departmentService.getDepartmentList();
        Map map = new LinkedHashMap();
        map.put("total",list.size());
        map.put("rows",list);
        System.out.println(map);
        return map;
    }
    @RequestMapping("get_data")
    @ResponseBody
    public List getDepartList(){
        return departmentService.getDepartmentList();
    }
    @RequestMapping("add_judge")
    @ResponseBody
    public String add_judge(){
        return "  ";
    }
    @RequestMapping("add")
    public ModelAndView addDepartment(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("department_add");
        return modelAndView;
    }
    @RequestMapping("insert")
    @ResponseBody
    public Map insertEmployee(Department department){
        HashMap<String, Object> map = new LinkedHashMap<>();
        boolean dataCorrected = confirm(map,department);
        if (!dataCorrected) {
            return map;
        }
        int insert = departmentService.insert(department);
        if (insert!=1) {
            map.put("status", 100);
            map.put("msg", "插入失败");
            map.put("data", null);
            return map;
        }
        map.put("status",200);
        map.put("msg", "OK");
        map.put("data", null);
        System.out.println(map);
        return map;
    }


    @RequestMapping("edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "  ";
    }
    @RequestMapping("edit")
    public ModelAndView editEmployee(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("department_edit");
        return modelAndView;
    }
    @RequestMapping("update_all")
    @ResponseBody
    public Map updataAll(Department department) {
        HashMap<String, Object> map = new HashMap<>();
        boolean dataCorrected = confirm(map, department);
        if (!dataCorrected) {
            return map;
        }
        int update=departmentService.updateByPrimaryKey(department);
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
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteJudge(Employee employee) {
        return "  ";
    }
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map deleteBatch(String  ids) {
        System.out.println(ids);
        HashMap<Object, Object> map = new HashMap<>();
        int delete = departmentService.deleteBatch(ids);
        if (delete!= 1) {
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
    @RequestMapping("/search_department_by_departmentId")
    @ResponseBody
    public Map getMapBySerachAccordDepartId(String searchValue){
        List<Department> departListBySearchDepartmentID = departmentService.getDepartListBySearchDepartmentID(searchValue);
        Map map = new LinkedHashMap();
        map.put("total",departListBySearchDepartmentID.size());
        map.put("rows",departListBySearchDepartmentID);
        return map;
    }
    @RequestMapping("/search_department_by_departmentName")
    @ResponseBody
    public Map getMapBySerachAccordDepartName(String searchValue){
        List<Department> departListBySearchDepartmentName = departmentService.getDepartListBySearchDepartmentName(searchValue);
        Map map = new LinkedHashMap();
        map.put("total",departListBySearchDepartmentName.size());
        map.put("rows",departListBySearchDepartmentName);
        return map;
    }
    @RequestMapping("/update_note")
    @ResponseBody
    public Map updateNote(String departmentId,String note) {
        System.out.println(departmentId);
        System.out.println(note);
        HashMap<Object, Object> map = new HashMap<>();
        int update= departmentService.updateNoteById(departmentId,note);
        if (update!= 1) {
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
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Department getDepartment(@PathVariable("id") String id){
        Department departmentById = departmentService.getDepartmentById(id);
        return departmentById;
    }
    private boolean confirm(HashMap<String, Object> map, Department department) {

        if (department.getDepartmentName().length() > 20) {
            map.put("status", 100);
            map.put("msg", "部门名称请限制在20个字符内");
            map.put("data", null);
            return false;
        }
        return true;
    }
}


