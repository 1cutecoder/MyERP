package com.cskaoyan.service;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Employee;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartmentList();

    int insert(Department department);

    int updateByPrimaryKey(Department department);

    int deleteBatch(String ids);

    List<Department> getDepartListBySearchDepartmentID(String searchValue);

    List<Department> getDepartListBySearchDepartmentName(String searchValue);

    int updateNoteById(String departmentId, String note);

    Department getDepartmentById(String id);
}
