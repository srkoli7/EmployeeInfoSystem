package com.jspider.empinfosystem.dao.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.jspider.empinfosystem.dao.IEmployeeDao;
import com.jspider.empinfosystem.dao.impl.EmployeeDaoImpl;

/**
 * @author : Santosh Koli
 * @createdDate : Jun 24, 2014
 * @projectName : assignment_1_proj_v2
 */
public class EmployeeDaoFactory {
	private String DAO_FACTORY_CONFIG_FILE = "config/daofactoryconfig.properties";
	public static EmployeeDaoFactory getEmployeeDaoFactoryInstance() {
		return new EmployeeDaoFactory();
	}

	public IEmployeeDao getIEmployeeDao() {
		String empDao = getDaoFactoryProperties().getProperty("IEmployeeDao");
		if(empDao.equalsIgnoreCase("EmployeeDaoImpl")) {
			return new EmployeeDaoImpl();
		} else {
			return new EmployeeDaoImpl();    // default  implementation
		}
	}

	private Properties getDaoFactoryProperties() {
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

