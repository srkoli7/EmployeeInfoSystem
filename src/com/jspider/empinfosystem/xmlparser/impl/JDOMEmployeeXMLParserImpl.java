package com.jspider.empinfosystem.xmlparser.impl;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.jspider.empinfosystem.bean.Employee;
import com.jspider.empinfosystem.xmlparser.IEmployeeXMLParser;

public class JDOMEmployeeXMLParserImpl implements IEmployeeXMLParser {

	@Override
	public String generateEmployeeXML(Employee e) {
		Document xmlDoc  = new Document();
		Element rootElement = new Element("employees");
		xmlDoc.setRootElement(rootElement);

		Element employeeElement = new Element("employee");
		employeeElement.setAttribute("eid", "e"+e.getEmpID());
		rootElement.addContent(employeeElement);

		Element empIDElement = new Element("id");
		empIDElement.addContent(e.getEmpID()+"");
		employeeElement.addContent(empIDElement);

		Element empFirstNameElement = new Element("first_name");
		empFirstNameElement.addContent(e.getEmpFirstName());
		employeeElement.addContent(empFirstNameElement);

		Element empLastNameElement = new Element("last_name");
		empLastNameElement.addContent(e.getEmpLastName());
		employeeElement.addContent(empLastNameElement);

		Element empSalaryElement = new Element("salary");
		empSalaryElement.addContent(e.getEmpSal()+"");
		employeeElement.addContent(empSalaryElement);

		Element empDeptNameElement = new Element("department_name");
		empDeptNameElement.addContent(e.getEmpDept());
		employeeElement.addContent(empDeptNameElement);

		String formatedXMLContent = new XMLOutputter(Format.getPrettyFormat()).outputString(xmlDoc);
		return formatedXMLContent;
	}

	@Override
	public String generateEmployeeXML(List<Employee> empList) {
		Document xmlDoc  = new Document();
		Element rootElement = new Element("employees");
		xmlDoc.setRootElement(rootElement);
		for(Employee e:empList) {
			Element employeeElement = new Element("employee");
			employeeElement.setAttribute("eid", "e"+e.getEmpID());
			rootElement.addContent(employeeElement);

			Element empIDElement = new Element("id");
			empIDElement.addContent(e.getEmpID()+"");
			employeeElement.addContent(empIDElement);

			Element empFirstNameElement = new Element("first_name");
			empFirstNameElement.addContent(e.getEmpFirstName());
			employeeElement.addContent(empFirstNameElement);

			Element empLastNameElement = new Element("last_name");
			empLastNameElement.addContent(e.getEmpLastName());
			employeeElement.addContent(empLastNameElement);

			Element empSalaryElement = new Element("salary");
			empSalaryElement.addContent(e.getEmpSal()+"");
			employeeElement.addContent(empSalaryElement);

			Element empDeptNameElement = new Element("department_name");
			empDeptNameElement.addContent(e.getEmpDept());
			employeeElement.addContent(empDeptNameElement);
		}
		String formatedXMLContent = new XMLOutputter(Format.getPrettyFormat()).outputString(xmlDoc);
		return formatedXMLContent;
	}

}
