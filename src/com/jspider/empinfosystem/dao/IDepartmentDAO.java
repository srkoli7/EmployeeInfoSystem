package com.jspider.empinfosystem.dao;

import java.util.List;

import com.jspider.empinfosystem.bean.Department;

/**
 * @author : Santosh Koli
 * @createdDate : Jun 12, 2014
 * @projectName : assignment_1_proj
 */
public interface IDepartmentDAO {
	List<Department> getAllDepartmentNames();
}

