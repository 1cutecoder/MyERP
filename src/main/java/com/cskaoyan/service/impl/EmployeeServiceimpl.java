package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.EmployeeExample;
import com.cskaoyan.mapper.EmployeeMapper;
import com.cskaoyan.service.EmployeeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceimpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public List<Employee> getEmployeeList() {
        EmployeeExample employeeExample=new EmployeeExample();
        List<Employee> list = employeeMapper.selectByExample(employeeExample);
        System.out.println(list);
        return list;
    }

    @Override
    public int insert(Employee employee) {
        int insert = employeeMapper.insert(employee);
        return insert;
    }

    @Override
    public int updateByPrimaryKey(Employee employee) {
        int i = employeeMapper.updateByPrimaryKey(employee);
        return i;
    }

    @Override
    public int deleteBatch(String empId) {
        int i = employeeMapper.deleteByPrimaryKey(empId);
        return i;
    }

    @Override
    public List<Employee> getEmployeeListBySearchDepartmentName(String searchValue) {
        List<Employee> list = employeeMapper.selectBySearchDepartmentName(searchValue);
        return list;
    }

    @Override
    public List<Employee> getEmployeeListBySearchEmployeeName(String searchValue) {
        List<Employee> list = employeeMapper.selectBySearchEmployeeName(searchValue);
        return list;
    }

    @Override
    public List<Employee> getEmployeeListBySearchEmployeeID(String searchValue) {
        List<Employee> list = employeeMapper.selectBySearchEmployeeId(searchValue);
        return list;
    }


}
