package com.jspider.empinfosystem.xmlparser;

import java.util.ArrayList;
import java.util.List;

import com.jspider.empinfosystem.bean.Employee;

public interface IEmployeeXMLParser {
	public String generateEmployeeXML(Employee e);
	public String generateEmployeeXML(List<Employee> empList);
}
