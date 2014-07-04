package com.jspider.empinfosystem.dao;

import java.util.List;

import com.jspider.empinfosystem.bean.Employee;

/**
 * @author : Santosh Koli
 * @createdDate : Jun 11, 2014
 * @projectName : assignment_1_proj
 */
public interface IEmployeeDAO {
	public abstract Employee getEmployee(int empID);
	public abstract List<Employee> getEmployeesBySalaryRange(double minSalary, double maxSalary);
	public abstract List<Employee> getEmployeesByDept(String empDept);
}

