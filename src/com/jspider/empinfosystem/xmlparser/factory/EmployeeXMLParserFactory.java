package com.jspider.empinfosystem.xmlparser.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.jspider.empinfosystem.xmlparser.IEmployeeXMLParser;
import com.jspider.empinfosystem.xmlparser.impl.JDOMEmployeeXMLParserImpl;

public class EmployeeXMLParserFactory {
	private String XML_FACTORY_CONFIG_FILE = "config/xmlfactoryconfig.properties";
	private IEmployeeXMLParser empXMLParser= null;
	public static EmployeeXMLParserFactory getEmployeeXMLParserFactoryInstance() {
		return new EmployeeXMLParserFactory(); 
	}

	public IEmployeeXMLParser getEmployeeXMLParserInstance() {
		File file = new File(XML_FACTORY_CONFIG_FILE);
		Properties props = new Properties();
		FileInputStream is = null;

		try {
			is = new FileInputStream(file);
			props.load(is);
			is.close();
			String EmployeeXMLParserImpl = props.getProperty("IEmployeeXMLParser");
			if (EmployeeXMLParserImpl.equals("JDOMEmployeeXMLParserImpl")) {
				empXMLParser = new JDOMEmployeeXMLParserImpl();
			} else {
				empXMLParser = new JDOMEmployeeXMLParserImpl();   //default implementation
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return empXMLParser;
	}
}
