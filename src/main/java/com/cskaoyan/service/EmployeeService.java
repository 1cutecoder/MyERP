package com.cskaoyan.service;

import com.cskaoyan.bean.Employee;

import java.util.List;

public interface EmployeeService {




 List<Employee> getEmployeeList();

 int insert(Employee employee);

 int updateByPrimaryKey(Employee employee);

 int deleteBatch(String empId);

 List<Employee> getEmployeeListBySearchDepartmentName(String searchValue);

 List<Employee> getEmployeeListBySearchEmployeeName(String searchValue);


 List<Employee> getEmployeeListBySearchEmployeeID(String searchValue);
}
