package com.cskaoyan.controller;


import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Employee;

import com.cskaoyan.service.EmployeeService;

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
        @RequestMapping("/erp/employee")
        public class EmployeeController {

            @Autowired
            EmployeeService employeeService;

            @RequestMapping("/find")
            @ResponseBody
            public ModelAndView find() {
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("employee_list");
                return modelAndView;
            }

            @RequestMapping("/list")
            @ResponseBody
            public Map getEmployeeList(int page, int rows) {
                List<Employee> list = employeeService.getEmployeeList();
                Map map = new LinkedHashMap();
                map.put("total", list.size());
                map.put("rows", list);
                System.out.println(map);
                return map;
            }

            @RequestMapping("add_judge")
            @ResponseBody
            public String add_judge() {
                return "  ";
            }

            @RequestMapping("add")
            public ModelAndView addEmployee() {
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("employee_add");
                return modelAndView;
            }

            @RequestMapping("insert")
            @ResponseBody
            public Map insertEmployee(Employee employee) {
                HashMap<String, Object> map = new LinkedHashMap<>();
                boolean dataCorrected = confirm(map, employee);
                if (!dataCorrected) {
                    return map;
                }
                int insert = employeeService.insert(employee);
                if (insert != 1) {
                    map.put("status", 100);
                    map.put("msg", "插入失败");
                    map.put("data", null);
                    return map;
                }
                map.put("status", 200);
                map.put("msg", "OK");
                map.put("data", null);
                System.out.println(map);
                return map;
            }

            @RequestMapping("edit_judge")
            @ResponseBody
            public String edit_judge() {
                return "  ";
            }

            @RequestMapping("edit")
            public ModelAndView editEmployee() {
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("employee_edit");
                return modelAndView;
            }

            @RequestMapping("update_all")
            @ResponseBody
            public Map updataAll(Employee employee) {
                HashMap<String, Object> map = new HashMap<>();
                boolean dataCorrected = confirm(map, employee);
                if (!dataCorrected) {
                    return map;
                }
                int update = employeeService.updateByPrimaryKey(employee);
                if (update != 1) {
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
            public Map deleteBatch(String ids) {
                System.out.println(ids);
                HashMap<Object, Object> map = new HashMap<>();
                int delete = employeeService.deleteBatch(ids);
                if (delete != 1) {
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

            @RequestMapping("/search_employee_by_departmentName")
            @ResponseBody
            public Map getMapBySerachAccordDepartmentName(String searchValue) {
                List<Employee> employeeListBySearchDepartmentName = employeeService.getEmployeeListBySearchDepartmentName(searchValue);
                Map map = new LinkedHashMap();
                map.put("total", employeeListBySearchDepartmentName.size());
                map.put("rows", employeeListBySearchDepartmentName);
                return map;
            }

            @RequestMapping("/search_employee_by_employeeName")
            @ResponseBody
            public Map getMapBySerachAccordEmployeeName(String searchValue) {
                List<Employee> employeeListBySearchEmployeeName = employeeService.getEmployeeListBySearchEmployeeName(searchValue);
                Map map = new LinkedHashMap();
                map.put("total", employeeListBySearchEmployeeName.size());
                map.put("rows", employeeListBySearchEmployeeName);
                return map;
            }

            @RequestMapping("/search_employee_by_employeeId")
            @ResponseBody
            public Map getMapBySerachAccordEmployeeId(String searchValue) {
                List<Employee> employeeListBySearchEmployeeID = employeeService.getEmployeeListBySearchEmployeeID(searchValue);
                Map map = new LinkedHashMap();
                map.put("total", employeeListBySearchEmployeeID.size());
                map.put("rows", employeeListBySearchEmployeeID);
                return map;
            }

            private boolean confirm(HashMap<String, Object> map, Employee employee) {

                if (employee.getEmpName().length() > 20) {
                    map.put("status", 100);
                    map.put("msg", "员工名称请限制在20个字符内");
                    map.put("data", null);
                    return false;
                }
                return true;
            }

            @RequestMapping("get_data")
            @ResponseBody
            public List getDepartList() {
                return employeeService.getEmployeeList();
            }
        }
