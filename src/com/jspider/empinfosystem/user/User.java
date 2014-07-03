package com.jspider.empinfosystem.user;

import java.util.List;
import java.util.Scanner;

import com.jspider.empinfosystem.bean.Department;
import com.jspider.empinfosystem.bean.Employee;
import com.jspider.empinfosystem.dao.IEmployeeDao;
import com.jspider.empinfosystem.dao.factory.DepartmentDaoFactory;
import com.jspider.empinfosystem.dao.factory.EmployeeDaoFactory;
import com.jspider.empinfosystem.xmlparser.IEmployeeXMLParser;
import com.jspider.empinfosystem.xmlparser.factory.EmployeeXMLParserFactory;

/**
 * @author : Santosh Koli
 * @createdDate : Jun 11, 2014
 * @projectName : assignment_1_proj
 */
public class User {
	public void readEmployeeDetail() {
		Scanner scan = new Scanner(System.in);
		IEmployeeDao edao = EmployeeDaoFactory.getEmployeeDaoFactoryInstance().getIEmployeeDao();

		System.out.print("Enter employee ID : ");
		Employee e = edao.getEmployee(scan.nextInt());

		displayEmployeeInfo(e);
		if(e!=null) {
			System.out.print("Do you want to download XML file?(yes/no) : ");
			boolean xmlDownload = scan.next().equalsIgnoreCase("yes");
			if (xmlDownload) {
				IEmployeeXMLParser xmlParser = EmployeeXMLParserFactory.getEmployeeXMLParserFactoryInstance().getEmployeeXMLParserInstance();
				xmlParser.generateEmployeeXML(e);
			}
		}
		//scan.close();
	}

	public void readEmployeesDetailsByDept() {
		Scanner scan = new Scanner(System.in);
		IEmployeeDao eDao = EmployeeDaoFactory.getEmployeeDaoFactoryInstance().getIEmployeeDao();
		System.out.print("\nDepartments");
		List<Department> deptNameList = DepartmentDaoFactory.getDepartmentDaoFactoryInstance().getDepartmentDaoInstance().getAllDepartmentNames();
		displayDepartmentNames(deptNameList);
		System.out.print("\nSelect the department number : ");
		List<Employee> empList = eDao.getEmployeesByDept(deptNameList.get(scan.nextInt()-1).getDeptName());

		displayEmployeeInfo(empList);
		if(empList.size()!=0) {
			System.out.print("Do you want to download XML file?(yes/no) : ");
			boolean xmlDownload = scan.next().equalsIgnoreCase("yes");
			if (xmlDownload) {
				IEmployeeXMLParser xmlParser = EmployeeXMLParserFactory.getEmployeeXMLParserFactoryInstance().getEmployeeXMLParserInstance();
				xmlParser.generateEmployeeXML(empList);
			}
		}
		//scan.close();
	}

	public void readEmployeesDetailsBySalaryRange() {
		Scanner scan = new Scanner(System.in);
		IEmployeeDao eDao = EmployeeDaoFactory.getEmployeeDaoFactoryInstance().getIEmployeeDao();
		System.out.print("Enter minimum salary :");
		double minSalary = scan.nextDouble();
		System.out.print("Enter maximum salary :");
		double maxSalary = scan.nextDouble();
		List<Employee> empList = eDao.getEmployeesBySalaryRange(minSalary, maxSalary);

		displayEmployeeInfo(empList);
		if(empList.size()!=0) {
			System.out.print("Do you want to download XML file?(yes/no) : ");
			boolean xmlDownload = scan.next().equalsIgnoreCase("yes");
			if (xmlDownload) {
				IEmployeeXMLParser xmlParser = EmployeeXMLParserFactory.getEmployeeXMLParserFactoryInstance().getEmployeeXMLParserInstance();
				xmlParser.generateEmployeeXML(empList);
			}
		}
		//scan.close();
	}

	public void displayEmployeeInfo(Employee emp)
	{
		System.out.print("\n-----------------------------------------------------------------------");
		System.out.printf("\n| %s | %s | %s | %s | %s |","ID  ","FIRST NAME  ","LAST NAME      ","SALARY ","DEPARTMENT       ");
		System.out.print("\n-----------------------------------------------------------------------");
		if(emp != null) {
			System.out.printf("\n| %4d | %12s | %15s | %7.2f | %17s |", emp.getEmpID(),emp.getEmpFirstName(),emp.getEmpLastName(),emp.getEmpSal(),emp.getEmpDept());
		}
		System.out.print("\n-----------------------------------------------------------------------");
		System.out.println("\n");
	}

	public void displayEmployeeInfo(List<Employee> empList)
	{
		System.out.print("\n-----------------------------------------------------------------------");
		System.out.printf("\n| %s | %s | %s | %s | %s |","ID  ","FIRST NAME  ","LAST NAME      ","SALARY ","DEPARTMENT       ");
		System.out.print("\n-----------------------------------------------------------------------");
		for(Employee emp:empList) {
			System.out.printf("\n| %4d | %12s | %15s | %7.2f | %17s |", emp.getEmpID(),emp.getEmpFirstName(),emp.getEmpLastName(),emp.getEmpSal(),emp.getEmpDept());
		}
		System.out.print("\n-----------------------------------------------------------------------");
		System.out.println("\n");
	}

	public void displayDepartmentNames(List<Department> deptList) {
		int count = 1;
		System.out.print("\n--------------------------");
		System.out.printf("\n| %s | %s |","No","NAME             ");
		System.out.print("\n--------------------------");
		for(Department dept: deptList) {
			System.out.printf("\n| %2d | %17s |",count++,dept.getDeptName());
		}
		System.out.print("\n--------------------------");
	}

}

