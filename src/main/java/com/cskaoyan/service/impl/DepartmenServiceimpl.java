package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.DepartmentExample;
import com.cskaoyan.mapper.DepartmentMapper;
import com.cskaoyan.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmenServiceimpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public List<Department> getDepartmentList() {
        DepartmentExample example = new DepartmentExample();
        List<Department> departments = departmentMapper.selectByExample(example);
        return departments;
    }

    @Override
    public int insert(Department department) {
        int insert = departmentMapper.insert(department);
        return insert;
    }

    @Override
    public int updateByPrimaryKey(Department department) {
        int i = departmentMapper.updateByPrimaryKey(department);
        return i;
    }

    @Override
    public int deleteBatch(String ids) {
        int i = departmentMapper.deleteByPrimaryKey(ids);
        return i;
    }

    @Override
    public List<Department> getDepartListBySearchDepartmentID(String searchValue) {
        List<Department> departments = departmentMapper.selectBySearchDepartmentId(searchValue);
        return departments;
    }

    @Override
    public List<Department> getDepartListBySearchDepartmentName(String searchValue) {
        List<Department> departments = departmentMapper.selectBySearchDepartmentName(searchValue);
        return departments;
    }

    @Override
    public int updateNoteById(String departmentId, String note) {
        int i = departmentMapper.updateNoteById(departmentId, note);
        return i;
    }

    @Override
    public Department getDepartmentById(String id) {
        Department department = departmentMapper.selectByDepartmentById(id);
        return department;
    }
}
