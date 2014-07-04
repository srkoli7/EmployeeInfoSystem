package com.jspider.empinfosystem.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.jspider.empinfosystem.bean.Employee;
import com.jspider.empinfosystem.dao.IEmployeeDAO;
import com.jspider.empinfosystem.dbconnection.DBConnection;


/**
 * @author : Santosh Koli
 * @createdDate : Jun 11, 2014
 * @projectName : assignment_1_proj
 */
public class JdbcEmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMPLOYEE = "select first_name,last_name,salary,department_name from bje20.employees where employee_id = ?";  

	private static final String GET_EMPLOYEES_BY_DEPT = "select employee_id,first_name,last_name,salary from bje20.employees where department_name = ?";

	private static final String GET_EMPLOYEES_BY_SALARY_RANGE = "select employee_id,first_name,last_name,salary,department_name from bje20.employees where salary between ? and ?";

	@Override
	public Employee getEmployee(int empID) {
		Connection con = null;
		Employee emp = null;
		try {
			con = DBConnection.getDBConnectionInstance().getConnectionInstance();

			PreparedStatement qryEmpPstmt = con.prepareStatement(GET_EMPLOYEE);

			qryEmpPstmt.setInt(1, empID);

			ResultSet rs = qryEmpPstmt.executeQuery();

			if(rs.next()) {
				emp = new Employee();
				emp.setEmpDept(rs.getString("department_name"));
				emp.setEmpFirstName(rs.getString("first_name"));
				emp.setEmpLastName(rs.getString("last_name"));
				emp.setEmpID(empID);
				emp.setEmpSal(rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {}
		return emp;
	}

	@Override
	public List<Employee> getEmployeesBySalaryRange(double minSalary, double maxSalary) {
		List<Employee> empList = new ArrayList<Employee>();
		Connection con = null;
		Employee emp = null;
		try {
			con = DBConnection.getDBConnectionInstance().getConnectionInstance();

			PreparedStatement qryEmpPstmt = con.prepareStatement(GET_EMPLOYEES_BY_SALARY_RANGE);

			qryEmpPstmt.setDouble(1, minSalary);
			qryEmpPstmt.setDouble(2, maxSalary);

			ResultSet rs = qryEmpPstmt.executeQuery();

			while(rs.next()) {
				emp = new Employee();
				emp.setEmpDept(rs.getString("department_name"));
				emp.setEmpFirstName(rs.getString("first_name"));
				emp.setEmpLastName(rs.getString("last_name"));
				emp.setEmpID(rs.getInt("employee_id"));
				emp.setEmpSal(rs.getDouble("salary"));
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {}
		return empList;
	}

	@Override
	public List<Employee> getEmployeesByDept(String empDept) {
		List<Employee> empList = new ArrayList<Employee>();
		Connection con = null;
		Employee emp = null;
		try {
			con = DBConnection.getDBConnectionInstance().getConnectionInstance();

			PreparedStatement qryEmpPstmt = con.prepareStatement(GET_EMPLOYEES_BY_DEPT);

			qryEmpPstmt.setString(1, empDept);

			ResultSet rs = qryEmpPstmt.executeQuery();

			while(rs.next()) {
				emp = new Employee();
				emp.setEmpDept(empDept);
				emp.setEmpFirstName(rs.getString("first_name"));
				emp.setEmpLastName(rs.getString("last_name"));
				emp.setEmpID(rs.getInt("employee_id"));
				emp.setEmpSal(rs.getDouble("salary"));
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {}
		return empList;
	}

}

