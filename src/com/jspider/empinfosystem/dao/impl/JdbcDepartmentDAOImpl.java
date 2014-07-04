package com.jspider.empinfosystem.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspider.empinfosystem.bean.Department;
import com.jspider.empinfosystem.dao.IDepartmentDAO;
import com.jspider.empinfosystem.dbconnection.DBConnection;

/**
 * @author : Santosh Koli
 * @createdDate : Jun 12, 2014
 * @projectName : assignment_1_proj
 */
public class JdbcDepartmentDAOImpl implements IDepartmentDAO {

	private static final String GET_DEPARTMENTS_NAMES = "select unique department_name from bje20.employees";

	@Override
	public List<Department> getAllDepartmentNames() {
		Connection con = null;
		Department dept = null;
		List<Department> deptNameList = new ArrayList<Department>(); 
		try {
			con = DBConnection.getDBConnectionInstance().getConnectionInstance();

			PreparedStatement qryEmpPstmt = con.prepareStatement(GET_DEPARTMENTS_NAMES);

			ResultSet rs = qryEmpPstmt.executeQuery();

			while(rs.next()) {
				dept = new Department();
				dept.setDeptName(rs.getString("department_name"));
				deptNameList.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {}
		return deptNameList;	
	}

}

