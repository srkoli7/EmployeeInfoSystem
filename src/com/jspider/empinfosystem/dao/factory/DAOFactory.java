package com.jspider.empinfosystem.dao.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.jspider.empinfosystem.dao.IDepartmentDAO;
import com.jspider.empinfosystem.dao.impl.DepartmentDAOImpl;
import com.jspider.empinfosystem.dao.impl.EmployeeDAOImpl;

public class DAOFactory {
	private String DAO_FACTORY_CONFIG_FILE = "config/daofactoryconfig.properties";
	private static final DAOFactory daoFactory = new DAOFactory(); 

	public static DAOFactory getDAOFactoryInstance() {
		return daoFactory;
	}

	public IDepartmentDAO getIDepartmentDAOInstance() {
		String empDao = readDaoFactoryProperties().getProperty("IDepartmentDAO");
		if(empDao.equalsIgnoreCase("DepartmentDAOImpl")) {
			return new DepartmentDAOImpl();
		} else {
			return new DepartmentDAOImpl();    // default  implementation
		}
	}
	
	public EmployeeDAOImpl getIEmployeeDAOInstance() {
		String empDao = readDaoFactoryProperties().getProperty("IEmployeeDAO");
		if(empDao.equalsIgnoreCase("EmployeeDAOImpl")) {
			return new EmployeeDAOImpl();
		} else {
			return new EmployeeDAOImpl();    // default  implementation
		}
	}

	private Properties readDaoFactoryProperties() {
		Properties props=null;
		try {
			InputStream is = new FileInputStream(DAO_FACTORY_CONFIG_FILE);
			props = new Properties();
			props.load(is);
			if(is != null) is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}
}
