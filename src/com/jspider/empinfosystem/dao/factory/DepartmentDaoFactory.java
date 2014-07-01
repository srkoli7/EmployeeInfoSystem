package com.jspider.empinfosystem.dao.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.jspider.empinfosystem.dao.IDepartmentDao;
import com.jspider.empinfosystem.dao.impl.DepartmentDaoImpl;

/**
 * @author : Santosh Koli
 * @createdDate : Jun 24, 2014
 * @projectName : assignment_1_proj_v2
 */
public class DepartmentDaoFactory {
	private String DAO_FACTORY_CONFIG_FILE = "config/daofactoryconfig.properties";
	public static DepartmentDaoFactory getDepartmentDaoFactoryInstance() {
		return new DepartmentDaoFactory();
	}

	public IDepartmentDao getDepartmentDaoInstance() {
		String empDao = getDaoFactoryProperties().getProperty("IDepartmentDao");
		if(empDao.equalsIgnoreCase("DepartmentDaoImpl")) {
			return new DepartmentDaoImpl();
		} else {
			return new DepartmentDaoImpl();    // default  implementation
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

